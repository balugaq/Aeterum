package me.figgnus.aeterum.gods.zeus;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class LightningSpearListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    public LightningSpearListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onEntityHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Trident trident){
            if (trident.getShooter() instanceof Player player){
                ItemStack item = trident.getItem();
                if (ItemUtils.isOurCustomItem(item, getItemName())){
                    if (!player.hasPermission(GodsUtils.zeusPermission)){
                        player.sendMessage(GodsUtils.permissionItemMessage);
                        return;
                    }
                    if (event.getHitEntity() != null){
                        Entity hitEntity = event.getHitEntity();
                        hitEntity.getWorld().strikeLightning(hitEntity.getLocation());
                    } else if (event.getHitBlock() != null) {
                        trident.getWorld().strikeLightning(event.getHitBlock().getLocation());
                    }
                }
            }
        }
    }
}
