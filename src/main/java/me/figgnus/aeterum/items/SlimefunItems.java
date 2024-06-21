package me.figgnus.aeterum.items;

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

    // Flower horse tame
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

    // Alcohol potion
    public static final SlimefunItemStack alcoholPotionIS = new SlimefunItemStack("ALCOHOL_POTION", Material.POTION, "&aAlcohol Potion", "", "&7Lektvar kterým Dionysus může ochočit svého koňe");
    public static final ItemStack[] alcoholPotionRecipe = {
            null, null, null,
            null, new ItemStack(Material.BONE_BLOCK), null,
            null, null, null,
    };

    // Death potion
    public static final SlimefunItemStack deathPotionIS = new SlimefunItemStack("DEATH_POTION", Material.POTION, "&aDeath Potion", "", "&7Lektvar kterým Hades může ochočit svého koňe");
    public static final ItemStack[] deathPotionRecipe = {
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
}
