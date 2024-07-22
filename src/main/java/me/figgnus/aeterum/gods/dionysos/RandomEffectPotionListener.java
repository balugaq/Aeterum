package me.figgnus.aeterum.gods.dionysos;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class RandomEffectPotionListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private final List effects = List.of(PotionEffectType.SPEED,
            PotionEffectType.JUMP,
            PotionEffectType.DAMAGE_RESISTANCE,
            PotionEffectType.INCREASE_DAMAGE,
            PotionEffectType.POISON,
            PotionEffectType.NIGHT_VISION,
            PotionEffectType.BLINDNESS,
            PotionEffectType.FAST_DIGGING,
            PotionEffectType.LUCK);
    public RandomEffectPotionListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!player.hasPermission(GodsUtils.dionysusPermission)){
                player.sendMessage(GodsUtils.permissionItemMessage);
                return;
            }
            applyRandomEffect(player);
        }
    }

    private void applyRandomEffect(Player player) {
        Random random = new Random();
        int index = random.nextInt(0, effects.size());
        int duration = random.nextInt(20, 600);
        int amplifier = random.nextInt(1, 3);
        player.addPotionEffect(new PotionEffect((PotionEffectType) effects.get(index), duration, amplifier, false));
    }
}
