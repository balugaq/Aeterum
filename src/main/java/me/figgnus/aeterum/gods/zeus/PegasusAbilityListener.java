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
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PegasusAbilityListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    public PegasusAbilityListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission("aeterum.zeus.use")){
                player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít tento předmět");
                return;
            }
            Horse horse = (Horse) player.getVehicle();
            String metadataValue = plugin.getEntityMetadata(horse, PegasusTameListener.LEVITATE_KEY);
            if ("true".equals(metadataValue)){
                if (player.getGameMode() == GameMode.SURVIVAL){
                    item.setAmount(item.getAmount() - 1);
                }
                // Apply levitation effect to the horse
                horse.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 180, 1)); // 100 ticks = 5 seconds
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 180, 1)); // 100 ticks = 5 seconds
                horse.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180, 5));

                // Schedule a task to apply fall damage immunity after Levitation ends
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        // Check if the horse and player still have the levitation effect
                        if (!horse.hasPotionEffect(PotionEffectType.LEVITATION)) {
                            // Apply fall damage immunity to the horse and player
                            horse.setMetadata("fallDamageImmune", new FixedMetadataValue(plugin, true));
                            player.setMetadata("fallDamageImmune", new FixedMetadataValue(plugin, true));

                            // Remove fall damage immunity after a duration
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    horse.removeMetadata("fallDamageImmune", plugin);
                                    player.removeMetadata("fallDamageImmune", plugin);
                                }
                            }.runTaskLater(plugin, 100); // 100 ticks = 5 seconds
                        }
                    }
                }.runTaskLater(plugin, getRemainingLevitationDuration(player) + 1); // Schedule the task after levitation duration ends
                // Schedule a repeating task to spawn particles while levitating
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (!horse.hasPotionEffect(PotionEffectType.LEVITATION)) {
                            this.cancel(); // Cancel the task if the horse is no longer levitating
                            return;
                        }
                        // Spawn particles at the horse's location
                        horse.getWorld().spawnParticle(Particle.CLOUD, horse.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0.05);
                    }
                }.runTaskTimer(plugin, 0, 5); // Run task every 5 ticks (0.25 seconds)
            }
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            Entity entity = event.getEntity();
            if (entity.hasMetadata("fallDamageImmune")) {
                event.setCancelled(true); // Cancel the fall damage
            }
        }
    }
    private long getRemainingLevitationDuration(Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            if (effect.getType().equals(PotionEffectType.LEVITATION)) {
                return effect.getDuration();
            }
        }
        return 0;
    }
}
