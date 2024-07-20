package me.figgnus.aeterum.gods.hermes;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;


public class SpeedBootsListener extends SlimefunItem implements Listener {
    private final Aeterum plugin;
    private static final HashMap<UUID, Long> messageCooldowns = new HashMap<>();
    private static final long COOLDOWN_TIME = 5000;
    public SpeedBootsListener(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Aeterum plugin) {
        super(itemGroup, item, recipeType, recipe);
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getBoots();

        if (ItemUtils.isOurCustomItem(item, getItemName())){
            if (!(player.hasPermission("aeterum.speedboots.use"))){
                long currentTime = System.currentTimeMillis();
                UUID playerUUID = player.getUniqueId();
                if (!messageCooldowns.containsKey(playerUUID) || (currentTime - messageCooldowns.get(playerUUID) > COOLDOWN_TIME)){
                    player.sendMessage(ChatColor.RED + "Nemáš oprávnění použít tento předmět");
                    messageCooldowns.put(playerUUID, currentTime);
                }
                return;
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2, false));
        }
    }
}
