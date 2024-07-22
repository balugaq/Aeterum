package me.figgnus.aeterum.gods.hades;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DarknessPotionListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    public DarknessPotionListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission(GodsUtils.hadesPermission)){
                player.sendMessage(GodsUtils.permissionItemMessage);
                return;
            }
            applyEffect(player);
        }
    }

    private void applyEffect(Player player) {
        new DarknessEffectTask(player).runTaskTimer(plugin, 0, 20);
    }
    private static class DarknessEffectTask extends BukkitRunnable{
        private final Player player;
        private int interaction = 0;
        private final int radius = 10;

        private DarknessEffectTask(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            if (interaction >= 20){
                cancel();
                return;
            }
            for (Player nearbyPlayer : player.getWorld().getPlayers()) {
                if (nearbyPlayer.equals(player)) {
                    continue; // Skip the player who drank the potion
                }
                if (nearbyPlayer.getLocation().distance(player.getLocation()) <= radius) {
                    nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 1));
                    nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0));
                    nearbyPlayer.getWorld().spawnParticle(Particle.DAMAGE_INDICATOR, nearbyPlayer.getLocation(), 30, 0.5, 0.5, 0.5, 0);
                }
            }
            spawnParticles(player.getLocation());
            interaction++;
        }

        private void spawnParticles(Location center) {
            for (int i = 0; i < 360; i += 10) { // 10-degree increments
                double radians = Math.toRadians(i);
                double x = center.getX() + radius * Math.cos(radians);
                double z = center.getZ() + radius * Math.sin(radians);
                Location particleLocation = new Location(center.getWorld(), x, center.getY(), z);
                center.getWorld().spawnParticle(Particle.SPELL_WITCH, particleLocation, 1);
            }
        }
    }
}
