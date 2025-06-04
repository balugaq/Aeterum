package me.figgnus.aeterum.brewery_menu;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.figgnus.aeterum.Aeterum;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreweryMenu {
    private final Aeterum plugin;

    public BreweryMenu(Aeterum plugin) {
        this.plugin = plugin;

        // item that represents group
        ItemStack breweryGroupItem = new CustomItemStack(Material.POTION, "&eBrewery", "", "&aObjevte nádherný svět alkoholu...");
//        ItemMeta meta = breweryGroupItem.getItemMeta();
//        assert meta != null;
//        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//        breweryGroupItem.setItemMeta(meta);

        // Give your Category a unique id.
        NamespacedKey breweryGroupId = new NamespacedKey(plugin, "brewery_category");
        // creates group
        ItemGroup breweryGroup = new ItemGroup(breweryGroupId, breweryGroupItem);


        //item stacks (needed for creating item)
        SlimefunItemStack cauldron_stack = new SlimefunItemStack("BREWERY", Material.CAULDRON, "&eBrewery");
        SlimefunItemStack skotska_whisky_stack = new SlimefunItemStack("SKOTSKA_WHISKY", Material.POTION, "&eSkotská Whisky");
        configurePotionMeta(skotska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack irska_whisky_stack = new SlimefunItemStack("IRSKA_WHISKY", Material.POTION, "&eIrská Whisky");
        configurePotionMeta(irska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack bourbon_stack = new SlimefunItemStack("BOURBON", Material.POTION, "&eBourbon");
        configurePotionMeta(bourbon_stack, createNewColor(186,125,84));
        SlimefunItemStack psenicne_pivo_stack = new SlimefunItemStack("PSENICNE_PIVO", Material.POTION, "&ePšeničné Pivo");
        configurePotionMeta(psenicne_pivo_stack, createNewColor(255,184,77));
        SlimefunItemStack pivo_stack = new SlimefunItemStack("PIVO", Material.POTION, "&ePivo");
        configurePotionMeta(pivo_stack, createNewColor(255,211,51));
        SlimefunItemStack tmavy_lezak_stack = new SlimefunItemStack("TMAVY_LEZAK", Material.POTION, "&eTmavý Ležák");
        configurePotionMeta(tmavy_lezak_stack, createNewColor(101,0,19));
        SlimefunItemStack cervene_vino_stack = new SlimefunItemStack("CERVENE_VINO", Material.POTION, "&eČervené Víno");
        configurePotionMeta(cervene_vino_stack, Color.RED);
        SlimefunItemStack bile_vino_stack = new SlimefunItemStack("BILE_VINO", Material.POTION, "&eBílé Víno");
        configurePotionMeta(bile_vino_stack, Color.YELLOW);
        SlimefunItemStack medovina_stack = new SlimefunItemStack("MEDOVINA", Material.POTION, "&eMedovina");
        configurePotionMeta(medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecna_medovina_stack = new SlimefunItemStack("JABLECNA_MEDOVINA", Material.POTION, "&eJablečná Medovina");
        configurePotionMeta(jablecna_medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecny_most_stack = new SlimefunItemStack("JABLECNY_MOST", Material.POTION, "&eJablečný Mošt");
        configurePotionMeta(jablecny_most_stack, createNewColor(248,104,32));
        SlimefunItemStack jablecny_liker_stack = new SlimefunItemStack("JABLECNY_LIKER", Material.POTION, "&eJablečný Likér");
        configurePotionMeta(jablecny_liker_stack, Color.RED);
        SlimefunItemStack rum_stack = new SlimefunItemStack("RUM", Material.POTION, "&eRum");
        configurePotionMeta(rum_stack, Color.MAROON);
        SlimefunItemStack vodka_stack = new SlimefunItemStack("VODKA", Material.POTION, "&eVodka");
        configurePotionMeta(vodka_stack, Color.WHITE);
        SlimefunItemStack houbova_vodka_stack = new SlimefunItemStack("HOUBOVA_VODKA", Material.POTION, "&eHoubová Vodka");
        configurePotionMeta(houbova_vodka_stack, createNewColor(255,153,153));
        SlimefunItemStack gin_stack = new SlimefunItemStack("GIN", Material.POTION, "&eGin");
        configurePotionMeta(gin_stack, createNewColor(153,221,255));
        SlimefunItemStack tequila_stack = new SlimefunItemStack("AETERUM_TEQUILA", Material.POTION, "&eTequila liqueur"); // 龙舌兰利口酒
        configurePotionMeta(tequila_stack, createNewColor(245,240,126));
        SlimefunItemStack absinth_stack = new SlimefunItemStack("ABSINTH", Material.POTION, "&eAbsinth");
        configurePotionMeta(absinth_stack, Color.GREEN);
        SlimefunItemStack zeleny_absinth_stack = new SlimefunItemStack("ZELENY_ABSINTH", Material.POTION, "&eZelený Absinth");
        configurePotionMeta(zeleny_absinth_stack, Color.LIME);
        SlimefunItemStack bramborova_polevka_stack = new SlimefunItemStack("BRAMBOROVA_POLEVKA", Material.POTION, "&eBramborová Polévka");
        configurePotionMeta(bramborova_polevka_stack, Color.ORANGE);
        SlimefunItemStack kava_stack = new SlimefunItemStack("KAVA", Material.POTION, "&eKáva");
        configurePotionMeta(kava_stack, Color.BLACK);
        SlimefunItemStack vajecnak_stack = new SlimefunItemStack("VAJECNAK", Material.POTION, "&eVaječňák");
        configurePotionMeta(vajecnak_stack, createNewColor(255,230,128));

        //recipe for items
        ItemStack[] item = {null, null, null, null, null, null, null, null, null};

        ItemStack[] cauldron_recipe = {null, null, null, null, createMultiblockRecipe(Material.CAULDRON, "Naplnit vodou."), null, createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "Oheň musí být obestavený schody."), createMultiblockRecipe(Material.FLINT_AND_STEEL, "Oheň nebo jiný zdroj tepla."), createMultiblockRecipe(Material.COBBLESTONE_STAIRS, "Oheň musí být obestavený schody.")};
        ItemStack[] skotska_whisky_recipe = {createRecipeItem("Wheat", 9, Material.WHEAT), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, null, createBarrel("Oak", 10), createClock(4), createBrewingStand(2)};
        ItemStack[] irska_whisky_recipe = {createRecipeItem("Wheat", 8, Material.WHEAT), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, null, createBarrel("Oak", 3), createClock(4), createBrewingStand(3)};
        ItemStack[] bourbon_recipe = {createRecipeItem("Wheat", 4, Material.WHEAT), createRecipeItem("CORN", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&eCorn", 5), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, createBarrel("Oak", 3), createClock(4), createBrewingStand(2)};
        ItemStack[] psenicne_pivo_recipe = {createRecipeItem("Wheat", 3, Material.WHEAT), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, null, createBarrel("Birch", 2), createClock(8), null};
        ItemStack[] pivo_recipe = {createRecipeItem("Wheat", 6, Material.WHEAT), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, null, createBarrel("Jakýkoliv Sud", 3), createClock(8), null};
        ItemStack[] tmavy_lezak_recipe = {createRecipeItem("Wheat", 12, Material.WHEAT), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, null, createBarrel("Dark Oak", 8), createClock(8), null};
        ItemStack[] cervene_vino_recipe = {createRecipeItem("Sweet Berries", 9, Material.SWEET_BERRIES), null, null, null, null, null, createBarrel("Jakýkoliv Sud", 20), createClock(5), null};
        ItemStack[] bile_vino_recipe = {createRecipeItem("Glow Berries", 9, Material.GLOW_BERRIES), null, null, null, null, null, createBarrel("Jakýkoliv Sud", 20), createClock(5), null};
        ItemStack[] medovina_recipe = {createRecipeItem("Honey Bottle", 4, Material.HONEY_BOTTLE), createRecipeItem("Sugar", 2, Material.SUGAR), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 2), null, null, null, createBarrel("Oak", 4), createClock(3), null};
        ItemStack[] jablecna_medovina_recipe = {createRecipeItem("Honey Bottle", 6, Material.HONEY_BOTTLE), createRecipeItem("Apple", 2, Material.APPLE), createRecipeItem("YEAST", "606be2df2122344bda479feece365ee0e9d5da276afa0e8ce8d848f373dd131", "&eYeast", 1), null, null, null, createBarrel("Oak", 4), createClock(4), null};
        ItemStack[] jablecny_most_recipe = {createRecipeItem("Apple", 14, Material.APPLE), null, null, null, null, null, createBarrel("Jakýkoliv Sud", 3), createClock(7), null};
        ItemStack[] jablecny_liker_recipe = {createRecipeItem("Apple", 12, Material.APPLE), createRecipeItem("Sugar", 3, Material.SUGAR), null, null, null, null, createBarrel("Accacia", 6), createClock(16), createBrewingStand(3)};
        ItemStack[] rum_recipe = {createRecipeItem("CORN", "9bd3802e5fac03afab742b0f3cca41bcd4723bee911d23be29cffd5b965f1", "&eCorn", 18), null, null, null, null, null, createBarrel("Oak", 14), createClock(6), createBrewingStand(2)};
        ItemStack[] vodka_recipe = {createRecipeItem("Potato", 16, Material.POTATO), null, null, null, null, null, null, createClock(15), createBrewingStand(3)};
        ItemStack[] houbova_vodka_recipe = {createRecipeItem("Potato", 14, Material.POTATO), createRecipeItem("Red Mushroom", 3, Material.RED_MUSHROOM), createRecipeItem("Brown Mushroom", 3, Material.BROWN_MUSHROOM), null, null, null, null, createClock(18), createBrewingStand(5)};
        ItemStack[] gin_recipe = {createRecipeItem("Wheat", 9, Material.WHEAT), createRecipeItem("Blue Orchids", 6, Material.BLUE_ORCHID), createRecipeItem("Apple",1, Material.APPLE), null, null, null, null, createClock(6), createBrewingStand(2)};
        ItemStack[] tequila_recipe = {createRecipeItem("Cactus", 8, Material.CACTUS), null, null, null, null, null, createBarrel("Birch", 12), createClock(15), createBrewingStand(2)};
        ItemStack[] absinth_recipe = {createRecipeItem("Short Grass", 15, Material.SHORT_GRASS), null, null, null, null, null, null, createClock(3), createBrewingStand(6)};
        ItemStack[] zeleny_absinth_recipe = {createRecipeItem("Short Grass", 17, Material.SHORT_GRASS), createRecipeItem("Poisonous Potato", 2, Material.POISONOUS_POTATO), null, null, null, null, null, createClock(5), createBrewingStand(6)};
        ItemStack[] bramborova_polevka_recipe = {createRecipeItem("Potato", 5, Material.POTATO), createRecipeItem("Short Grass", 3, Material.SHORT_GRASS), null, null, null, null, null, createClock(3), null};
        ItemStack[] kava_recipe = {createRecipeItem("Cocoa Bean", 12, Material.COCOA_BEANS), createRecipeItem("Milk Bucket", 2, Material.MILK_BUCKET), null, null, null, null, null, createClock(2), null};
        ItemStack[] vajecnak_recipe = {createRecipeItem("Egg", 5, Material.EGG), createRecipeItem("Sugar", 2, Material.SUGAR), createRecipeItem("Milk Bucket", 1, Material.MILK_BUCKET), null, null, null, createBarrel("Jakýkoliv Sud",3), createClock(2), null};

        //recipe type - adds icon of bottle
        RecipeType MENU_BOTTLE = new RecipeType(breweryGroupId, breweryGroupItem);

        //creates items
        SlimefunItem cauldron = new SlimefunItem(breweryGroup, cauldron_stack, RecipeType.MULTIBLOCK, cauldron_recipe);
        SlimefunItem skotska_whisky = new SlimefunItem(breweryGroup, skotska_whisky_stack, MENU_BOTTLE, skotska_whisky_recipe);
        SlimefunItem irska_whisky = new SlimefunItem(breweryGroup, irska_whisky_stack, MENU_BOTTLE, irska_whisky_recipe);
        SlimefunItem bourbon = new SlimefunItem(breweryGroup, bourbon_stack, MENU_BOTTLE, bourbon_recipe);
        SlimefunItem psenicne_pivo = new SlimefunItem(breweryGroup, psenicne_pivo_stack, MENU_BOTTLE, psenicne_pivo_recipe);
        SlimefunItem pivo = new SlimefunItem(breweryGroup, pivo_stack, MENU_BOTTLE, pivo_recipe);
        SlimefunItem tmavy_lezak = new SlimefunItem(breweryGroup, tmavy_lezak_stack, MENU_BOTTLE, tmavy_lezak_recipe);
        SlimefunItem cervene_vino = new SlimefunItem(breweryGroup, cervene_vino_stack, MENU_BOTTLE, cervene_vino_recipe);
        SlimefunItem bile_vino = new SlimefunItem(breweryGroup, bile_vino_stack, MENU_BOTTLE, bile_vino_recipe);
        SlimefunItem medovina = new SlimefunItem(breweryGroup, medovina_stack, MENU_BOTTLE, medovina_recipe);
        SlimefunItem jablecna_medovina = new SlimefunItem(breweryGroup, jablecna_medovina_stack, MENU_BOTTLE, jablecna_medovina_recipe);
        SlimefunItem jablecny_most = new SlimefunItem(breweryGroup, jablecny_most_stack, MENU_BOTTLE, jablecny_most_recipe);
        SlimefunItem jablecny_liker = new SlimefunItem(breweryGroup, jablecny_liker_stack, MENU_BOTTLE, jablecny_liker_recipe);
        SlimefunItem rum = new SlimefunItem(breweryGroup, rum_stack, MENU_BOTTLE, rum_recipe);
        SlimefunItem vodka = new SlimefunItem(breweryGroup, vodka_stack, MENU_BOTTLE, vodka_recipe);
        SlimefunItem houbova_vodka = new SlimefunItem(breweryGroup, houbova_vodka_stack, MENU_BOTTLE, houbova_vodka_recipe);
        SlimefunItem gin = new SlimefunItem(breweryGroup, gin_stack, MENU_BOTTLE, gin_recipe);
        SlimefunItem tequila = new SlimefunItem(breweryGroup, tequila_stack, MENU_BOTTLE, tequila_recipe);
        SlimefunItem absinth = new SlimefunItem(breweryGroup, absinth_stack, MENU_BOTTLE, absinth_recipe);
        SlimefunItem zeleny_absinth = new SlimefunItem(breweryGroup, zeleny_absinth_stack, MENU_BOTTLE, zeleny_absinth_recipe);
        SlimefunItem bramborova_polevka = new SlimefunItem(breweryGroup, bramborova_polevka_stack, MENU_BOTTLE, bramborova_polevka_recipe);
        SlimefunItem kava = new SlimefunItem(breweryGroup, kava_stack, MENU_BOTTLE, kava_recipe);
        SlimefunItem vajecnak = new SlimefunItem(breweryGroup, vajecnak_stack, MENU_BOTTLE, vajecnak_recipe);

        //register items
        // cauldron.register(plugin);
        // skotska_whisky.register(plugin);
        // irska_whisky.register(plugin);
        // bourbon.register(plugin);
        // psenicne_pivo.register(plugin);
        // pivo.register(plugin);
        // tmavy_lezak.register(plugin);
        // cervene_vino.register(plugin);
        // bile_vino.register(plugin);
        // medovina.register(plugin);
        // jablecna_medovina.register(plugin);
        // jablecny_most.register(plugin);
        // jablecny_liker.register(plugin);
        // rum.register(plugin);
        // vodka.register(plugin);
        // houbova_vodka.register(plugin);
        // gin.register(plugin);
        // tequila.register(plugin);
        // absinth.register(plugin);
        // zeleny_absinth.register(plugin);
        // bramborova_polevka.register(plugin);
        // kava.register(plugin);
        // vajecnak.register(plugin);

        // Research for brewery items
        List<SlimefunItem> items = Arrays.asList(skotska_whisky,irska_whisky,bourbon,psenicne_pivo,pivo,tmavy_lezak,cervene_vino,bile_vino,medovina,jablecna_medovina,
                jablecny_most,jablecny_liker,rum,vodka,houbova_vodka,gin,tequila,absinth,zeleny_absinth,bramborova_polevka,kava,vajecnak);
        int researchId = 69001;
        int researchXp = 10;

        for (SlimefunItem i : items){
            NamespacedKey researchKey = new NamespacedKey(plugin, i.getId().toLowerCase() + "_research");
            Research research = new Research(researchKey, researchId++, i.getId().toLowerCase() + " Research", researchXp);
            research.addItems(i);
            research.register();
        }
    }
    private Color createNewColor(int a, int b, int c){
        return Color.fromRGB(a, b, c);
    }

    private void configurePotionMeta(SlimefunItemStack item, Color color) {
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        assert potionMeta != null;
        potionMeta.setColor(color);
        potionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(potionMeta);
    }

    private ItemStack createRecipeItem(String name, int amount, Material material){
        ItemStack item = new CustomItemStack(material, "&e" + name);
        item.setAmount(amount);
        return item;
    }
    private SlimefunItemStack createRecipeItem(String id, String name, String textrue, int amount){
        SlimefunItemStack item = new SlimefunItemStack(id, name, textrue);
        item.setAmount(amount);
        return item;
    }


    private ItemStack createClock(int i) {
        List<String > lore = new ArrayList<>();
        lore.add(i + " minut");
        ItemStack clock = new CustomItemStack(Material.CLOCK, "&aDoba Vaření");
        ItemMeta meta = clock.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        clock.setItemMeta(meta);
        return clock;
    }

    private ItemStack createBrewingStand(int i) {
        List<String> lore = new ArrayList<>();
        lore.add(i + " Krát: ");
        ItemStack brewingStand = new CustomItemStack(Material.BREWING_STAND, "&aPočet Destilace");
        ItemMeta meta = brewingStand.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        brewingStand.setItemMeta(meta);
        return brewingStand;
    }

    private ItemStack createBarrel(String s, int i) {
        List<String> lore = new ArrayList<>();
        lore.add("Sud: " + s);
        lore.add("Čas: " + i + " let");
        ItemStack barrel = new CustomItemStack(Material.BARREL, "&aTyp Sudu");
        ItemMeta meta = barrel.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        barrel.setItemMeta(meta);
        return barrel;
    }
    private ItemStack createMultiblockRecipe(Material material, String lore_input){
        ItemStack item = new CustomItemStack(material);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(lore_input);
        assert meta != null;
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
