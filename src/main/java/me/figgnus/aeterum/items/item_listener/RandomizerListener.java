package me.figgnus.aeterum.items.item_listener;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Orientable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.*;

public class RandomizerListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    public RandomizerListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerUuid = player.getUniqueId();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission("trowel.use")){
                player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít tento předmět");
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
            BlockFace blockFace = event.getBlockFace();


            if (clickedBlock != null && blockFace != null) {
                // Calculate the position for the new block
                Block adjacentBlock = clickedBlock.getRelative(blockFace);
                //select random block viz lower method
                Material selectMaterial = selectRandomMaterial(player);

                if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
                    // Place the block if the adjacent block is air
                    if (adjacentBlock.getType() == Material.AIR && !(isLocationOccupied(adjacentBlock.getLocation()))) {
                        adjacentBlock.setType(selectMaterial);
                        setBlockOrientation(adjacentBlock, blockFace ,selectMaterial);

                        //Play sound
                        playPlacemendSound(player, selectMaterial);

                        // Subtract from inventory if in survival mode
                        if (player.getGameMode() == GameMode.SURVIVAL) {
                            subtractMaterialFromInventory(player, selectMaterial);
                        }
                    }
                }
            }
            cooldowns.put(playerUuid, System.currentTimeMillis());
        }
    }
    private void setBlockOrientation(Block block, BlockFace face, Material material) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Directional) {
            Directional directional = (Directional) blockData;
            directional.setFacing(face.getOppositeFace());
            block.setBlockData(directional);
        } else if (blockData instanceof Orientable) {
            Orientable orientable = (Orientable) blockData;
            switch (face) {
                case UP:
                case DOWN:
                    orientable.setAxis(Axis.Y);
                    break;
                case NORTH:
                case SOUTH:
                    orientable.setAxis(Axis.Z);
                    break;
                case EAST:
                case WEST:
                    orientable.setAxis(Axis.X);
                    break;
            }
            block.setBlockData(orientable);
        }
    }

    private boolean isLocationOccupied(Location location) {
        World world = location.getWorld();
        if (world == null){
            return false;
        }
        List<Entity> entities = (List<Entity>) world.getNearbyEntities(location, 0.5,0.5,0.5);
        for (Entity entity : entities){
            if(!(entity instanceof Item) && !(entity instanceof ExperienceOrb)){
                //found entity that is not an item or experience orb
                return true;
            }
        }
        return false;
    }

    //Play sound method
    private void playPlacemendSound(Player player, Material selectMaterial) {
        Sound sound = getSoundOfMaterial(selectMaterial);
        if (sound != null) {
            player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
        }
    }

    //Getting the sound
    private Sound getSoundOfMaterial(Material selectMaterial) {

        return Sound.BLOCK_AMETHYST_BLOCK_PLACE;
    }

    private void subtractMaterialFromInventory(Player player, Material selectMaterial) {
        PlayerInventory inventory = player.getInventory();


        for (int i = 0; i < 9; i++) {
            ItemStack item = inventory.getItem(i);
            if (item != null && item.getType() == selectMaterial) {
                int amount = item.getAmount();
                if (amount > 1) {
                    item.setAmount(amount - 1);
                } else {
                    inventory.clear(i);
                }
                break;
            }
        }
    }

    private Material selectRandomMaterial(Player player) {
        ArrayList<Material> materials = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ItemStack item = player.getInventory().getItem(i);
            if (item != null && item.getType().isBlock() && item.getAmount() > 0) {
                materials.add(item.getType());
            }
        }
        if (materials.isEmpty()) {
            return Material.AIR;
        }
        Random random = new Random();
        return materials.get(random.nextInt(materials.size()));
    }
}
