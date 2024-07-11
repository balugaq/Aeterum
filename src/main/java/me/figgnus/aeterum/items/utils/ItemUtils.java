package me.figgnus.aeterum.items.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.List;
import java.util.Map;

public class ItemUtils  {

    public static boolean isOurCustomItem(ItemStack item, String name) {
        // Check if the item is your custom Slimefun item
        return item != null && item.getItemMeta() != null && item.getItemMeta().hasDisplayName() &&
                item.getItemMeta().getDisplayName().equals(name);
    }
    public static void configureMeta(SlimefunItemStack item, Color color, List<Map.Entry<Enchantment, Integer>> enchantments){
        if (item.getType() == Material.POTION){
            PotionMeta meta = (PotionMeta) item.getItemMeta();
            assert meta != null;
            meta.setColor(color);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            item.setItemMeta(meta);
        }else{
            ItemMeta meta = item.getItemMeta();
            for (Map.Entry<Enchantment, Integer> enchantment : enchantments){
                assert meta != null;
                meta.addEnchant(enchantment.getKey(), enchantment.getValue(), true);
            }
            item.setItemMeta(meta);
        }
    }
}
