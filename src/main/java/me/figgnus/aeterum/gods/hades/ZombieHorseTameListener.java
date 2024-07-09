package me.figgnus.aeterum.gods.hades;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class ZombieHorseTameListener extends SlimefunItem implements Listener {
    private final String METADATA_KEY = "HadesFeed";
    public static final String LAVA_WALKER = "LavaWalker";
    private final Aeterum plugin;
    Random random = new Random();

    public ZombieHorseTameListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Horse) {
            Horse horse = (Horse) event.getRightClicked();
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null)return;
            if (item.getItemMeta() == null)return;
            if (ItemUtils.isOurCustomItem(item, getItemName())){
                if (!player.hasPermission("aeterum.hades.use")) {
                    player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít tento předmět");
                    return;
                }
                if (player.getGameMode() == GameMode.SURVIVAL){
                    item.setAmount(item.getAmount() - 1);
                }
                plugin.setEntityMetadata(horse, METADATA_KEY, "true");

                player.sendMessage("Nakrmil/a jsi koně lektvarem. Niní můžeš koně ochočit.");
            }
        }
    }
    @EventHandler
    public void onEntityTame(EntityTameEvent event) {
        if (event.getEntity() instanceof Horse) {
            Horse horse = (Horse) event.getEntity();
            Player player = (Player) event.getOwner();

            String metadataValue = plugin.getEntityMetadata(horse, METADATA_KEY);

            // Check if the horse has been fed the special item
            if ("true".equals(metadataValue)) {
                // Remove the horse
                Location location = horse.getLocation();
                horse.remove();

                // Spawn zombie horse at the same location
                ZombieHorse zombieHorse = (ZombieHorse) horse.getWorld().spawnEntity(location, EntityType.ZOMBIE_HORSE);

                // Apply setting to the zombie horse
                double speed = random.nextDouble(0.3, 0.3375);
                double jump = random.nextDouble(0.9, 1.1);
                int health = random.nextInt(25, 30);

                // Change horse appearance and stats
                zombieHorse.setTamed(true);
                zombieHorse.setOwner(player);

                // Set horse stats
                zombieHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed); // Fast speed
                zombieHorse.getAttribute(Attribute.HORSE_JUMP_STRENGTH).setBaseValue(jump); // High jump

                zombieHorse.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, -1, 1));
                zombieHorse.setMaxHealth(health);
                zombieHorse.setHealth(health);

                // Set metadata to indicate the horse has frost walker ability
                plugin.setEntityMetadata(zombieHorse, LAVA_WALKER, "true");

                player.sendMessage("Tvůj kůň se proměnil!");
            }
        }
    }
}
