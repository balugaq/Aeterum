package me.figgnus.aeterum;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.figgnus.aeterum.brewery_menu.BreweryMenu;
import me.figgnus.aeterum.gods.poseidon.BetterTrident;
import me.figgnus.aeterum.items.item_listener.RandomizerListener;
import me.figgnus.aeterum.utils.SnowballDemageListener;
import me.figgnus.aeterum.gods.demeter.BetterBonemealListener;
import me.figgnus.aeterum.gods.demeter.FlowerHorseAbilityListener;
import me.figgnus.aeterum.gods.demeter.FlowerHorseTameListener;
import me.figgnus.aeterum.gods.demeter.GrowthPotionListener;
import me.figgnus.aeterum.gods.dionysos.DrunkHorseAbilityListener;
import me.figgnus.aeterum.gods.dionysos.DrunkHorseTameListener;
import me.figgnus.aeterum.gods.hades.NightVisionListener;
import me.figgnus.aeterum.gods.hades.ZombieHorseAbilityListener;
import me.figgnus.aeterum.gods.hades.ZombieHorseTameListener;
import me.figgnus.aeterum.gods.hermes.FlyingItemListener;
import me.figgnus.aeterum.gods.hermes.SpeedBootsListener;
import me.figgnus.aeterum.gods.hermes.SpeedHorseAbilityListener;
import me.figgnus.aeterum.gods.hermes.SpeedHorseTameListener;
import me.figgnus.aeterum.items.SlimefunItems;
import me.figgnus.aeterum.gods.poseidon.DolphinGraceListener;
import me.figgnus.aeterum.gods.poseidon.SeaHorseAbilityListener;
import me.figgnus.aeterum.gods.poseidon.SeaHorseTameListener;
import me.figgnus.aeterum.utils.TameCommandExecutor;
import me.figgnus.aeterum.utils.TameCommandTabCompleter;
import me.figgnus.aeterum.gods.zeus.BreedingItemListener;
import me.figgnus.aeterum.gods.zeus.PegasusAbilityListener;
import me.figgnus.aeterum.gods.zeus.PegasusTameListener;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
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
    private SubItemGroup poseidonSubGroup;
    private SubItemGroup zeusSubGroup;

    // Slimefun Item Listeners
    private BetterBonemealListener betterBonemeal;
    private GrowthPotionListener growthPotion;
    private FlowerHorseTameListener flowerHorseTame;
    private DrunkHorseTameListener drunkHorseTame;
    private ZombieHorseTameListener zombiHorseTame;
    private FlyingItemListener flyingItem;
    private SpeedBootsListener speedBoots;
    private SpeedHorseTameListener speedHorseTame;
    private SpeedHorseAbilityListener speedHorseAbility;
    private SeaHorseTameListener seaHorseTame;
    private BreedingItemListener breedingItem;
    private PegasusTameListener pegasusTame;
    private PegasusAbilityListener pegasusAbility;
    private RandomizerListener randomizer;

    // Slimefun Items No Listeners
    private BetterTrident betterTrident;

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

        ItemStack toolsGroupItem = new CustomItemStack(Material.NETHERITE_PICKAXE, "&eNástroje +", "", "&a> Click to open");
        NamespacedKey toolsGroupId = new NamespacedKey(this, "tools_plus");
        ItemGroup toolsGroup = new ItemGroup(toolsGroupId, toolsGroupItem);

        // Register sub groups for patroni
        ItemStack demeterSubGroupItem = new CustomItemStack(Material.PINK_PETALS, "&eDemeter", "", "&a> Click to open");
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

        ItemStack poseidonSubGroupItem = new CustomItemStack(Material.TRIDENT, "&ePoseidon", "", "&a> Click to open");
        NamespacedKey poseidonSubGroupId = new NamespacedKey(this, "poseidon");
        poseidonSubGroup = new SubItemGroup(poseidonSubGroupId, patroniGroup, poseidonSubGroupItem);

        ItemStack zeusSubGroupItem = new CustomItemStack(Material.GOLDEN_SWORD, "&eZeus", "", "&a> Click to open");
        NamespacedKey zeusSubGroupId = new NamespacedKey(this, "zeus");
        zeusSubGroup = new SubItemGroup(zeusSubGroupId, patroniGroup, zeusSubGroupItem);

        //new BetterBonemealListener(demeterSubGroup, SlimefunItems.betterBonemealIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.betterBonemealRecipe, this);
        //new GrowthPotionListener(demeterSubGroup, SlimefunItems.growthPotionIS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunItems.growthPotionRecipe, this);
        // Items in "Demeter" subgroup
        betterBonemeal = SlimefunItems.betterBonemeal(demeterSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        betterBonemeal.register(this);
        growthPotion = SlimefunItems.growthPotion(demeterSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        growthPotion.register(this);
        flowerHorseTame = SlimefunItems.demeterTame(demeterSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        flowerHorseTame.register(this);

        // Items in "Dionysus" subgroup
        drunkHorseTame = SlimefunItems.dionysusTame(dionysusSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        drunkHorseTame.register(this);

        // Items in "Hades" subgroup
        zombiHorseTame = SlimefunItems.hadesTame(hadesSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        zombiHorseTame.register(this);

        // Items in "Hermes" subgroup
        flyingItem = SlimefunItems.flyingItem(hermesSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        flyingItem.register(this);
        speedBoots = SlimefunItems.speedBoots(hermesSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        speedBoots.register(this);
        speedHorseTame = SlimefunItems.hermesTame(hermesSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        speedHorseTame.register(this);
        speedHorseAbility = SlimefunItems.horseSpeedPotion(hermesSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        speedHorseAbility.register(this);

        // Items in "Poseidon" subgroup
        seaHorseTame = SlimefunItems.poseidonTame(poseidonSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        seaHorseTame.register(this);
        betterTrident = SlimefunItems.betterTrident(poseidonSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        betterTrident.register(this);

        // Items in "Zeus" subgroup
        breedingItem = SlimefunItems.breedingItem(zeusSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        breedingItem.register(this);
        pegasusTame = SlimefunItems.zeusTame(zeusSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        pegasusTame.register(this);
        pegasusAbility = SlimefunItems.horseLevitatePotion(zeusSubGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        pegasusAbility.register(this);

        // Items in "Tools +" subgroup
        randomizer = SlimefunItems.randomizer(toolsGroup, RecipeType.ENHANCED_CRAFTING_TABLE, this);
        randomizer.register(this);


        // Event Listeners
        // Group Permission
        getServer().getPluginManager().registerEvents(this, this);

        // Ability Listeners
        FlowerHorseAbilityListener flowerHorseAbilityListener = new FlowerHorseAbilityListener(this);
        DrunkHorseAbilityListener drunkHorseAbilityListener = new DrunkHorseAbilityListener(this);
        ZombieHorseAbilityListener zombieHorseAbilityListener = new ZombieHorseAbilityListener(this);
        NightVisionListener nightVisionListener = new NightVisionListener();
        DolphinGraceListener dolphinGraceListener = new DolphinGraceListener();
        SeaHorseAbilityListener seaHorseAbilityListener = new SeaHorseAbilityListener(this);
        SnowballDemageListener snowballDemageListener = new SnowballDemageListener();
        // Demeter Listeners
        getServer().getPluginManager().registerEvents(flowerHorseAbilityListener, this);
        // Dionysus Listneres
        getServer().getPluginManager().registerEvents(drunkHorseAbilityListener, this);
        // Hades Listeners
        getServer().getPluginManager().registerEvents(zombieHorseAbilityListener, this);
        getServer().getPluginManager().registerEvents(nightVisionListener, this);
        // Poseidon Listeners
        getServer().getPluginManager().registerEvents(dolphinGraceListener, this);
        getServer().getPluginManager().registerEvents(seaHorseAbilityListener, this);
        // Other Listeners
        getServer().getPluginManager().registerEvents(snowballDemageListener, this);

        // Command executor
        getCommand("tame").setExecutor(new TameCommandExecutor(this));
        getCommand("nightvision").setExecutor(nightVisionListener);
        getCommand("dolphingrace").setExecutor(dolphinGraceListener);
        // Tab completer
        getCommand("tame").setTabCompleter(new TameCommandTabCompleter());

        // register brewery menu
        new BreweryMenu(this);

    }
    // Permission check Event Handlers
//    @EventHandler
//    public void checkDemeterPermission(PlayerRightClickEvent event) {
//        Player player = event.getPlayer();
//        if (!player.hasPermission("aeterum.demeter")) {
//            // Hide the category
//            demeterSubGroup.remove(betterBonemeal);
//            demeterSubGroup.remove(growthPotion);
//            demeterSubGroup.remove(flowerHorseTame);
//        }else {
//            demeterSubGroup.add(betterBonemeal);
//            demeterSubGroup.add(growthPotion);
//            demeterSubGroup.add(flowerHorseTame);
//        }
//    }
//    @EventHandler
//    public void checkDionysusPermission(PlayerRightClickEvent event){
//        Player player = event.getPlayer();
//        if (!player.hasPermission("aeterum.dionysus")){
//            dionysusSubGroup.remove(drunkHorseTame);
//        }else {
//            dionysusSubGroup.add(drunkHorseTame);
//        }
//    }
//    @EventHandler
//    public void checkHadesPermission(PlayerRightClickEvent event){
//        Player player = event.getPlayer();
//        if (!player.hasPermission("aeterum.hades")){
//            hadesSubGroup.remove(zombiHorseTame);
//        }else {
//            hadesSubGroup.add(zombiHorseTame);
//        }
//    }
//    @EventHandler
//    public void checkHermesPermission(PlayerRightClickEvent event){
//        Player player = event.getPlayer();
//        if (!player.hasPermission("aeterum.hermes")){
//            hermesSubGroup.remove(flyingItem);
//            hermesSubGroup.remove(speedBoots);
//            hermesSubGroup.remove(speedHorseTame);
//            hermesSubGroup.remove(speedHorseAbility);
//        }else {
//            hermesSubGroup.add(flyingItem);
//            hermesSubGroup.add(speedBoots);
//            hermesSubGroup.add(speedHorseTame);
//            hermesSubGroup.add(speedHorseAbility);
//        }
//    }
//    @EventHandler
//    public void checkPoseidonPermission(PlayerRightClickEvent event){
//        Player player = event.getPlayer();
//        if (!player.hasPermission("aeterum.poseidon")){
//            poseidonSubGroup.remove(seaHorseTame);
//            poseidonSubGroup.remove(betterTrident);
//        }else {
//            poseidonSubGroup.add(seaHorseTame);
//            poseidonSubGroup.add(betterTrident);
//        }
//    }
//    @EventHandler
//    public void checkZeusPermission(PlayerRightClickEvent event){
//        Player player = event.getPlayer();
//        if (!player.hasPermission("aeterum.zeus")){
//            zeusSubGroup.remove(breedingItem);
//            zeusSubGroup.remove(pegasusTame);
//            zeusSubGroup.remove(pegasusAbility);
//        }else {
//            zeusSubGroup.add(breedingItem);
//            zeusSubGroup.add(pegasusTame);
//            zeusSubGroup.add(pegasusAbility);
//        }
//    }
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
