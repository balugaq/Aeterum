package me.figgnus.aeterum.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SlimefunCustomItems {

    // Items
    public static SlimefunItemStack BETTER_BONEMEAL = new SlimefunItemStack("BETTER_BONEMEAL", Material.BONE_MEAL, "&aBetter Bonemeal", "", "&7Bonemeal který se dá použít na Cactus a Sugar Cane");
    public static SlimefunItemStack GROWTH_POTION = new SlimefunItemStack("GROWTH_POTION", Material.POTION, "&aGrowth Potion", "", "&7Lektvar který urychlý růst rostlin v okolí hráče");
    public static SlimefunItemStack FL0WER_HORSE_TAME = new SlimefunItemStack("FLOWER_HORSE_TAME", Material.APPLE, "&aSweet Apple", "", "&7Jablko kterým Demeter může ochočit svého koňe");
    public static SlimefunItemStack DRUNK_HORSE_TAME = new SlimefunItemStack("DRUNK_HORSE_TAME", Material.APPLE, "&aFermented Apple", "", "&7Jablko kterým Dionysus může ochočit svého koňe");
    public static SlimefunItemStack ZOMBIE_HORSE_TAME = new SlimefunItemStack("ZOMBIE_HORSE_TAME", Material.APPLE, "&aPoisoned Apple", "", "&7Jablko kterým Hades může ochočit svého koňe");
    public static SlimefunItemStack FLYING_ITEM = new SlimefunItemStack("FLYING_ITEM", Material.STONE_SWORD, "&aFlying Wand", "", "&7Málo raketek? Použij toto.");
    public static SlimefunItemStack SPEED_BOOTS = new SlimefunItemStack("SPEED_BOOTS", Material.IRON_BOOTS, "&aSpeed Boots", "", "&7Tyhle botky vypadají rychle. Nezakopni.");
    public static SlimefunItemStack SPEED_HORSE_TAME = new SlimefunItemStack("SPEED_HORSE_TAME", Material.APPLE, "&aHasted Apple", "", "&7Jablko kterým Hermes může ochočit svého koňe");
    public static SlimefunItemStack HORSE_SPEED_POTION = new SlimefunItemStack("HORSE_SPEED_POTION", Material.POTION, "&aHorse Speed Potion", "", "&7Sedni na svého koně, napij se a drž se");
    public static SlimefunItemStack SEA_HORSE_TAME = new SlimefunItemStack("SEA_HORSE_TAME", Material.APPLE, "&aSalty Apple", "", "&7Jablko kterým Poseidon může ochočit svého koňe");
    public static SlimefunItemStack PEGASUS_TAME = new SlimefunItemStack("PEGASUS_TAME", Material.APPLE, "&aLevity Apple", "", "&7Jablko kterým Zeus může ochočit svého koňe");
    public static SlimefunItemStack BREEDING_ITEM = new SlimefunItemStack("BREEDING_ITEM", Material.SLIME_BALL, "&aAnimal Feed", "", "&7Nakrm zvíře");
    public static SlimefunItemStack HORSE_LEVITATE_POTION = new SlimefunItemStack("HORSE_LEVITATE_POTION", Material.POTION, "&aHorse Levitate Potion", "", "&7Napij se když si na svém koni");
    public static SlimefunItemStack RANDOMIZER = new SlimefunItemStack("RANDOMIZER", Material.IRON_SHOVEL, "&aRandomizer", "", "&7Položí náhodný block s hotbaru");
    public static SlimefunItemStack BETTER_TRIDENT = new SlimefunItemStack("BETTER_TRIDENT", Material.TRIDENT, "&aBetter Trident", "", "&7Zbraň hodná krále moří");
    public static SlimefunItemStack WATTER_BREATHING_CROWN = new SlimefunItemStack("WATER_BREATHING_CROWN", Material.GOLDEN_HELMET, "&aCrown of the Seas", "", "&7Pomáhá dýchat pod vodou.");
    public static SlimefunItemStack WEATHER_CHANGER = new SlimefunItemStack("WEATHER_CHANGER", Material.POTION, "&aPotion of Storm", "", "&7Moc slunečno? Tohle by mohlo být řešení");
    public static SlimefunItemStack LIGHTNING_SPEAR = new SlimefunItemStack("LIGHTNING_SPEAR", Material.TRIDENT, "&aLightning Spear", "", "&7Zbraň hodná vládce Olympu");
    public static SlimefunItemStack RANDOM_EFFECT_POTION = new SlimefunItemStack("RANDOM_EFFECT_POTION", Material.POTION, "&aMysterious Brew", "", "&7Kdo vý co se může stát");
    public static SlimefunItemStack PARTY_ATMOSPHERE = new SlimefunItemStack("PARTY_ATMOSPHERE", Material.POTION, "&aParty Atmosphere", "", "&7Let's Party!!!");
    public static SlimefunItemStack PARTY_BALL = new SlimefunItemStack("PARTY_BALL", Material.SNOWBALL, "&aParty Ball", "", "&7Pozor na výbuch");
    public static SlimefunItemStack DARKNESS_POTION = new SlimefunItemStack("DARKNESS_POTION", Material.POTION, "&aDarkness", "", "&7Oslep své nepřátele");
    public static SlimefunItemStack PORTAL_CREATOR = new SlimefunItemStack("PORTAL_CREATOR", Material.SPLASH_POTION, "&aDark Portal", "", "&7Kde se objevíš?");
    public static SlimefunItemStack DARK_PEARL = new SlimefunItemStack("DARK_PEARL", Material.ENDER_PEARL, "&aDark Pearl", "", "&7Prostě Ender Pearl. Možná trochu lepší.");
    public static SlimefunItemStack MESSENGER_BAG = new SlimefunItemStack("MESSENGER_BAG", ItemUtils.createHead("a014f8712f558d20c1477610d82ec32673124647eb1076437dd2cdd2a8637e4a"), "&aMerchant's Satchel", "", "&7Bůh obchodníků potřebuje pořádnou brašnu.");


    // Helper Items
    static SlimefunItem YEAST =  SlimefunItem.getById("YEAST");

    // Recipes
    public static final ItemStack[] betterBonemealRecipe = {
            new ItemStack(Material.BONE_MEAL), new ItemStack(Material.BONE_MEAL), null,
            new ItemStack(Material.BONE_MEAL), new ItemStack(Material.BONE_MEAL), null,
            null, null, null,
    };
    public static final ItemStack[] GROWTH_POTION_RECIPE = {
            null, BETTER_BONEMEAL, null,
            BETTER_BONEMEAL, new ItemStack(Material.GLASS_BOTTLE), BETTER_BONEMEAL,
            null, BETTER_BONEMEAL, null,
    };
    public static final ItemStack[] FLOWER_HORSE_TAME_RECIPE = {
            null,new ItemStack(Material.SUGAR),null,
            new ItemStack(Material.SUGAR),new ItemStack(Material.APPLE),new ItemStack(Material.SUGAR),
            null,new ItemStack(Material.SUGAR),null
    };
    public static final ItemStack[] DRUNK_HORSE_TAME_RECIPE = {
            null, YEAST.getItem(), null,
            YEAST.getItem(), new ItemStack(Material.APPLE), YEAST.getItem(),
            null, YEAST.getItem(), null,
    };
    public static final ItemStack[] ZOMBIE_HORSE_TAME_RECIPE = {
            null, new ItemStack(Material.WITHER_ROSE), null,
            new ItemStack(Material.WITHER_ROSE), new ItemStack(Material.APPLE), new ItemStack(Material.WITHER_ROSE),
            null, new ItemStack(Material.WITHER_ROSE), null,
    };
    public static final ItemStack[] FLYING_ITEM_RECIPE = {
            null, new ItemStack(Material.FIREWORK_ROCKET), null,
            new ItemStack(Material.FIREWORK_ROCKET), new ItemStack(Material.ELYTRA), new ItemStack(Material.FIREWORK_ROCKET),
            null, new ItemStack(Material.FIREWORK_ROCKET), null,
    };
    public static final ItemStack[] SPEED_BOOTS_RECIPE = {
            null, ItemUtils.createPotion(PotionType.SPEED), null,
            ItemUtils.createPotion(PotionType.SPEED), new ItemStack(Material.IRON_BOOTS), ItemUtils.createPotion(PotionType.SPEED),
            null, null, null,
    };
    public static final ItemStack[] SPEED_HORSE_TAME_RECIPE = {
            null, ItemUtils.createPotion(PotionType.SPEED), null,
            ItemUtils.createPotion(PotionType.SPEED), new ItemStack(Material.APPLE), ItemUtils.createPotion(PotionType.SPEED),
            null, ItemUtils.createPotion(PotionType.SPEED), null,
    };
    public static final ItemStack[] HORSE_SPEED_POTION_RECIPE = {
            ItemUtils.createPotion(PotionType.SPEED), new ItemStack(Material.APPLE), null,
            null, null, null,
            null, null, null,
    };
    public static final ItemStack[] SEA_HORSE_TAME_RECIPE = {
            null, SlimefunItems.SALT, null,
            SlimefunItems.SALT, new ItemStack(Material.APPLE), SlimefunItems.SALT,
            null, SlimefunItems.SALT, null,
    };
    public static final ItemStack[] PEGASUS_TAME_RECIPE = {
            null, ItemUtils.createPotion(PotionType.SLOW_FALLING), null,
            ItemUtils.createPotion(PotionType.SLOW_FALLING), new ItemStack(Material.APPLE), ItemUtils.createPotion(PotionType.SLOW_FALLING),
            null, ItemUtils.createPotion(PotionType.SLOW_FALLING), null,
    };
    public static final ItemStack[] BREEDING_ITEM_RECIPE = {
            null, new ItemStack(Material.CARROT), null,
            new ItemStack(Material.BEETROOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.WHEAT),
            null, new ItemStack(Material.POTATO), null,
    };
    public static final ItemStack[] HORSE_LEVITATE_POTION_RECIPE = {
            ItemUtils.createPotion(PotionType.SLOW_FALLING), new ItemStack(Material.APPLE), null,
            null, null, null,
            null, null, null,
    };
    public static final ItemStack[] RANDOMIZER_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] BETTER_TRIDENT_RECIPE = {
            null, new ItemStack(Material.BOOK), null,
            new ItemStack(Material.BOOK), new ItemStack(Material.TRIDENT), new ItemStack(Material.BOOK),
            null, new ItemStack(Material.BOOK), null,
    };
    public static final ItemStack[] WATER_BREATHING_CROWN_RECIPE = {
            new ItemStack(Material.TURTLE_HELMET), new ItemStack(Material.GOLDEN_HELMET), null,
            null, null, null,
            null, null, null,
    };
    public static final ItemStack[] WEATHER_CHANGER_RECIPE = {
            new ItemStack(Material.TURTLE_EGG), null, null,
            null, null, null,
            null, null, null,
    };
    public static final ItemStack[] LIGHTNING_SPEAR_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.TRIDENT), null,
            null, null, null,
    };
    public static final ItemStack[] RANDOM_EFFECT_POTION_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.GLASS_BOTTLE), null,
            null, null, null,
    };
    public static final ItemStack[] PARTY_ATMOSPHERE_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.GLASS_BOTTLE), null,
            null, null, null,
    };
    public static final ItemStack[] PARTY_BALL_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.SNOWBALL), null,
            null, null, null,
    };
    public static final ItemStack[] DARKNESS_POTION_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.GLASS), null,
            null, null, null,
    };
    public static final ItemStack[] PORTAL_CREATOR_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.GLASS), null,
            null, null, null,
    };
    public static final ItemStack[] DARK_PEARL_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.ENDER_PEARL), null,
            null, null, null,
    };
    public static final ItemStack[] MESSENGER_BAG_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.LEATHER), null,
            null, null, null,
    };

    // Lists of enchantments for items
    List<Map.Entry<Enchantment, Integer>> betterTridentEnchantments = new ArrayList<>();
    List<Map.Entry<Enchantment, Integer>> waterBreathingCrownEnchantments = new ArrayList<>();

    public SlimefunCustomItems() {
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.RIPTIDE, 5));
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.IMPALING, 7));
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.DURABILITY, 3));
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.MENDING, 1));

        waterBreathingCrownEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.WATER_WORKER, 1));
        waterBreathingCrownEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.OXYGEN, 5));

        ItemUtils.configureMeta(GROWTH_POTION, Color.fromRGB(63,206,130), null);
        ItemUtils.configureMeta(HORSE_SPEED_POTION, Color.fromRGB(193,193,193), null);
        ItemUtils.configureMeta(HORSE_LEVITATE_POTION, Color.fromRGB(204,205,208), null);
        ItemUtils.configureMeta(WEATHER_CHANGER, Color.fromRGB(165, 161, 215), null);
        ItemUtils.configureMeta(RANDOM_EFFECT_POTION, Color.fromRGB(43,158,54), null);
        ItemUtils.configureMeta(PARTY_ATMOSPHERE, Color.fromRGB(255,158,54), null);
        ItemUtils.configureMeta(DARKNESS_POTION, Color.fromRGB(255,30,1), null);
        ItemUtils.configureMeta(PORTAL_CREATOR, Color.fromRGB(255,30,50), null);
        ItemUtils.configureMeta(BETTER_TRIDENT, null, betterTridentEnchantments);
        ItemUtils.configureMeta(WATTER_BREATHING_CROWN, null, waterBreathingCrownEnchantments);
    }
}
