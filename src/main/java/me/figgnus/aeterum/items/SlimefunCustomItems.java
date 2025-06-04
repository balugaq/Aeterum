package me.figgnus.aeterum.items;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.figgnus.aeterum.items.utils.ItemUtils;

public class SlimefunCustomItems {

// Items
        public static SlimefunItemStack BETTER_BONEMEAL = new SlimefunItemStack("BETTER_BONEMEAL", Material.BONE_MEAL, "&a优质骨粉", "", "&7可对仙人掌和甘蔗使用的骨粉");
        public static SlimefunItemStack GROWTH_POTION = new SlimefunItemStack("GROWTH_POTION", Material.POTION, "&a成长药水", "", "&7可加速玩家周围植物生长的药水");
        public static SlimefunItemStack FL0WER_HORSE_TAME = new SlimefunItemStack("FLOWER_HORSE_TAME", Material.APPLE, "&a甜苹果", "", "&7德墨忒耳（Demeter）可以用这颗苹果驯服她的马");
        public static SlimefunItemStack DRUNK_HORSE_TAME = new SlimefunItemStack("DRUNK_HORSE_TAME", Material.APPLE, "&a发酵苹果", "", "&7狄俄尼索斯（Dionysus）可以用这颗苹果驯服他的马");
        public static SlimefunItemStack ZOMBIE_HORSE_TAME = new SlimefunItemStack("ZOMBIE_HORSE_TAME", Material.APPLE, "&a毒苹果", "", "&7哈迪斯（Hades）可以用这颗苹果驯服他的马");
        public static SlimefunItemStack FLYING_ITEM = new SlimefunItemStack("FLYING_ITEM", Material.STONE_SWORD, "&a飞行之杖", "", "&7火箭不够用？试试这个。");
        public static SlimefunItemStack SPEED_BOOTS = new SlimefunItemStack("SPEED_BOOTS", Material.IRON_BOOTS, "&a速度之靴", "", "&7这双靴子看起来很快速。别绊倒了。");
        public static SlimefunItemStack SPEED_HORSE_TAME = new SlimefunItemStack("SPEED_HORSE_TAME", Material.APPLE, "&a油炸苹果", "", "&7赫尔墨斯（Hermes）可以用这颗苹果驯服他的马");
        public static SlimefunItemStack HORSE_SPEED_POTION = new SlimefunItemStack("HORSE_SPEED_POTION", Material.POTION, "&a马匹速度药水", "", "&7骑上你的马，喝下它，抓紧了");
        public static SlimefunItemStack SEA_HORSE_TAME = new SlimefunItemStack("SEA_HORSE_TAME", Material.APPLE, "&a腌苹果", "", "&7波塞冬（Poseidon）可以用这颗苹果驯服他的马");
        public static SlimefunItemStack PEGASUS_TAME = new SlimefunItemStack("PEGASUS_TAME", Material.APPLE, "&a漂浮苹果", "", "&7宙斯（Zeus）可以用这颗苹果驯服他的马");
        public static SlimefunItemStack BREEDING_ITEM = new SlimefunItemStack("BREEDING_ITEM", Material.SLIME_BALL, "&a动物饲料", "", "&7喂食动物");
        public static SlimefunItemStack HORSE_LEVITATE_POTION = new SlimefunItemStack("HORSE_LEVITATE_POTION", Material.POTION, "&a马匹漂浮药水", "", "&7骑在马上时喝下它");
        public static SlimefunItemStack RANDOMIZER = new SlimefunItemStack("RANDOMIZER", Material.STICK, "&a随机方块放置器", "", "&7放置一个物品栏中的随机方块");
        public static SlimefunItemStack BETTER_TRIDENT = new SlimefunItemStack("BETTER_TRIDENT", Material.TRIDENT, "&a优质三叉戟", "", "&7值得海洋之王使用的武器");
        public static SlimefunItemStack WATTER_BREATHING_CROWN = new SlimefunItemStack("WATER_BREATHING_CROWN", Material.GOLDEN_HELMET, "&a海洋之冠", "", "&7帮助你在水下呼吸。");
        public static SlimefunItemStack WEATHER_CHANGER = new SlimefunItemStack("WEATHER_CHANGER", Material.POTION, "&a风暴药水", "", "&7阳光太强烈？这可能是解决方案");
        public static SlimefunItemStack LIGHTNING_SPEAR = new SlimefunItemStack("LIGHTNING_SPEAR", Material.TRIDENT, "&a闪电矛", "", "&7值得奥林匹斯之主使用的武器");
        public static SlimefunItemStack RANDOM_EFFECT_POTION = new SlimefunItemStack("RANDOM_EFFECT_POTION", Material.POTION, "&a神秘药水", "", "&7会发生什么，谁也说不准");
        public static SlimefunItemStack PARTY_ATMOSPHERE = new SlimefunItemStack("PARTY_ATMOSPHERE", Material.POTION, "&a派对药水", "", "&7让我们嗨起来!!!");
        public static SlimefunItemStack PARTY_BALL = new SlimefunItemStack("PARTY_BALL", Material.SNOWBALL, "&a派对球", "", "&7小心爆炸");
        public static SlimefunItemStack DARKNESS_POTION = new SlimefunItemStack("DARKNESS_POTION", Material.POTION, "&a黑暗药水", "", "&7致盲你的敌人");
        public static SlimefunItemStack PORTAL_CREATOR = new SlimefunItemStack("PORTAL_CREATOR", Material.SPLASH_POTION, "&a黑暗传送药水", "", "&7你会出现在哪里？");
        public static SlimefunItemStack DARK_PEARL = new SlimefunItemStack("DARK_PEARL", Material.ENDER_PEARL, "&a黑暗珍珠", "", "&7只是普通的末影珍珠。可能稍微好一点。");
        public static SlimefunItemStack MESSENGER_BAG = new SlimefunItemStack("MESSENGER_BAG", ItemUtils.createHead("a014f8712f558d20c1477610d82ec32673124647eb1076437dd2cdd2a8637e4a"), "&a商人挎包", "", "&7商人需要一个像样的背包。");
        public static SlimefunItemStack HOE_OF_HARVEST = new SlimefunItemStack("HOE_OF_HARVEST", Material.STICK, "&a丰收之镰", "", "&7如果有人擅长务农，那一定是你。");


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
            new ItemStack(Material.BONE_BLOCK), null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, new ItemStack(Material.BONE_BLOCK),
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
            new ItemStack(Material.TURTLE_EGG), new ItemStack(Material.TURTLE_EGG), new ItemStack(Material.APPLE),
            null, null, null,
            null, null, null,
    };
    public static final ItemStack[] LIGHTNING_SPEAR_RECIPE = {
            null, new ItemStack(Material.LIGHTNING_ROD), null,
            new ItemStack(Material.LIGHTNING_ROD), new ItemStack(Material.TRIDENT), new ItemStack(Material.LIGHTNING_ROD),
            null, new ItemStack(Material.LIGHTNING_ROD), null,
    };
    public static final ItemStack[] RANDOM_EFFECT_POTION_RECIPE = {
            null, new ItemStack(Material.POISONOUS_POTATO), null,
            new ItemStack(Material.BEETROOT), new ItemStack(Material.GLASS_BOTTLE), new ItemStack(Material.BEETROOT),
            null, new ItemStack(Material.BEETROOT), null,
    };
    public static final ItemStack[] PARTY_ATMOSPHERE_RECIPE = {
            null, new ItemStack(Material.GOLD_INGOT), null,
            new ItemStack(Material.BEETROOT), new ItemStack(Material.GLASS_BOTTLE), new ItemStack(Material.BEETROOT),
            null, new ItemStack(Material.GOLDEN_HORSE_ARMOR), null,
    };
    public static final ItemStack[] PARTY_BALL_RECIPE = {
            null, new ItemStack(Material.GOLD_INGOT), null,
            new ItemStack(Material.SNOWBALL), new ItemStack(Material.SNOWBALL), new ItemStack(Material.SNOWBALL),
            null, new ItemStack(Material.SNOWBALL), null,
    };
    public static final ItemStack[] DARKNESS_POTION_RECIPE = {
            null, new ItemStack(Material.BLACK_DYE), null,
            new ItemStack(Material.INK_SAC), new ItemStack(Material.GLASS), new ItemStack(Material.INK_SAC),
            null, new ItemStack(Material.INK_SAC), null,
    };
    public static final ItemStack[] PORTAL_CREATOR_RECIPE = {
            null, null, null,
            new ItemStack(Material.ENDER_EYE), new ItemStack(Material.GLASS), new ItemStack(Material.ENDER_EYE),
            null, new ItemStack(Material.ENDER_PEARL), null,
    };
    public static final ItemStack[] DARK_PEARL_RECIPE = {
            new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL),
            new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN),
            new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.ENDER_PEARL),
    };
    public static final ItemStack[] MESSENGER_BAG_RECIPE = {
            new ItemStack(Material.LEATHER), new ItemStack(Material.EMERALD), new ItemStack(Material.LEATHER),
            new ItemStack(Material.EMERALD), new ItemStack(Material.LEATHER), new ItemStack(Material.EMERALD),
            new ItemStack(Material.LEATHER), new ItemStack(Material.EMERALD), new ItemStack(Material.LEATHER),
    };
    public static final ItemStack[] HOE_OF_HARVEST_RECIPE = {
            new ItemStack(Material.COCOA_BEANS), new ItemStack(Material.WHEAT), new ItemStack(Material.COCOA_BEANS),
            new ItemStack(Material.CARROT), new ItemStack(Material.IRON_HOE), new ItemStack(Material.POTATO),
            new ItemStack(Material.COCOA_BEANS), new ItemStack(Material.BEETROOT), new ItemStack(Material.COCOA_BEANS),
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
