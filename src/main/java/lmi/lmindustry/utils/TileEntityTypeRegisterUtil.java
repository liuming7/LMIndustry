package lmi.lmindustry.utils;

import com.mojang.datafixers.types.Type;
import lmi.lmindustry.LMIndustry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.registry.Registry;

public class TileEntityTypeRegisterUtil {

    public static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
        Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, key);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
    }
}
