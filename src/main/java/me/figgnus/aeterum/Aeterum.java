package me.figgnus.aeterum;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.figgnus.aeterum.demeter.BetterBonemealListener;
import me.figgnus.aeterum.demeter.FlowerHorseAbilityListener;
import me.figgnus.aeterum.demeter.FlowerHorseTameListener;
import me.figgnus.aeterum.demeter.GrowthPotionListener;
import me.figgnus.aeterum.dionysos.DrunkHorseAbilityListener;
import me.figgnus.aeterum.dionysos.DrunkHorseTameListener;
import me.figgnus.aeterum.hades.NightVisionListener;
import me.figgnus.aeterum.hades.ZombieHorseAbilityListener;
import me.figgnus.aeterum.hades.ZombieHorseTameListener;
import me.figgnus.aeterum.hermes.FlyingItemListener;
import me.figgnus.aeterum.items.SlimefunItems;
import me.figgnus.aeterum.utils.TameCommandExecutor;
import me.figgnus.aeterum.utils.TameCommandTabCompleter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

public class Aeterum extends JavaPlugin implements SlimefunAddon, Listener {
    private SubItemGroup demeterSubGroup;
    private SubItemGroup dionysusSubGroup;
    private SubItemGroup hadesSubGroup;
    private SubItemGroup hermesSubGroup;

    // Slimefun Item Listeners
    private BetterBonemealListener betterBonemeal;
    private GrowthPotionListener growthPotion;
    private FlowerHorseTameListener flowerHorseTame;
    private DrunkHorseTameListener drunkHorseTame;
    private ZombieHorseTameListener zombiHorseTame;
    private FlyingItemListener flyingItem;

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        // Register groups
        ItemStack patroniGroupItem = new CustomItemStack(Material.APPLE, "&ePatroni", "", "&a> Click to open");
        NamespacedKey patroniGroupId = new NamespacedKey(this, "patroni");
        NestedItemGroup patroniGroup = new NestedItemGroup(patroniGroupId, patroniGroupItem);

        // Register sub groups for patroni
        ItemStack demeterSubGroupItem = new CustomItemStack(Material.FLOWER_POT, "&eDemeter", "", "&a> Click to open");
        NamespacedKey demeterSubGroupId = new NamespacedKey(this, "demeter");
        demeterSubGroup = new SubItemGroup(demeterSubGroupId, patroniGroup, demeterSubGroupItem);

        ItemStack dionysusSubGroupItem = new CustomItemStack(Material.HONEY_BOTTLE, "&eDionysus", "", "&a> Click to open");
        NamespacedKey dionysusSubGroupId = new NamespacedKey(this, "dionysus");
        dionysusSubGroup = new SubItemGroup(dionysusSubGroupId, patroniGroup, dionysusSubGroupItem);

        ItemStack hadesSubGroupItem = new CustomItemStack(Material.ROTTEN_FLESH, "&eHades", "", "&a> Click to open");
        NamespacedKey hadesSubGroupId = new NamespacedKey(this, "hades");
        hadesSubGroup = new SubItemGroup(hadesSubGroupId, patroniGroup, hadesSubGroupItem);

        ItemStack hermesSubGroupItem = new CustomItemStack(Material.FEATHER, "&eHermes", "", "&a> Click to open");
        NamespacedKey hermesSubGroupId = new NamespacedKey(this, "hermes");
        hermesSubGroup = new SubItemGroup(hermesSubGroupId, patroniGroup, hermesSubGroupItem);

        // Items in "Demeter" subgroup
        betterBonemeal = new BetterBonemealListener(demeterSubGroup, SlimefunItems.betterBonemealIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.betterBonemealRecipe);
        betterBonemeal.register(this);
        growthPotion = new GrowthPotionListener(demeterSubGroup, SlimefunItems.growthPotionIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.growthPotionRecipe, this);
        growthPotion.register(this);
        flowerHorseTame = new FlowerHorseTameListener(demeterSubGroup, SlimefunItems.flowerHorseTameIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.flowerHorseTameRecipe, this);
        flowerHorseTame.register(this);

        // Items in "Dionysus" subgroup
        drunkHorseTame = new DrunkHorseTameListener(dionysusSubGroup, SlimefunItems.alcoholPotionIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.alcoholPotionRecipe, this);
        drunkHorseTame.register(this);

        // Items in "Hades" subgroup
        zombiHorseTame = new ZombieHorseTameListener(hadesSubGroup, SlimefunItems.deathPotionIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.deathPotionRecipe, this);
        zombiHorseTame.register(this);

        // Items in "Hermes" subgroup
        flyingItem = new FlyingItemListener(hermesSubGroup, SlimefunItems.flyingItemIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.flyingItemRecipe, this);
        flyingItem.register(this);

        // Event Listeners
        // Group Permission
        getServer().getPluginManager().registerEvents(this, this);

        // Ability Listeners
        FlowerHorseAbilityListener flowerHorseAbilityListener = new FlowerHorseAbilityListener(this);
        DrunkHorseAbilityListener drunkHorseAbilityListener = new DrunkHorseAbilityListener(this);
        ZombieHorseAbilityListener zombieHorseAbilityListener = new ZombieHorseAbilityListener(this);
        NightVisionListener nightVisionListener = new NightVisionListener();
        // Demeter Listeners
        getServer().getPluginManager().registerEvents(flowerHorseAbilityListener, this);
        // Dionysus Listneres
        getServer().getPluginManager().registerEvents(drunkHorseAbilityListener, this);
        // Hades Listeners
        getServer().getPluginManager().registerEvents(zombieHorseAbilityListener, this);
        getServer().getPluginManager().registerEvents(nightVisionListener, this);

        // Command executor
        getCommand("tame").setExecutor(new TameCommandExecutor(this));
        getCommand("nightvision").setExecutor(nightVisionListener);
        // Tab completer
        getCommand("tame").setTabCompleter(new TameCommandTabCompleter());
    }
    // Permission check Event Handlers
    @EventHandler
    public void checkDemeterPermission(PlayerRightClickEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("aeterum.demeter")) {
            // Hide the category
            demeterSubGroup.remove(betterBonemeal);
            demeterSubGroup.remove(growthPotion);
            demeterSubGroup.remove(flowerHorseTame);
        }else {
            demeterSubGroup.add(betterBonemeal);
            demeterSubGroup.add(growthPotion);
            demeterSubGroup.add(flowerHorseTame);
        }
    }
    @EventHandler
    public void checkDionysusPermission(PlayerRightClickEvent event){
        Player player = event.getPlayer();
        if (!player.hasPermission("aeterum.dionysus")){
            dionysusSubGroup.remove(drunkHorseTame);
        }else {
            dionysusSubGroup.add(drunkHorseTame);
        }
    }
    @EventHandler
    public void checkHadesPermission(PlayerRightClickEvent event){
        Player player = event.getPlayer();
        if (!player.hasPermission("aeterum.hades")){
            hadesSubGroup.remove(zombiHorseTame);
        }else {
            hadesSubGroup.add(zombiHorseTame);
        }
    }
    //methods for making metadata of entities persistent
    public void setEntityMetadata(Entity entity, String key, String value){
        NamespacedKey namespacedKey = new NamespacedKey(this, key);
        PersistentDataContainer dataContainer = entity.getPersistentDataContainer();
        dataContainer.set(namespacedKey, PersistentDataType.STRING, value);
    }
    public String getEntityMetadata(Entity entity, String key) {
        NamespacedKey namespacedKey = new NamespacedKey(this, key);
        PersistentDataContainer dataContainer = entity.getPersistentDataContainer();
        if (dataContainer.has(namespacedKey, PersistentDataType.STRING)) {
            return dataContainer.get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
