package me.figgnus.aeterum.gods.demeter;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;


public class HoeOfHarvestListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    public HoeOfHarvestListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;
        
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onItemUse(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        UUID playerUuid = player.getUniqueId();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission(GodsUtils.demeterPermission)){
                player.sendMessage(GodsUtils.permissionItemMessage);
                return;
            }
            //Check cooldown
            if (cooldowns.containsKey(playerUuid)) {
                long lastPlaced = cooldowns.get(playerUuid);
                long timeNow = System.currentTimeMillis();

                if (timeNow - lastPlaced < 100) {
                    return;
                }
            }
            Block clickedBlock = event.getClickedBlock();
            if (clickedBlock == null || !isFullyGrownCrop(clickedBlock)){
                return;
            }
            // Harvest and replant crops in a 3x3 area around the clicked block
            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    Block block = clickedBlock.getRelative(dx, 0, dz);
                    if (isFullyGrownCrop(block)) {
                        harvestAndReplant(block);
                    }
                }
            }
            cooldowns.put(playerUuid, System.currentTimeMillis());
        }
    }
    private boolean isFullyGrownCrop(Block block) {
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) block.getBlockData();
            return ageable.getAge() == ageable.getMaximumAge();
        }
        return false;
    }
    private void harvestAndReplant(Block block) {
        Material cropType = block.getType();
        block.setType(Material.AIR); // Remove the crop

        switch (cropType) {
            case WHEAT:
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.WHEAT));
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.WHEAT_SEEDS));
                break;
            case POTATOES:
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.POTATO));
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.POTATO));
                // Potatoes can drop poisonous potatoes as well
                break;
            case CARROTS:
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CARROT));
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CARROT));
                break;
            case BEETROOTS:
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BEETROOT));
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BEETROOT_SEEDS));
                break;
            default:
                // Handle other crops if necessary
                break;
        }

        // Replant the crop
        block.setType(cropType);
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) block.getBlockData();
            ageable.setAge(0); // Reset the age to zero (replanting)
            block.setBlockData(ageable);
        }
    }
}
