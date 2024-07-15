package me.figgnus.aeterum.items.research;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import me.figgnus.aeterum.Aeterum;
import org.bukkit.NamespacedKey;

public class ItemResearch {
    private final Aeterum plugin;
    public ItemResearch(Aeterum plugin) {
        this.plugin = plugin;
    }

    // Research key
    public static NamespacedKey createResearchKey(Aeterum plugin, String keyName){
        return new NamespacedKey(plugin, keyName);
    }
    // Research
    public static Research createResearch(NamespacedKey key, int id, String message, int expInLevels){
        return new Research(key, id, message, expInLevels);
    }
}
