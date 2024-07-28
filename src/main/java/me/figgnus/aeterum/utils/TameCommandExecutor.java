package me.figgnus.aeterum.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.demeter.FlowerHorseTameListener;
import me.figgnus.aeterum.gods.dionysos.DrunkHorseTameListener;
import me.figgnus.aeterum.gods.hades.ZombieHorseTameListener;
import me.figgnus.aeterum.gods.hermes.SpeedHorseTameListener;
import me.figgnus.aeterum.gods.poseidon.SeaHorseTameListener;
import me.figgnus.aeterum.gods.zeus.PegasusTameListener;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class TameCommandExecutor implements CommandExecutor {
    private final Aeterum plugin;
    Random random = new Random();

    public TameCommandExecutor(Aeterum plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0){
            player.sendMessage("Usage: /tame <god>");
            return true;
        }
        String action = args[0].toLowerCase();
        handleCommand(player, action);
        return true;
    }

    private void handleCommand(Player player, String action) {
        switch (action){
            case "demeter":
                spawnHorse(player, EntityType.HORSE, FlowerHorseTameListener.SEED_KEY, Horse.Color.GRAY);
                break;
            case "dionysus":
                spawnHorse(player, EntityType.HORSE, DrunkHorseTameListener.DRUNK_KEY, Horse.Color.CHESTNUT);
                break;
            case "hades":
                spawnHorse(player, EntityType.ZOMBIE_HORSE, ZombieHorseTameListener.LAVA_WALKER, null);
                break;
            case "hermes":
                spawnHorse(player, EntityType.HORSE, SpeedHorseTameListener.SPEED_KEY, Horse.Color.CREAMY);
                break;
            case "poseidon":
                spawnHorse(player, EntityType.HORSE, SeaHorseTameListener.FROST_WALKER_KEY, Horse.Color.BLACK);
                break;
            case "zeus":
                spawnHorse(player, EntityType.HORSE, PegasusTameListener.LEVITATE_KEY, Horse.Color.WHITE);
                break;
            case "test":
                spawnTestPotion(player);
                break;
            default:
                player.sendMessage("Unknown horse type: " + action);
                break;
        }
    }

    private void spawnTestPotion(Player player) {
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setColor(Color.GRAY);
        meta.setDisplayName("Name");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);

        player.getInventory().addItem(item);
    }

    private void spawnHorse(Player player, EntityType entityType, String metaKey, Horse.Color color) {
        Entity entity = player.getWorld().spawnEntity(player.getLocation(), entityType);
        if (entity instanceof Horse) {
            Horse horse = (Horse) entity;
            horse.setOwner(player);
            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
            plugin.setEntityMetadata(horse, metaKey, "true");

            double speed = random.nextDouble(0.3, 0.3375);
            double jump = random.nextDouble(0.9, 1.1);
            int health = random.nextInt(25, 30);

            if (color != null) {
                horse.setColor(color);
            }

            horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
            horse.getAttribute(Attribute.HORSE_JUMP_STRENGTH).setBaseValue(jump);
            horse.setMaxHealth(health);
            horse.setHealth(health);

            player.sendMessage(ChatColor.GREEN + "A " + horse.getCustomName() + " has been spawned!");
        } else if (entity instanceof ZombieHorse) {
            ZombieHorse horse = (ZombieHorse) entity;
            horse.setOwner(player);
            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
            plugin.setEntityMetadata(horse, metaKey, "true");

            double speed = random.nextDouble(0.3, 0.3375);
            double jump = random.nextDouble(0.9, 1.1);
            int health = random.nextInt(25, 30);

            horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
            horse.getAttribute(Attribute.HORSE_JUMP_STRENGTH).setBaseValue(jump);
            horse.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, -1, 1));
            horse.setMaxHealth(health);
            horse.setHealth(health);

            player.sendMessage(ChatColor.GREEN + "A " + horse.getCustomName() + " has been spawned!");
        }
    }
}
