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
import me.figgnus.aeterum.items.SlimefunCustomItems;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

public class Aeterum extends JavaPlugin implements SlimefunAddon {
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

        // Initialize class so that configureMeta() method in constructor takes place
        new SlimefunCustomItems();

        // Items in "Demeter" subgroup
        betterBonemeal = new BetterBonemealListener(demeterSubGroup, SlimefunCustomItems.BETTER_BONEMEAL, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.betterBonemealRecipe, this);
        betterBonemeal.register(this);
        growthPotion = new GrowthPotionListener(demeterSubGroup, SlimefunCustomItems.GROWTH_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.GROWTH_POTION_RECIPE, this);
        growthPotion.register(this);
        flowerHorseTame = new FlowerHorseTameListener(demeterSubGroup, SlimefunCustomItems.FL0WER_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.FLOWER_HORSE_TAME_RECIPE, this);
        flowerHorseTame.register(this);

        // Items in "Dionysus" subgroup
        drunkHorseTame = new DrunkHorseTameListener(dionysusSubGroup, SlimefunCustomItems.DRUNK_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.DRUNK_HORSE_TAME_RECIPE, this);
        drunkHorseTame.register(this);

        // Items in "Hades" subgroup
        zombiHorseTame = new ZombieHorseTameListener(hadesSubGroup, SlimefunCustomItems.ZOMBIE_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.ZOMBIE_HORSE_TAME_RECIPE, this);
        zombiHorseTame.register(this);

        // Items in "Hermes" subgroup
        flyingItem = new FlyingItemListener(hermesSubGroup, SlimefunCustomItems.FLYING_ITEM, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.FLYING_ITEM_RECIPE, this);
        flyingItem.register(this);
        speedBoots = new SpeedBootsListener(hermesSubGroup, SlimefunCustomItems.SPEED_BOOTS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SPEED_BOOTS_RECIPE, this);
        speedBoots.register(this);
        speedHorseTame = new SpeedHorseTameListener(hermesSubGroup, SlimefunCustomItems.SPEED_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SPEED_HORSE_TAME_RECIPE, this);
        speedHorseTame.register(this);
        speedHorseAbility = new SpeedHorseAbilityListener(hermesSubGroup, SlimefunCustomItems.HORSE_SPEED_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.HORSE_SPEED_POTION_RECIPE, this);
        speedHorseAbility.register(this);

        // Items in "Poseidon" subgroup
        seaHorseTame = new SeaHorseTameListener(poseidonSubGroup, SlimefunCustomItems.SEA_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SEA_HORSE_TAME_RECIPE, this);
        seaHorseTame.register(this);
        betterTrident = new BetterTrident(poseidonSubGroup, SlimefunCustomItems.BETTER_TRIDENT, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.BETTER_TRIDENT_RECIPE, this);
        betterTrident.register(this);

        // Items in "Zeus" subgroup
        breedingItem = new BreedingItemListener(zeusSubGroup, SlimefunCustomItems.BREEDING_ITEM, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.BREEDING_ITEM_RECIPE, this);
        breedingItem.register(this);
        pegasusTame = new PegasusTameListener(zeusSubGroup, SlimefunCustomItems.PEGASUS_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.PEGASUS_TAME_RECIPE, this);
        pegasusTame.register(this);
        pegasusAbility = new PegasusAbilityListener(zeusSubGroup, SlimefunCustomItems.HORSE_LEVITATE_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.HORSE_LEVITATE_POTION_RECIPE, this);
        pegasusAbility.register(this);

        // Items in "Tools +" subgroup
        randomizer = new RandomizerListener(toolsGroup, SlimefunCustomItems.RANDOMIZER, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.RANDOMIZER_RECIPE, this);
        randomizer.register(this);


        // Event Listeners
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
