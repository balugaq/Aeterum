package me.figgnus.aeterum.gods.hades;

import java.util.HashSet;
import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.figgnus.aeterum.gods.GodsUtils;

public class NightVisionListener implements Listener, CommandExecutor {
    public HashSet<UUID> enabledPlayers = new HashSet<>();
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock();

        if (player.hasPermission(GodsUtils.hadesPermission) && enabledPlayers.contains(player.getUniqueId())){
            if (isUnderground(player) && isLowLightLevel(block)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 1, true, false));
            }else {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        }
    }
    private boolean isUnderground(Player player) {
        return player.getLocation().getBlockY() < 0;
    }
    private boolean isLowLightLevel(Block block){
        if(block.getLightLevel() < 3){
            return true;
        }
        return false;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "此指令只能由玩家使用");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission(GodsUtils.hadesPermission)){
            player.sendMessage(GodsUtils.permissionCommandMessage);
            return true;
        }
        UUID playerId = player.getUniqueId();
        if (enabledPlayers.contains(playerId)) {
            enabledPlayers.remove(playerId);
            player.sendMessage(ChatColor.GREEN + "夜视已关闭");
            getLogger().info("夜视已关闭： " + player.getUniqueId());
        } else {
            if (!enabledPlayers.contains(playerId)){
                enabledPlayers.add(playerId);
                player.sendMessage(ChatColor.GREEN + "夜视已开启");
                getLogger().info("夜视已开启： " + player.getUniqueId());
            }
        }
        return true;
    }
}
