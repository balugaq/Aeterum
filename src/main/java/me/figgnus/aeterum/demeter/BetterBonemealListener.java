package me.figgnus.aeterum.demeter;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum._items.utils.ItemUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class BetterBonemealListener extends SlimefunItem implements Listener {
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final int COOLDOWN_TIME = 100;// Cooldown time in milliseconds
    private final Aeterum plugin;

    public BetterBonemealListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    private void onBlockRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission("aeterum.demeter.use")){
                player.sendMessage(ChatColor.RED + "You don't have permission to do this.");
                return;
            }
            long currentTime = System.currentTimeMillis();
            if (cooldowns.containsKey(player.getUniqueId())) {
                long lastUseTime = cooldowns.get(player.getUniqueId());
                if (currentTime - lastUseTime < COOLDOWN_TIME) {
                    return;
                }
            }
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
                Block block = event.getClickedBlock();
                if (block != null && (block.getType() == Material.CACTUS || block.getType() == Material.SUGAR_CANE)) {
                    Block above = block.getRelative(BlockFace.UP);
                    if (above.getType() == Material.AIR) {
                        // Grow cactus or sugar cane
                        above.setType(block.getType());
                        spawnGrowthParticle(above.getLocation().add(0.5, 0.5, 0.5));
                        if (player.getGameMode() == GameMode.SURVIVAL) {
                            event.getItem().setAmount(event.getItem().getAmount() - 1);
                        }
                        cooldowns.put(player.getUniqueId(), currentTime);
                    }
                }
            }
        }
    }
    private void spawnGrowthParticle(Location location) {
        location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 30, 0.5, 0.5, 0.5, 0);
    }
}
