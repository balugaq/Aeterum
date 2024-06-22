package me.figgnus.aeterum._items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SlimefunItems {
    // Better Bonemeal
    public static final SlimefunItemStack betterBonemealIS = new SlimefunItemStack("BETTER_BONEMEAL", Material.SUGAR, "&aBetter Bonemeal", "", "&7Bonemeal který se dá použít na Cactus a Sugar Cane");
    public static final ItemStack[] betterBonemealRecipe = {
            new ItemStack(Material.BONE_MEAL), null, new ItemStack(Material.BONE_MEAL),
            null, new ItemStack(Material.CACTUS), null,
            new ItemStack(Material.BONE_MEAL), null, new ItemStack(Material.BONE_MEAL),
    };
    // Demeter tame item
    public static final SlimefunItemStack flowerHorseTameIS = new SlimefunItemStack("FLOWER_HORSE_TAME", Material.POTION, "&aFlower Potion", "", "&7Lektvar kterým Demeter může ochočit svého koňe");
    public static final ItemStack[] flowerHorseTameRecipe = {
            null,null,null,null,new ItemStack(Material.FLOWERING_AZALEA),null,null,null,null
    };
    // Growth potion
    public static final SlimefunItemStack growthPotionIS = new SlimefunItemStack("GROWTH_POTION", Material.POTION, "&aGrowth Potion", "", "&7Lektvar který urychlý růst rostlin v okolí hráče");
    public static final ItemStack[] growthPotionRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Dionysus tame item
    public static final SlimefunItemStack drunkHorseTameIS = new SlimefunItemStack("DRUNK_HORSE_TAME", Material.POTION, "&aAlcohol Potion", "", "&7Lektvar kterým Dionysus může ochočit svého koňe");
    public static final ItemStack[] drunkHorseTameRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Hades tame item
    public static final SlimefunItemStack zombieHorseTameIS = new SlimefunItemStack("ZOMBIE_HORSE_TAME", Material.POTION, "&aDeath Potion", "", "&7Lektvar kterým Hades může ochočit svého koňe");
    public static final ItemStack[] zombieHorseTameRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Flying item
    public static final SlimefunItemStack flyingItemIS = new SlimefunItemStack("FLYING_ITEM", Material.STONE_SWORD, "&aFlying Wand", "", "&7Málo raketek? Použij toto.");
    public static final ItemStack[] flyingItemRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Speed Boots
    public static final SlimefunItemStack speedBootsIS = new SlimefunItemStack("SPEED_BOOTS", Material.IRON_BOOTS, "&aSpeed Boots", "", "&7Tyhle botky vypadají rychle. Nezakopni.");
    public static final ItemStack[] speedBootsRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Hermes tame item
    public static final SlimefunItemStack speedHorseTameIS = new SlimefunItemStack("SPEED_HORSE_TAME", Material.POTION, "&aHaste Potion", "", "&7Lektvar kterým Hermes může ochočit svého koňe");
    public static final ItemStack[] speedHorseTameRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Horse Speed potion
    public static final SlimefunItemStack horseSpeedPotionIS = new SlimefunItemStack("HORSE_SPEED_POTION", Material.POTION, "&aHorse Speed Potion", "", "&7Sedni na svého koně, napij se a drž se");
    public static final ItemStack[] horseSpeedPotionRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Poseidon tame item
    public static final SlimefunItemStack seaHorseTameIS = new SlimefunItemStack("SEA_HORSE_TAME", Material.POTION, "&aSea Potion", "", "&7Lektvar kterým Poseidon může ochočit svého koňe");
    public static final ItemStack[] seaHorseTameRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Zeus tame item
    public static final SlimefunItemStack pegasusTameIS = new SlimefunItemStack("PEGASUS_TAME_TAME", Material.POTION, "&aLevity Potion", "", "&7Lektvar kterým Zeus může ochočit svého koňe");
    public static final ItemStack[] pegasusTameRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Breeding item
    public static final SlimefunItemStack breedingItemIS = new SlimefunItemStack("BREEDING_ITEM", Material.SLIME_BALL, "&aAnimal Feed", "", "&7Nakrm zvíře");
    public static final ItemStack[] breedingItemRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Pegasus Ability
    public static final SlimefunItemStack horseLevitatePotionIS = new SlimefunItemStack("HORSE_LEVITATE_POTION", Material.POTION, "&aHorse Levitate Potion", "", "&7Napij se když si na svém koni");
    public static final ItemStack[] horseLevitatePotionRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
    // Pegasus Ability
    public static final SlimefunItemStack randomizerIS = new SlimefunItemStack("RANDOMIZER", Material.IRON_SHOVEL, "&aRandomizer", "", "&7Položí náhodný block s hotbaru");
    public static final ItemStack[] randomizerRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };
}
