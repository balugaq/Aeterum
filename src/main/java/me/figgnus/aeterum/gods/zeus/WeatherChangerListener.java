package me.figgnus.aeterum.gods.zeus;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class WeatherChangerListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private String permission = "aeterum.zeus.use";
    private int ticks = 1200; // 1200 is 1 minute
    public WeatherChangerListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event){
        ItemStack item = event.getItem();
        Player player = event.getPlayer();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission(GodsUtils.zeusPermission)){
                player.sendMessage(GodsUtils.permissionItemMessage);
                return;
            }
            boolean wasStormy = player.getWorld().hasStorm();
            player.getWorld().setStorm(true);
            player.sendMessage("Zvedá se bouře na dalších " + ticks / 20 + " sekund.");
            // Schedule a task to revert the weather after 1 minute (1200 ticks)
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.getWorld().setStorm(wasStormy);
                    player.sendMessage("Počasí se vrací do normálu.");
                }
            }.runTaskLater(plugin, ticks);
        }
    }
}
