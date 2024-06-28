package me.figgnus.aeterum.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.demeter.BetterBonemealListener;
import me.figgnus.aeterum.gods.demeter.FlowerHorseTameListener;
import me.figgnus.aeterum.gods.demeter.GrowthPotionListener;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class SlimefunItems {
    // Better Bone Meal
    public static BetterBonemealListener betterBonemeal(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack betterBonemealIS = new SlimefunItemStack("BETTER_BONEMEAL", Material.SUGAR, "&aBetter Bonemeal", "", "&7Bonemeal který se dá použít na Cactus a Sugar Cane");
        ItemStack[] betterBonemealRecipe = {
                new ItemStack(Material.BONE_MEAL), null, new ItemStack(Material.BONE_MEAL),
                null, new ItemStack(Material.CACTUS), null,
                new ItemStack(Material.BONE_MEAL), null, new ItemStack(Material.BONE_MEAL),
        };
        return new BetterBonemealListener(itemGroup, betterBonemealIS, recipeType, betterBonemealRecipe, plugin);
    }
    // Growth Potion
    public static GrowthPotionListener growthPotion(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack growthPotionIS = new SlimefunItemStack("GROWTH_POTION", Material.POTION, "&aGrowth Potion", "", "&7Lektvar který urychlý růst rostlin v okolí hráče");
        ItemStack[] growthPotionRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(growthPotionIS, Color.fromRGB(63,206,130));
        return new GrowthPotionListener(itemGroup, growthPotionIS, recipeType, growthPotionRecipe, plugin);
    }
    // Demeter Horse Tame
    public static FlowerHorseTameListener demeterTame(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack flowerHorseTameIS = new SlimefunItemStack("FLOWER_HORSE_TAME", Material.POTION, "&aFlower Potion", "", "&7Lektvar kterým Demeter může ochočit svého koňe");
        ItemStack[] flowerHorseTameRecipe = {
                null,null,null,null,new ItemStack(Material.FLOWERING_AZALEA),null,null,null,null
        };
        configureMeta(flowerHorseTameIS, Color.fromRGB(26,112,66));
        return new FlowerHorseTameListener(itemGroup, flowerHorseTameIS, recipeType, flowerHorseTameRecipe, plugin);
    }


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

    public static void configureMeta(SlimefunItemStack item, Color color) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        assert meta != null;
        meta.setColor(color);
        item.setItemMeta(meta);
    }
}
