package me.figgnus.aeterum.gods.demeter;

import me.figgnus.aeterum.Aeterum;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class FlowerHorseAbilityListener implements Listener {
    private final List<Material> plantableMaterials = Arrays.asList(
            Material.WHEAT_SEEDS,
            Material.POTATO,
            Material.CARROT,
            Material.BEETROOT_SEEDS
    );
    private final Aeterum plugin;

    public FlowerHorseAbilityListener(Aeterum plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        // Check if the player is riding a horse
        if (player.isInsideVehicle() && player.getVehicle() instanceof Horse) {
            Horse horse = (Horse) player.getVehicle();
            String metadataValue = plugin.getEntityMetadata(horse, FlowerHorseTameListener.SEED_KEY);

            // Check if the horse has the Seed  ability
            if ("true".equals(metadataValue)) {
                // Get the block under the horse
                Block centerBlock = horse.getLocation().getBlock().getRelative(0, 0, 0);

                // Iterate through the 3x3 area under the horse
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        Block blockBelow = centerBlock.getRelative(dx, -1, dz);
                        Block blockBelowSave = centerBlock.getRelative(dx, 0, dz);

                        // Check if the block below is farmland
                        if (blockBelow.getType() == Material.FARMLAND || blockBelowSave.getType() == Material.FARMLAND) {
                            if (!player.hasPermission("aeterum.demeter.use")) {
                                player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít schopnost tohoto koně");
                                return;
                            }
                            // Check if the player has seeds in their inventory
                            for (Material material : plantableMaterials){
                                if (player.getInventory().contains(material) && blockBelow.getType() == Material.FARMLAND){
                                    plantSeeds(player, blockBelow, material);
                                    break;
                                }
                                if (player.getInventory().contains(material) && blockBelowSave.getType() == Material.FARMLAND){
                                    plantSeeds(player, blockBelowSave, material);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void plantSeeds(Player player, Block farmland, Material seedMaterial) {
        // Check the block above is farmland
        Block blockAbove = farmland.getRelative(0, 1, 0);
        Block blockBackup = farmland.getRelative(0,0,0);
        Location loc = blockAbove.getLocation();
        blockAbove.getWorld().spawnParticle(Particle.SPORE_BLOSSOM_AIR, loc, 10, 0.5, 0.5, 0.5, 0.01);
        blockBackup.getWorld().spawnParticle(Particle.SPORE_BLOSSOM_AIR, loc, 10, 0.5, 0.5, 0.5, 0.01);

        // Ensure the block above is air
        if (blockAbove.getType() == Material.AIR){
            // Plant seeds
            blockAbove.setType(getCropBlock(seedMaterial));

            // Remove seeds from inventory
            ItemStack seeds = new ItemStack(seedMaterial, 1);
            player.getInventory().removeItem(seeds);
        }
    }

    private Material getCropBlock(Material seedMaterial) {
        switch (seedMaterial) {
            case WHEAT_SEEDS:
                return Material.WHEAT;
            case POTATO:
                return Material.POTATOES;
            case CARROT:
                return Material.CARROTS;
            case BEETROOT_SEEDS:
                return Material.BEETROOTS;
            case PUMPKIN_SEEDS:
                return Material.PUMPKIN_STEM;
            case MELON_SEEDS:
                return Material.MELON_STEM;
            default:
                return Material.AIR; // Fallback, should not happen
        }
    }
}