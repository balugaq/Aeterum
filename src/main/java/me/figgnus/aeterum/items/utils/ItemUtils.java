package me.figgnus.aeterum.items.utils;

import org.bukkit.inventory.ItemStack;

public class ItemUtils  {

    public static boolean isOurCustomItem(ItemStack item, String name) {
        // Check if the item is your custom Slimefun item
        return item != null && item.getItemMeta() != null && item.getItemMeta().hasDisplayName() &&
                item.getItemMeta().getDisplayName().equals(name);
    }

}
