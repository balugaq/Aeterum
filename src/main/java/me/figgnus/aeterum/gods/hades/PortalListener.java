package me.figgnus.aeterum.gods.hades;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PortalListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    public PortalListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerThrow(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission(GodsUtils.hadesPermission)){
                player.sendMessage(GodsUtils.permissionItemMessage);
                return;
            }
            Location loc = player.getLocation();
            createPortal(loc);
            player.sendMessage(ChatColor.GOLD + "请勿在传送时移动");
            player.getWorld().playSound(loc, Sound.BLOCK_PORTAL_TRAVEL, 1.0F, 1.0F);
        }
    }

    public void createPortal(Location loc) {
        World world = loc.getWorld();

        // Create the oval portal
        new BukkitRunnable() {
            int ticks = 0;
            @Override
            public void run() {
                if (ticks >= 100) { // 5 seconds (20 ticks per second)
                    cancel();
                    return;
                }

                for (double y = 0; y <= 2; y += 0.05) {
                    double x = Math.sin(y * Math.PI);
                    double z = Math.cos(y * Math.PI);
                    world.spawnParticle(Particle.PORTAL, loc.clone().add(x, y, z), 1);
                    world.spawnParticle(Particle.PORTAL, loc.clone().add(-x, y, z), 1);
                }
                ticks++;
            }
        }.runTaskTimer(plugin, 0, 1);

        // Teleport players and remove the portal after a few seconds
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : world.getPlayers()) {
                    if (player.getLocation().distance(loc) <= 1) {
                        player.teleport(world.getEnvironment() == World.Environment.NETHER ? (Location) Bukkit.getWorld("world") : Bukkit.getWorld("world_nether").getSpawnLocation());
                    }
                }
                // Remove the portal particles (handled by canceling the particle task above)
            }
        }.runTaskLater(plugin, 100); // 5 seconds
    }
}
