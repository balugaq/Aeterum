package me.figgnus.aeterum.gods.hermes;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class MessengerPackListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private final Map<UUID, Inventory> playerInventories = new HashMap<>();
    private final File inventoryFolder;

    public MessengerPackListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

        // Set up the folder for saving player inventories
        inventoryFolder = new File(plugin.getDataFolder(), "inventories");
        if (!inventoryFolder.exists()) {
            inventoryFolder.mkdirs();
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerRightClickEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();
        if (ItemUtils.isOurCustomItem(item, getItemName())) {
            if (!player.hasPermission(GodsUtils.hermesPermission)) {
                player.sendMessage(GodsUtils.permissionItemMessage);
                return;
            }
            player.openInventory(getPlayerInventory(player));
        }
    }

    public Inventory getPlayerInventory(Player player) {
        UUID playerUUID = player.getUniqueId();
        if (!playerInventories.containsKey(playerUUID)) {
            playerInventories.put(playerUUID, loadInventory(playerUUID));
        }
        return playerInventories.get(playerUUID);
    }

    public void saveInventory(UUID playerUUID) {
        Inventory inventory = playerInventories.get(playerUUID);
        if (inventory == null) return;

        File inventoryFile = new File(inventoryFolder, playerUUID.toString() + ".yml");
        FileConfiguration inventoryConfig = YamlConfiguration.loadConfiguration(inventoryFile);

        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = inventory.getItem(i);
            inventoryConfig.set("inventory.slot" + i, item);
        }
        try {
            inventoryConfig.save(inventoryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Inventory loadInventory(UUID playerUUID) {
        Inventory inventory = Bukkit.createInventory(null, 54, "商人的包袱");
        File inventoryFile = new File(inventoryFolder, playerUUID.toString() + ".yml");
        if (inventoryFile.exists()) {
            FileConfiguration inventoryConfig = YamlConfiguration.loadConfiguration(inventoryFile);
            for (int i = 0; i < inventory.getSize(); i++) {
                ItemStack item = inventoryConfig.getItemStack("inventory.slot" + i);
                inventory.setItem(i, item);
            }
        }
        return inventory;
    }

    public void saveAllInventories() {
        for (UUID playerUUID : playerInventories.keySet()) {
            saveInventory(playerUUID);
        }
    }
}
