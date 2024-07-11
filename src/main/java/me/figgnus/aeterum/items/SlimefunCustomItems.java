package me.figgnus.aeterum.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.figgnus.aeterum.items.utils.ItemUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SlimefunCustomItems {

    // Items
    public static SlimefunItemStack BETTER_BONEMEAL = new SlimefunItemStack("BETTER_BONEMEAL", Material.BONE_MEAL, "&aBetter Bonemeal", "", "&7Bonemeal který se dá použít na Cactus a Sugar Cane");
    public static SlimefunItemStack GROWTH_POTION = new SlimefunItemStack("GROWTH_POTION", Material.POTION, "&aGrowth Potion", "", "&7Lektvar který urychlý růst rostlin v okolí hráče");
    public static SlimefunItemStack FL0WER_HORSE_TAME = new SlimefunItemStack("FLOWER_HORSE_TAME", Material.POTION, "&aFlower Potion", "", "&7Lektvar kterým Demeter může ochočit svého koňe");
    public static SlimefunItemStack DRUNK_HORSE_TAME = new SlimefunItemStack("DRUNK_HORSE_TAME", Material.POTION, "&aAlcohol Potion", "", "&7Lektvar kterým Dionysus může ochočit svého koňe");
    public static SlimefunItemStack ZOMBIE_HORSE_TAME = new SlimefunItemStack("ZOMBIE_HORSE_TAME", Material.POTION, "&aDeath Potion", "", "&7Lektvar kterým Hades může ochočit svého koňe");
    public static SlimefunItemStack FLYING_ITEM = new SlimefunItemStack("FLYING_ITEM", Material.STONE_SWORD, "&aFlying Wand", "", "&7Málo raketek? Použij toto.");
    public static SlimefunItemStack SPEED_BOOTS = new SlimefunItemStack("SPEED_BOOTS", Material.IRON_BOOTS, "&aSpeed Boots", "", "&7Tyhle botky vypadají rychle. Nezakopni.");
    public static SlimefunItemStack SPEED_HORSE_TAME = new SlimefunItemStack("SPEED_HORSE_TAME", Material.POTION, "&aHaste Potion", "", "&7Lektvar kterým Hermes může ochočit svého koňe");
    public static SlimefunItemStack HORSE_SPEED_POTION = new SlimefunItemStack("HORSE_SPEED_POTION", Material.POTION, "&aHorse Speed Potion", "", "&7Sedni na svého koně, napij se a drž se");
    public static SlimefunItemStack SEA_HORSE_TAME = new SlimefunItemStack("SEA_HORSE_TAME", Material.POTION, "&aSea Potion", "", "&7Lektvar kterým Poseidon může ochočit svého koňe");
    public static SlimefunItemStack PEGASUS_TAME_TAME = new SlimefunItemStack("PEGASUS_TAME_TAME", Material.POTION, "&aLevity Potion", "", "&7Lektvar kterým Zeus může ochočit svého koňe");
    public static SlimefunItemStack BREEDING_ITEM = new SlimefunItemStack("BREEDING_ITEM", Material.SLIME_BALL, "&aAnimal Feed", "", "&7Nakrm zvíře");
    public static SlimefunItemStack HORSE_LEVITATE_POTION = new SlimefunItemStack("HORSE_LEVITATE_POTION", Material.POTION, "&aHorse Levitate Potion", "", "&7Napij se když si na svém koni");
    public static SlimefunItemStack RANDOMIZER = new SlimefunItemStack("RANDOMIZER", Material.IRON_SHOVEL, "&aRandomizer", "", "&7Položí náhodný block s hotbaru");
    public static SlimefunItemStack BETTER_TRIDENT = new SlimefunItemStack("BETTER_TRIDENT", Material.TRIDENT, "&aBetter Trident", "", "&7Zbraň hodná krále moří");

    // Recipes
    public static final ItemStack[] betterBonemealRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_MEAL), new ItemStack(Material.BONE_MEAL),
            null, new ItemStack(Material.BONE_MEAL), new ItemStack(Material.BONE_MEAL),
    };
    public static final ItemStack[] GROWTH_POTION_RECIPE = {
            null, BETTER_BONEMEAL, null,
            BETTER_BONEMEAL, new ItemStack(Material.GLASS_BOTTLE), BETTER_BONEMEAL,
            null, BETTER_BONEMEAL, null,
    };
    public static final ItemStack[] FLOWER_HORSE_TAME_RECIPE = {
            null,new ItemStack(Material.MOSS_BLOCK),null,
            new ItemStack(Material.MOSS_BLOCK),new ItemStack(Material.GLASS_BOTTLE),new ItemStack(Material.MOSS_BLOCK),
            null,new ItemStack(Material.MOSS_BLOCK),null
    };
    public static final ItemStack[] DRUNK_HORSE_TAME_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] ZOMBIE_HORSE_TAME_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] FLYING_ITEM_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] SPEED_BOOTS_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] SPEED_HORSE_TAME_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] HORSE_SPEED_POTION_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] SEA_HORSE_TAME_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] PEGASUS_TAME_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] BREEDING_ITEM_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] HORSE_LEVITATE_POTION_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] RANDOMIZER_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    public static final ItemStack[] BETTER_TRIDENT_RECIPE = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };

    List<Map.Entry<Enchantment, Integer>> betterTridentEnchantments = new ArrayList<>();

    public SlimefunCustomItems() {
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.RIPTIDE, 5));
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.IMPALING, 7));
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.DURABILITY, 3));
        betterTridentEnchantments.add(new AbstractMap.SimpleEntry<>(Enchantment.MENDING, 1));


        ItemUtils.configureMeta(GROWTH_POTION, Color.fromRGB(63,206,130), null);
        ItemUtils.configureMeta(FL0WER_HORSE_TAME, Color.fromRGB(26,112,66), null);
        ItemUtils.configureMeta(DRUNK_HORSE_TAME, Color.fromRGB(121,44,44), null);
        ItemUtils.configureMeta(ZOMBIE_HORSE_TAME, Color.fromRGB(85,104,86), null);
        ItemUtils.configureMeta(SPEED_HORSE_TAME, Color.fromRGB(141,252,255), null);
        ItemUtils.configureMeta(HORSE_SPEED_POTION, Color.fromRGB(193,193,193), null);
        ItemUtils.configureMeta(SEA_HORSE_TAME, Color.fromRGB(31,47,192), null);
        ItemUtils.configureMeta(PEGASUS_TAME_TAME, Color.fromRGB(255,255,255), null);
        ItemUtils.configureMeta(HORSE_LEVITATE_POTION, Color.fromRGB(204,205,208), null);
        ItemUtils.configureMeta(BETTER_TRIDENT, null, betterTridentEnchantments);
    }
}
