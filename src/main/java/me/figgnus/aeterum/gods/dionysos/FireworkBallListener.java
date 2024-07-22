package me.figgnus.aeterum.gods.dionysos;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkBallListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private NamespacedKey throwableKey;
    public FireworkBallListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onEntityHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Snowball snowball){
            if (snowball.getShooter() instanceof  Player player){
                ItemStack item = snowball.getItem();
                if (ItemUtils.isOurCustomItem(item, getItemName())){
                    if (!player.hasPermission(GodsUtils.dionysusPermission)){
                        player.sendMessage(GodsUtils.permissionItemMessage);
                        return;
                    }
                    Entity hitEntity = event.getHitEntity();
                    Block hitBlock = event.getHitBlock();

                    Location hitLocation;
                    if (hitEntity != null) {
                        hitLocation = hitEntity.getLocation();
                    } else if (hitBlock != null) {
                        hitLocation = hitBlock.getLocation();
                    } else {
                        return; // No valid hit location
                    }
                    // Adjust the Y-coordinate to spawn fireworks above the hit location
                    hitLocation.setY(hitLocation.getY() + 1);
                    // Spawn and launch fireworks upwards
                    for (int i = 0; i < 5; i++) {
                        Firework firework = (Firework) hitLocation.getWorld().spawnEntity(hitLocation, EntityType.FIREWORK);
                        FireworkMeta fireworkMeta = firework.getFireworkMeta();
                        fireworkMeta.addEffect(FireworkEffect.builder().withColor(org.bukkit.Color.RED, org.bukkit.Color.GREEN, org.bukkit.Color.BLUE).flicker(true).build());
                        fireworkMeta.setPower(2); // Set the power of the firework (1 is a good default)
                        firework.setFireworkMeta(fireworkMeta);
                    }
                }
            }
        }
    }
}
