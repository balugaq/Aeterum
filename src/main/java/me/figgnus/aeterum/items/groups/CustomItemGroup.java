package me.figgnus.aeterum.items.groups;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomItemGroup extends ItemGroup {
    private final String permission;
    public CustomItemGroup(NamespacedKey key, ItemStack item, String permission) {
        super(key, item);
        this.permission = permission;
    }

    @Override
    public boolean isVisible(@NotNull Player p) {
        return p.hasPermission(permission);
    }
}
