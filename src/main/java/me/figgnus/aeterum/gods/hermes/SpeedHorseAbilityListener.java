package me.figgnus.aeterum.gods.hermes;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SpeedHorseAbilityListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    public SpeedHorseAbilityListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission("aeterum.hermes.use")){
                player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít tento předmět");
                return;
            }
            Horse horse = (Horse) player.getVehicle();
            String metadataValue = plugin.getEntityMetadata(horse, SpeedHorseTameListener.SPEED_KEY);
            if ("true".equals(metadataValue)){
                if (player.getGameMode() == GameMode.SURVIVAL){
                    item.setAmount(item.getAmount() - 1);
                }
                // Apply levitation effect to the horse
                horse.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3)); // 100 ticks = 5 seconds
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3)); // 100 ticks = 5 seconds
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (!horse.hasPotionEffect(PotionEffectType.SPEED)) {
                            this.cancel(); // Cancel the task if the horse no longer has the speed effect
                            return;
                        }
                        // Spawn particles at the horse's location
                        horse.getWorld().spawnParticle(Particle.CLOUD, horse.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0.02);
                    }
                }.runTaskTimer(plugin, 0, 5); // Run task every 5 ticks (0.25 seconds)
            }
        }
    }
}
