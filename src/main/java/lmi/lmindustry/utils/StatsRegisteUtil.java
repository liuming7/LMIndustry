package lmi.lmindustry.utils;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class StatsRegisteUtil {

    public static ResourceLocation registerCustom(String key, IStatFormatter formatter) {
        ResourceLocation resourcelocation = new ResourceLocation(key);
        Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
        Stats.CUSTOM.get(resourcelocation, formatter);
        return resourcelocation;
    }
}
