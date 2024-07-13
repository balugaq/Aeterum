package me.figgnus.aeterum.gods.poseidon;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WaterBreathingCrown extends SlimefunItem implements Listener {
    private String permission = "aeterum.poseidon.use";
    private final Aeterum plugin;
    public WaterBreathingCrown(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        ItemUtils.inventoryInteractCheck(event, getItemName(), permission);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        ItemUtils.playerInteractCheck(event, getItemName(), permission);
    }

}
