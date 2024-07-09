package me.figgnus.aeterum.gods.zeus;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Animals;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class BreedingItemListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private final HashMap<UUID, Long> cooldown = new HashMap<>();
    private static final long COOLDOWN_TIME = 1000; // Cooldown time in milliseconds (1 second)

    public BreedingItemListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void  onPlayerInteract(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        UUID playerId = player.getUniqueId();
        if (ItemUtils.isOurCustomItem(itemInHand, getItemName())){
            if (!player.hasPermission("aeterum.breeding.use")){
                player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít tento předmět");
                return;
            }
            // Check cooldown
            if (cooldown.containsKey(playerId) && (System.currentTimeMillis() - cooldown.get(playerId)) < COOLDOWN_TIME) {
                return;
            }
            if (event.getRightClicked() instanceof Animals) {
                Animals animal = (Animals) event.getRightClicked();
                EntityType type = animal.getType();

                if (!animal.isAdult()) {
                    return;
                }
                player.getWorld().spawnParticle(Particle.HEART, animal.getLocation().add(0, 1, 0), 30);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Animals baby = (Animals) animal.getWorld().spawnEntity(animal.getLocation(), type);
                        baby.setBaby();
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                        if (player.getGameMode() == GameMode.SURVIVAL) {
                            if (itemInHand.getAmount() == 1) {
                                player.getInventory().setItemInMainHand(null);
                            } else {
                                itemInHand.setAmount(itemInHand.getAmount() - 1);
                            }
                        }
                    }
                }.runTaskLater(plugin, 20L * 2); //2 seconds later


                // Update the cooldown
                cooldown.put(playerId, System.currentTimeMillis());
                event.setCancelled(true);
            }
        }
    }
}
