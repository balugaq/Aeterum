package me.figgnus.aeterum.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.figgnus.aeterum.Aeterum;
import me.figgnus.aeterum.gods.demeter.BetterBonemealListener;
import me.figgnus.aeterum.gods.demeter.FlowerHorseTameListener;
import me.figgnus.aeterum.gods.demeter.GrowthPotionListener;
import me.figgnus.aeterum.gods.dionysos.DrunkHorseTameListener;
import me.figgnus.aeterum.gods.hades.ZombieHorseTameListener;
import me.figgnus.aeterum.gods.hermes.FlyingItemListener;
import me.figgnus.aeterum.gods.hermes.SpeedBootsListener;
import me.figgnus.aeterum.gods.hermes.SpeedHorseAbilityListener;
import me.figgnus.aeterum.gods.hermes.SpeedHorseTameListener;
import me.figgnus.aeterum.gods.poseidon.SeaHorseTameListener;
import me.figgnus.aeterum.gods.zeus.BreedingItemListener;
import me.figgnus.aeterum.gods.zeus.PegasusAbilityListener;
import me.figgnus.aeterum.gods.zeus.PegasusTameListener;
import me.figgnus.aeterum.items.item_listener.RandomizerListener;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
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
    // Dionysus Horse Tame
    public static DrunkHorseTameListener dionysusTame(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack drunkHorseTameIS = new SlimefunItemStack("DRUNK_HORSE_TAME", Material.POTION, "&aAlcohol Potion", "", "&7Lektvar kterým Dionysus může ochočit svého koňe");
        ItemStack[] drunkHorseTameRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,};
        configureMeta(drunkHorseTameIS, Color.fromRGB(121,44,44));
        return new DrunkHorseTameListener(itemGroup, drunkHorseTameIS, recipeType, drunkHorseTameRecipe, plugin);
    }
    // Hades Horse Tame
    public static ZombieHorseTameListener hadesTame(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack zombieHorseTameIS = new SlimefunItemStack("ZOMBIE_HORSE_TAME", Material.POTION, "&aDeath Potion", "", "&7Lektvar kterým Hades může ochočit svého koňe");
        ItemStack[] zombieHorseTameRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(zombieHorseTameIS, Color.fromRGB(85,104,86));
        return new ZombieHorseTameListener(itemGroup, zombieHorseTameIS, recipeType, zombieHorseTameRecipe, plugin);
    }
    // Flying Item
    public static FlyingItemListener flyingItem(SubItemGroup itemGroupm, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack flyingItemIS = new SlimefunItemStack("FLYING_ITEM", Material.STONE_SWORD, "&aFlying Wand", "", "&7Málo raketek? Použij toto.");
        ItemStack[] flyingItemRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        return  new FlyingItemListener(itemGroupm, flyingItemIS, recipeType, flyingItemRecipe, plugin);
    }
    // Speed Boots
    public static SpeedBootsListener speedBoots(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack speedBootsIS = new SlimefunItemStack("SPEED_BOOTS", Material.IRON_BOOTS, "&aSpeed Boots", "", "&7Tyhle botky vypadají rychle. Nezakopni.");
        ItemStack[] speedBootsRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        return new SpeedBootsListener(itemGroup, speedBootsIS, recipeType, speedBootsRecipe, plugin);
    }
    // Hermes Horse Tame
    public static SpeedHorseTameListener hermesTame(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack speedHorseTameIS = new SlimefunItemStack("SPEED_HORSE_TAME", Material.POTION, "&aHaste Potion", "", "&7Lektvar kterým Hermes může ochočit svého koňe");
        ItemStack[] speedHorseTameRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(speedHorseTameIS, Color.fromRGB(141,252,255));
        return new SpeedHorseTameListener(itemGroup, speedHorseTameIS, recipeType, speedHorseTameRecipe, plugin);
    }
    // Hermes Horse Ability
    public static SpeedHorseAbilityListener horseSpeedPotion(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack horseSpeedPotionIS = new SlimefunItemStack("HORSE_SPEED_POTION", Material.POTION, "&aHorse Speed Potion", "", "&7Sedni na svého koně, napij se a drž se");
        ItemStack[] horseSpeedPotionRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(horseSpeedPotionIS, Color.fromRGB(193,193,193));
        return new SpeedHorseAbilityListener(itemGroup, horseSpeedPotionIS, recipeType, horseSpeedPotionRecipe, plugin);
    }
    // Poseidon Horse Tame
    public static SeaHorseTameListener poseidonTame(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack seaHorseTameIS = new SlimefunItemStack("SEA_HORSE_TAME", Material.POTION, "&aSea Potion", "", "&7Lektvar kterým Poseidon může ochočit svého koňe");
        ItemStack[] seaHorseTameRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(seaHorseTameIS, Color.fromRGB(31,47,192));
        return new SeaHorseTameListener(itemGroup, seaHorseTameIS, recipeType, seaHorseTameRecipe, plugin);
    }
    // Zeus Horse Tame
    public static PegasusTameListener zeusTame(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack pegasusTameIS = new SlimefunItemStack("PEGASUS_TAME_TAME", Material.POTION, "&aLevity Potion", "", "&7Lektvar kterým Zeus může ochočit svého koňe");
        ItemStack[] pegasusTameRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(pegasusTameIS, Color.fromRGB(255,255,255));
        return new PegasusTameListener(itemGroup, pegasusTameIS, recipeType, pegasusTameRecipe, plugin);
    }
    // Breeding Item
    public static BreedingItemListener breedingItem(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack breedingItemIS = new SlimefunItemStack("BREEDING_ITEM", Material.SLIME_BALL, "&aAnimal Feed", "", "&7Nakrm zvíře");
        ItemStack[] breedingItemRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        return new BreedingItemListener(itemGroup, breedingItemIS, recipeType, breedingItemRecipe, plugin);
    }
    // Zeus Horse Ability
    public static PegasusAbilityListener horseLevitatePotion(SubItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack horseLevitatePotionIS = new SlimefunItemStack("HORSE_LEVITATE_POTION", Material.POTION, "&aHorse Levitate Potion", "", "&7Napij se když si na svém koni");
        ItemStack[] horseLevitatePotionRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        configureMeta(horseLevitatePotionIS, Color.fromRGB(204,205,208));
        return new PegasusAbilityListener(itemGroup, horseLevitatePotionIS, recipeType, horseLevitatePotionRecipe, plugin);
    }
    // Randomizer
    public static RandomizerListener randomizer(ItemGroup itemGroup, RecipeType recipeType, Aeterum plugin){
        SlimefunItemStack randomizerIS = new SlimefunItemStack("RANDOMIZER", Material.IRON_SHOVEL, "&aRandomizer", "", "&7Položí náhodný block s hotbaru");
        ItemStack[] randomizerRecipe = {
                null, null, null,
                null, new ItemStack(Material.BONE_BLOCK), null,
                null, null, null,
        };
        return new RandomizerListener(itemGroup, randomizerIS, recipeType, randomizerRecipe, plugin);
    }


    public static void configureMeta(SlimefunItemStack item, Color color) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        assert meta != null;
        meta.setColor(color);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
    }
}
