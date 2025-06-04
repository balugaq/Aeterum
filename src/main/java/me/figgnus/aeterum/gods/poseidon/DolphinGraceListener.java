package me.figgnus.aeterum.gods.poseidon;

import me.figgnus.aeterum.gods.GodsUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;

public class DolphinGraceListener implements Listener, CommandExecutor {
    public HashSet<UUID> enabledPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "这个命令只能由玩家使用");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission(GodsUtils.poseidonPermission)){
            player.sendMessage(GodsUtils.permissionCommandMessage);
            return true;
        }
        UUID playerId = player.getUniqueId();
        if (enabledPlayers.contains(playerId)) {
            enabledPlayers.remove(playerId);
            player.sendMessage(ChatColor.GREEN + "海豚的恩惠已关闭");
            getLogger().info("海豚的恩惠已关闭: " + player.getUniqueId());
        } else {
            if (!enabledPlayers.contains(playerId)){
                enabledPlayers.add(playerId);
                player.sendMessage(ChatColor.GREEN + "海豚的恩惠已开启");
                getLogger().info("海豚的恩惠已开启: " + player.getUniqueId());
            }
        }
        return true;
    }
    @EventHandler
    public void onWaterEnter(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Material blockType = player.getLocation().getBlock().getType();
        if (player.hasPermission(GodsUtils.poseidonPermission) && enabledPlayers.contains(player.getUniqueId())){
            if (blockType == Material.WATER || blockType == Material.BUBBLE_COLUMN){
                player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 1, true, true));
            }
        }
    }
}
