package me.figgnus.aeterum.items.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionType;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.bukkit.util.Vector;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ItemUtils  {
    // UUID for creating custom player heads
    private static final UUID RANDOM_UUID = UUID.fromString("92864445-51c5-4c3b-9039-517c9927d1b4"); // We reuse the same "random" UUID all the time

    // Checks if item is custom
    public static boolean isOurCustomItem(ItemStack item, String name) {
        // Check if the item is your custom Slimefun item
        return item != null && item.getItemMeta() != null && item.getItemMeta().hasDisplayName() &&
                item.getItemMeta().getDisplayName().equals(name);
    }
    // Configures metadata of custom Slimefun items
    public static void configureMeta(SlimefunItemStack item, Color color, List<Map.Entry<Enchantment, Integer>> enchantments){
        if (item.getType() == Material.POTION || item.getType() == Material.SPLASH_POTION){
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
    // Creates basic potion
    public static ItemStack createPotion(PotionType potionType){
        ItemStack potion = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        assert meta != null;
        meta.setBasePotionType(potionType);
        potion.setItemMeta(meta);
        return potion;
    }
    // Methods for creating head item stack
    private static PlayerProfile getProfile(String url) {
        PlayerProfile profile = Bukkit.createPlayerProfile(RANDOM_UUID); // Get a new player profile
        PlayerTextures textures = profile.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(url); // The URL to the skin, for example: https://textures.minecraft.net/texture/18813764b2abc94ec3c3bc67b9147c21be850cdf996679703157f4555997ea63a
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Invalid URL", exception);
        }
        textures.setSkin(urlObject); // Set the skin of the player profile to the URL
        profile.setTextures(textures); // Set the textures back to the profile
        return profile;
    }
    public static ItemStack createHead(String texture){
        String url = "https://textures.minecraft.net/texture/" + texture;
        PlayerProfile profile = getProfile(url);
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwnerProfile(profile);
        head.setItemMeta(meta);
        return head;
    }
    // Checks if player has permission to use certain items and executes logic
    public static void inventoryInteractCheck(InventoryClickEvent event, String itemName, String permission){
        if (event.getWhoClicked() instanceof Player player){
          ItemStack item = event.getCurrentItem();
            if (ItemUtils.isOurCustomItem(item, itemName)) {
                if (!player.hasPermission(permission)) {
                    dropItemInFront(player, item);
                    player.getInventory().remove(item);
                    event.getInventory().remove(item);
                    event.setCursor(null);
                    player.closeInventory();
                    if (ItemUtils.isOurCustomItem(player.getInventory().getHelmet(), itemName)){
                        player.getInventory().setHelmet(null);
                    }
                    player.sendMessage(ChatColor.GOLD + "Nemáš oprávnění používat tento předmět. Byl vyhozen z inventáře.");
                    event.setCancelled(true);
                }
            }
        }
    }
    public static void playerInteractCheck(PlayerInteractEvent event, String itemName, String permission){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (ItemUtils.isOurCustomItem(item, itemName)){
            if (!player.hasPermission(permission)){
                dropItemInFront(player, item);
                player.getInventory().remove(item);
                player.sendMessage( ChatColor.GOLD + "Nemáš oprávnění používat tento předmět. Byl vyhozen z inventáře.");
                event.setCancelled(true);
            }
        }
    }
    // Helper method for checking permission methods
    private static void dropItemInFront(Player player, ItemStack item) {
        Location loc = player.getLocation();
        Vector direction = loc.getDirection().normalize();
        Location dropLocation = loc.add(direction.multiply(3));
        player.getWorld().dropItemNaturally(dropLocation, item);
    }
}
