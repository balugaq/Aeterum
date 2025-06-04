package me.figgnus.aeterum;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.figgnus.aeterum.brewery_menu.BreweryMenu;
import me.figgnus.aeterum.gods.GodsUtils;
import me.figgnus.aeterum.gods.demeter.*;
import me.figgnus.aeterum.gods.dionysos.*;
import me.figgnus.aeterum.gods.hades.*;
import me.figgnus.aeterum.gods.hermes.*;
import me.figgnus.aeterum.gods.poseidon.*;
import me.figgnus.aeterum.gods.zeus.*;
import me.figgnus.aeterum.items.groups.CustomItemGroup;
import me.figgnus.aeterum.items.item_listener.RandomizerListener;
import me.figgnus.aeterum.items.research.ItemResearch;
import me.figgnus.aeterum.items.utils.ItemUtils;
import me.figgnus.aeterum.utils.SnowballDemageListener;
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
    private RandomEffectPotionListener randomEffectPotion;
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
    private PartyAtmosphereListener partyAtmosphere;
    private FireworkBallListener fireworkBall;
    private DarknessPotionListener darknessPotion;
    private PortalListener portal;
    private DarkPearlListener darkPearl;
    private MessengerPackListener messengerPack;
    private HoeOfHarvestListener hoeOfHarvest;

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

        // Register groups
        ItemStack toolsGroupItem = new CustomItemStack(Material.NETHERITE_PICKAXE, "&e工具+", "", "&a> 单击打开");
        NamespacedKey toolsGroupId = new NamespacedKey(this, "tools_plus");
        ItemGroup toolsGroup = new ItemGroup(toolsGroupId, toolsGroupItem);

        // Register groups for VIP
        ItemStack demeterSubGroupItem = new CustomItemStack(ItemUtils.createHead("d2fe0f2e6c0ffeefbb84c32e71876b68dcbf7ac9e8420a3d1bf593aa21a8374a"), "&e守护神 - 德墨忒耳（Demeter）", "", "&a> 单击打开");
        NamespacedKey demeterSubGroupId = new NamespacedKey(this, "demeter_group");
        ItemGroup demeterGroup = new CustomItemGroup(demeterSubGroupId, demeterSubGroupItem, GodsUtils.demeterBasePermission);

        ItemStack dionysusSubGroupItem = new CustomItemStack(ItemUtils.createHead("b2b0a1ca399f35dc54519c4c996f9629a510c49938151f759ec8f07041e78566"), "&e守护神 - 狄俄尼索斯（Dionysus）", "", "&a> 单击打开");
        NamespacedKey dionysusSubGroupId = new NamespacedKey(this, "dionysus_group");
        ItemGroup dionysusGroup = new CustomItemGroup(dionysusSubGroupId, dionysusSubGroupItem, GodsUtils.dionysusBasePermission);

        ItemStack hadesSubGroupItem = new CustomItemStack(ItemUtils.createHead("492b27824182f9b81c7cf463ec7cd10b05e0640d38b56c8873196f19168f63ad"), "&e守护神 - 哈迪斯（Hades）", "", "&a> 单击打开");
        NamespacedKey hadesSubGroupId = new NamespacedKey(this, "hades_group");
        ItemGroup hadesGroup = new CustomItemGroup(hadesSubGroupId, hadesSubGroupItem, GodsUtils.hadesBasePermission);

        ItemStack hermesSubGroupItem = new CustomItemStack(ItemUtils.createHead("ae8e5160314bb7caa54d3e8d1be8e3a924b245e1c6a6d0a559c83d17f98ba4ce"), "&e守护神 - 赫尔墨斯（Hermes）", "", "&a> 单击打开");
        NamespacedKey hermesSubGroupId = new NamespacedKey(this, "hermes-group");
        ItemGroup hermesGroup = new CustomItemGroup(hermesSubGroupId, hermesSubGroupItem, GodsUtils.hermesBasePermission);

        ItemStack poseidonSubGroupItem = new CustomItemStack(ItemUtils.createHead("1f716c1a80da85d5e6784c336b2583d61dc76de3d99a1984d3e593721e21327"), "&e守护神 - 波塞冬（Poseidon）", "", "&a> 单击打开");
        NamespacedKey poseidonSubGroupId = new NamespacedKey(this, "poseidon_group");
        ItemGroup poseidonGroup = new CustomItemGroup(poseidonSubGroupId, poseidonSubGroupItem, GodsUtils.poseidonBasePermission);

        ItemStack zeusSubGroupItem = new CustomItemStack(ItemUtils.createHead("dcd9ddf4fb9e25e62d2e98595d5168de2b3367ba78f3697be1c479f35102ad76"), "&e守护神 - 宙斯（Zeus）", "", "&a> 单击打开");
        NamespacedKey zeusSubGroupId = new NamespacedKey(this, "zeus_group");
        ItemGroup zeusGroup = new CustomItemGroup(zeusSubGroupId, zeusSubGroupItem, GodsUtils.zeusBasePermission);


        // Initialize class so that configureMeta() method in constructor takes place
        new SlimefunCustomItems();

        // Items in "Demeter" subgroup
        betterBonemeal = new BetterBonemealListener(demeterGroup , SlimefunCustomItems.BETTER_BONEMEAL, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.betterBonemealRecipe, this);
        betterBonemeal.register(this);
        growthPotion = new GrowthPotionListener(demeterGroup , SlimefunCustomItems.GROWTH_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.GROWTH_POTION_RECIPE, this);
        growthPotion.register(this);
        flowerHorseTame = new FlowerHorseTameListener(demeterGroup , SlimefunCustomItems.FL0WER_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.FLOWER_HORSE_TAME_RECIPE, this);
        flowerHorseTame.register(this);
        hoeOfHarvest = new HoeOfHarvestListener(demeterGroup, SlimefunCustomItems.HOE_OF_HARVEST, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.HOE_OF_HARVEST_RECIPE, this);
        hoeOfHarvest.register(this);

        // Items in "Dionysus" subgroup
        drunkHorseTame = new DrunkHorseTameListener(dionysusGroup, SlimefunCustomItems.DRUNK_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.DRUNK_HORSE_TAME_RECIPE, this);
        drunkHorseTame.register(this);
        randomEffectPotion = new RandomEffectPotionListener(dionysusGroup, SlimefunCustomItems.RANDOM_EFFECT_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.RANDOM_EFFECT_POTION_RECIPE, this);
        randomEffectPotion.register(this);
        partyAtmosphere = new PartyAtmosphereListener(dionysusGroup, SlimefunCustomItems.PARTY_ATMOSPHERE, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.PARTY_ATMOSPHERE_RECIPE, this);
        partyAtmosphere.register(this);
        fireworkBall = new FireworkBallListener(dionysusGroup, SlimefunCustomItems.PARTY_BALL, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.PARTY_BALL_RECIPE, this);
        fireworkBall.register(this);

        // Items in "Hades" subgroup
        zombiHorseTame = new ZombieHorseTameListener(hadesGroup, SlimefunCustomItems.ZOMBIE_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.ZOMBIE_HORSE_TAME_RECIPE, this);
        zombiHorseTame.register(this);
        darknessPotion = new DarknessPotionListener(hadesGroup, SlimefunCustomItems.DARKNESS_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.DARKNESS_POTION_RECIPE, this);
        darknessPotion.register(this);
        portal = new PortalListener(hadesGroup, SlimefunCustomItems.PORTAL_CREATOR, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.PORTAL_CREATOR_RECIPE, this);
        portal.register(this);
        darkPearl = new DarkPearlListener(hadesGroup, SlimefunCustomItems.DARK_PEARL, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.DARK_PEARL_RECIPE, this);
        darkPearl.register(this);

        // Items in "Hermes" subgroup
        flyingItem = new FlyingItemListener(hermesGroup, SlimefunCustomItems.FLYING_ITEM, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.FLYING_ITEM_RECIPE, this);
        flyingItem.register(this);
        speedBoots = new SpeedBootsListener(hermesGroup, SlimefunCustomItems.SPEED_BOOTS, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SPEED_BOOTS_RECIPE, this);
        speedBoots.register(this);
        speedHorseTame = new SpeedHorseTameListener(hermesGroup, SlimefunCustomItems.SPEED_HORSE_TAME, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.SPEED_HORSE_TAME_RECIPE, this);
        speedHorseTame.register(this);
        speedHorseAbility = new SpeedHorseAbilityListener(hermesGroup, SlimefunCustomItems.HORSE_SPEED_POTION, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.HORSE_SPEED_POTION_RECIPE, this);
        speedHorseAbility.register(this);
        messengerPack = new MessengerPackListener(hermesGroup, SlimefunCustomItems.MESSENGER_BAG, RecipeType.ENHANCED_CRAFTING_TABLE, SlimefunCustomItems.MESSENGER_BAG_RECIPE, this);
        messengerPack.register(this);

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
        Research demeter_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "demeter_research"), 70001, "研究已解锁！", 1);
        demeter_research.addItems(betterBonemeal, growthPotion, flowerHorseTame, hoeOfHarvest);
        demeter_research.register();

        Research dionysus_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "dionysus_research"), 70002, "研究已解锁！", 1);
        dionysus_research.addItems(drunkHorseTame, randomEffectPotion, partyAtmosphere, fireworkBall);
        dionysus_research.register();

        Research hades_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "hades_research"), 70003, "研究已解锁！", 1);
        hades_research.addItems(zombiHorseTame, darknessPotion, portal, darkPearl);
        hades_research.register();

        Research hermes_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "hermes_research"), 70004, "研究已解锁！", 1);
        hermes_research.addItems(flyingItem, speedBoots, speedHorseTame, speedHorseAbility, messengerPack);
        hermes_research.register();

        Research poseidon_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "poseidon_research"), 70005, "研究已解锁！", 1);
        poseidon_research.addItems(seaHorseTame, betterTrident, waterBreathingCrown);
        poseidon_research.register();

        Research zeus_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "zeus_research"), 70006, "研究已解锁！", 1);
        zeus_research.addItems(breedingItem, pegasusTame, pegasusAbility, weatherChanger, lightningSpear);
        zeus_research.register();

        Research tools_research = ItemResearch.createResearch(ItemResearch.createResearchKey(this, "tools_research"), 70007, "研究已解锁！", 10);
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
        // Save the inventory when the server shuts down
        if (messengerPack != null) {
            messengerPack.saveAllInventories();
        }
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
