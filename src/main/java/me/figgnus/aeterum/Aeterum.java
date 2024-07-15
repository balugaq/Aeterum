package me.figgnus.aeterum;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.figgnus.aeterum.brewery_menu.BreweryMenu;
import me.figgnus.aeterum.gods.poseidon.*;
import me.figgnus.aeterum.gods.zeus.*;
import me.figgnus.aeterum.items.groups.CustomItemGroup;
import me.figgnus.aeterum.items.item_listener.RandomizerListener;
import me.figgnus.aeterum.items.research.ItemResearch;
import me.figgnus.aeterum.items.utils.ItemUtils;
import me.figgnus.aeterum.utils.DevUtils;
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
import me.figgnus.aeterum.utils.TameCommandExecutor;
import me.figgnus.aeterum.utils.TameCommandTabCompleter;
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
    private WeatherChangerListener weatherChanger;
    private LightningSpearListener lightningSpear;

    // Slimefun Items No Listeners
    private BetterTrident betterTrident;
    private WaterBreathingCrown waterBreathingCrown;

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        // Dev info to be deleted
        getServer().getPluginManager().registerEvents(new DevUtils(this), this);
        // Register groups
        ItemStack toolsGroupItem = new CustomItemStack(Material.NETHERITE_PICKAXE, "&eNástroje +", "", "&a> Click to open");
        NamespacedKey toolsGroupId = new NamespacedKey(this, "tools_plus");
        ItemGroup toolsGroup = new ItemGroup(toolsGroupId, toolsGroupItem);

        // Register groups for VIP
        ItemStack demeterSubGroupItem = new CustomItemStack(ItemUtils.createHead("d2fe0f2e6c0ffeefbb84c32e71876b68dcbf7ac9e8420a3d1bf593aa21a8374a"), "&ePatron - Demeter", "", "&a> Click to open");
        NamespacedKey demeterSubGroupId = new NamespacedKey(this, "demeter_group");
        String demeterPermission = "aeterum.demeter";
        ItemGroup demeterGroup = new CustomItemGroup(demeterSubGroupId, demeterSubGroupItem, demeterPermission);

        ItemStack dionysusSubGroupItem = new CustomItemStack(ItemUtils.createHead("b2b0a1ca399f35dc54519c4c996f9629a510c49938151f759ec8f07041e78566"), "&ePatron - Dionysus", "", "&a> Click to open");
        NamespacedKey dionysusSubGroupId = new NamespacedKey(this, "dionysus_group");
        String dionysusPermission = "aeterum.dionysus";
        ItemGroup dionysusGroup = new CustomItemGroup(dionysusSubGroupId, dionysusSubGroupItem, dionysusPermission);

        ItemStack hadesSubGroupItem = new CustomItemStack(ItemUtils.createHead("492b27824182f9b81c7cf463ec7cd10b05e0640d38b56c8873196f19168f63ad"), "&ePatron - Hades", "", "&a> Click to open");
        NamespacedKey hadesSubGroupId = new NamespacedKey(this, "hades_group");
        String hadesPermission = "aeterum.hades";
        ItemGroup hadesGroup = new CustomItemGroup(hadesSubGroupId, hadesSubGroupItem, hadesPermission);

        ItemStack hermesSubGroupItem = new CustomItemStack(ItemUtils.createHead("ae8e5160314bb7caa54d3e8d1be8e3a924b245e1c6a6d0a559c83d17f98ba4ce"), "&ePatron - Hermes", "", "&a> Click to open");
        NamespacedKey hermesSubGroupId = new NamespacedKey(this, "hermes-group");
        String hermesPermission = "aeterum.hermes";
        ItemGroup hermesGroup = new CustomItemGroup(hermesSubGroupId, hermesSubGroupItem, hermesPermission);

        ItemStack poseidonSubGroupItem = new CustomItemStack(ItemUtils.createHead("1f716c1a80da85d5e6784c336b2583d61dc76de3d99a1984d3e593721e21327"), "&ePatron - Poseidon", "", "&a> Click to open");
        NamespacedKey poseidonSubGroupId = new NamespacedKey(this, "poseidon_group");
        String poseidonPermission = "aeterum.poseidon";
        ItemGroup poseidonGroup = new CustomItemGroup(poseidonSubGroupId, poseidonSubGroupItem, poseidonPermission);

        ItemStack zeusSubGroupItem = new CustomItemStack(ItemUtils.createHead("dcd9ddf4fb9e25e62d2e98595d5168de2b3367ba78f3697be1c479f35102ad76"), "&ePatron - Zeus", "", "&a> Click to open");
        NamespacedKey zeusSubGroupId = new NamespacedKey(this, "zeus_group");
        String zeusPermission = "aeterum.zeus";
        ItemGroup zeusGroup = new CustomItemGroup(zeusSubGroupId, zeusSubGroupItem, zeusPermission);


        // Initialize class so that configureMeta() method in constructor takes place
        new SlimefunCustomItems();

        // Items in "Demeter" subgroup
        betterBonemeal = new BetterBonemealListener(demeterGroup , SlimefunCustomItems.BETTER_BONEMEAL, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.betterBonemealRecipe, this);
        betterBonemeal.register(this);
        growthPotion = new GrowthPotionListener(demeterGroup , SlimefunCustomItems.GROWTH_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.GROWTH_POTION_RECIPE, this);
        growthPotion.register(this);
        flowerHorseTame = new FlowerHorseTameListener(demeterGroup , SlimefunCustomItems.FL0WER_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.FLOWER_HORSE_TAME_RECIPE, this);
        flowerHorseTame.register(this);

        // Items in "Dionysus" subgroup
        drunkHorseTame = new DrunkHorseTameListener(dionysusGroup, SlimefunCustomItems.DRUNK_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.DRUNK_HORSE_TAME_RECIPE, this);
        drunkHorseTame.register(this);

        // Items in "Hades" subgroup
        zombiHorseTame = new ZombieHorseTameListener(hadesGroup, SlimefunCustomItems.ZOMBIE_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.ZOMBIE_HORSE_TAME_RECIPE, this);
        zombiHorseTame.register(this);

        // Items in "Hermes" subgroup
        flyingItem = new FlyingItemListener(hermesGroup, SlimefunCustomItems.FLYING_ITEM, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.FLYING_ITEM_RECIPE, this);
        flyingItem.register(this);
        speedBoots = new SpeedBootsListener(hermesGroup, SlimefunCustomItems.SPEED_BOOTS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SPEED_BOOTS_RECIPE, this);
        speedBoots.register(this);
        speedHorseTame = new SpeedHorseTameListener(hermesGroup, SlimefunCustomItems.SPEED_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SPEED_HORSE_TAME_RECIPE, this);
        speedHorseTame.register(this);
        speedHorseAbility = new SpeedHorseAbilityListener(hermesGroup, SlimefunCustomItems.HORSE_SPEED_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.HORSE_SPEED_POTION_RECIPE, this);
        speedHorseAbility.register(this);

        // Items in "Poseidon" subgroup
        seaHorseTame = new SeaHorseTameListener(poseidonGroup, SlimefunCustomItems.SEA_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SEA_HORSE_TAME_RECIPE, this);
        seaHorseTame.register(this);
        betterTrident = new BetterTrident(poseidonGroup, SlimefunCustomItems.BETTER_TRIDENT, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.BETTER_TRIDENT_RECIPE, this);
        betterTrident.register(this);
        waterBreathingCrown = new WaterBreathingCrown(poseidonGroup, SlimefunCustomItems.WATTER_BREATHING_CROWN, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.WATER_BREATHING_CROWN_RECIPE, this);
        waterBreathingCrown.register(this);

        // Items in "Zeus" subgroup
        breedingItem = new BreedingItemListener(zeusGroup, SlimefunCustomItems.BREEDING_ITEM, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.BREEDING_ITEM_RECIPE, this);
        breedingItem.register(this);
        pegasusTame = new PegasusTameListener(zeusGroup, SlimefunCustomItems.PEGASUS_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.PEGASUS_TAME_RECIPE, this);
        pegasusTame.register(this);
        pegasusAbility = new PegasusAbilityListener(zeusGroup, SlimefunCustomItems.HORSE_LEVITATE_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.HORSE_LEVITATE_POTION_RECIPE, this);
        pegasusAbility.register(this);
        weatherChanger = new WeatherChangerListener(zeusGroup, SlimefunCustomItems.WEATHER_CHANGER, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.WEATHER_CHANGER_RECIPE, this);
        weatherChanger.register(this);
        lightningSpear = new LightningSpearListener(zeusGroup, SlimefunCustomItems.LIGHTNING_SPEAR, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.LIGHTNING_SPEAR_RECIPE, this);
        lightningSpear.register(this);

        // Items in "Tools +" subgroup
        randomizer = new RandomizerListener(toolsGroup, SlimefunCustomItems.RANDOMIZER, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.RANDOMIZER_RECIPE, this);
        randomizer.register(this);

        // Research
        Research demeter_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "demeter_research"), 70001, "Research unlocked!", 1);
        demeter_research.addItems(betterBonemeal, growthPotion, flowerHorseTame);
        demeter_research.register();

        Research dionysus_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "dionysus_research"), 70002, "Research unlocked!", 1);
        dionysus_research.addItems(drunkHorseTame);
        dionysus_research.register();

        Research hades_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "hades_research"), 70003, "Research unlocked!", 1);
        hades_research.addItems(zombiHorseTame);
        hades_research.register();

        Research hermes_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "hermes_research"), 70004, "Research unlocked!", 1);
        hermes_research.addItems(flyingItem, speedBoots, speedHorseTame, speedHorseAbility);
        hermes_research.register();

        Research poseidon_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "poseidon_research"), 70005, "Research unlocked!", 1);
        poseidon_research.addItems(seaHorseTame, betterTrident, waterBreathingCrown);
        poseidon_research.register();

        Research zeus_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "zeus_research"), 70006, "Research unlocked!", 1);
        zeus_research.addItems(breedingItem, pegasusTame, pegasusAbility, weatherChanger, lightningSpear);
        zeus_research.register();

        Research tools_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "tools_research"), 70007, "Research unlocked!", 10);
        tools_research.addItems(randomizer);
        tools_research.register();


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
