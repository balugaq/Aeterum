package me.figgnus.aeterum.gods.hades;

import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.ZombieHorse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieHorseAbilityListener implements Listener {
    private final Aeterum plugin;

    public ZombieHorseAbilityListener(Aeterum plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // Check if the player is riding a horse
        if (player.isInsideVehicle() && player.getVehicle() instanceof ZombieHorse) {
            ZombieHorse zombieHorse = (ZombieHorse) player.getVehicle();
            String metadataValue = plugin.getEntityMetadata(zombieHorse, ZombieHorseTameListener.LAVA_WALKER);

            // Check if the horse has the Frost Walker ability
            if ("true".equals(metadataValue)) {
                // Get the horse's location
                Location horseLocation = zombieHorse.getLocation();
                // Define a 2x2 area around the horse
                int[][] offsets = {
                        {0, 0},
                        {1, 0},
                        {0, 1},
                        {1, 1}
                };
                for (int[] offset : offsets) {
                    // Get the block under each position in the 2x2 area
                    Block blockUnder = horseLocation.clone().add(offset[0], -1, offset[1]).getBlock();

                    // Check if the block under the horse is lava
                    if (blockUnder.getType() == Material.LAVA) {
                        if (!player.hasPermission(GodsUtils.hadesPermission)) {
                            player.sendMessage(GodsUtils.permissionItemMessage);
                            return;
                        }
                        // Convert water to basalt
                        blockUnder.setType(Material.BASALT);

                        // Spawn particle effect when converting to basalt
                        blockUnder.getWorld().spawnParticle(Particle.SMOKE_LARGE, blockUnder.getLocation().add(0.5, 0.5, 0.5), 10, 0.2, 0.2, 0.2, 0.02);

                        // Schedule a task to revert ice back to lava after a delay
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (blockUnder.getType() == Material.BASALT) {
                                    // Spawn particle effect when reverting back to lava
                                    blockUnder.getWorld().spawnParticle(Particle.LAVA, blockUnder.getLocation().add(0.5, 0.5, 0.5), 10, 0.2, 0.2, 0.2, 0.02);
                                    blockUnder.setType(Material.LAVA);
                                }
                            }
                        }.runTaskLater(plugin, 100); // 100 ticks = 5 seconds
                    }
                }
            }
        }
    }
}
