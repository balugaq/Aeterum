package me.figgnus.aeterum.gods.hades;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DarkPearlListener extends SlimefunItem implements Listener {
    private final Set<UUID> invulnerablePlayers = new HashSet<>();
    private final Aeterum plugin;
    public DarkPearlListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event){

    }
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof EnderPearl enderPearl){
            if (enderPearl.getShooter() instanceof Player player){
                ItemStack item = enderPearl.getItem();
                if (ItemUtils.isOurCustomItem(item, getItemName())){
                    if (!player.hasPermission(GodsUtils.hadesPermission)){
                        player.sendMessage(GodsUtils.permissionItemMessage);
                        return;
                    }
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 160, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, 0));
                    addTemporaryInvulnerability(player);
                }
            }
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (invulnerablePlayers.contains(player.getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
    private void addTemporaryInvulnerability(Player player) {
        UUID playerUUID = player.getUniqueId();
        invulnerablePlayers.add(playerUUID);

        // Remove invulnerability after 5 seconds (100 ticks) now 20
        Bukkit.getScheduler().runTaskLater(plugin, () -> invulnerablePlayers.remove(playerUUID), 20L);
    }
}
