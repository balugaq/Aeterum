package me.figgnus.aeterum.utils;

import me.figgnus.aeterum.Aeterum;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class DevUtils implements Listener {
    private final Aeterum plugin;

    public DevUtils(Aeterum plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Game Mode: " + player.getGameMode());
        player.sendMessage("Is OP: " + player.isOp());
    }
}
