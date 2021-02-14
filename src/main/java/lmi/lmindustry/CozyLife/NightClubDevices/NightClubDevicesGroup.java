package lmi.lmindustry.CozyLife.NightClubDevices;

import lmi.lmindustry.CozyLife.NightClubDevices.block.MixerBlock;
import lmi.lmindustry.CozyLife.NightClubDevices.block.VinylTurntableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class NightClubDevicesGroup {

    private static final double PIXEL_BIT = 16D;

    private static DeferredRegister<Block> blocks = null;
    private static DeferredRegister<Item> items = null;

    public static ItemGroup NIGHT_CLUB_DEVICES = null;

    public static RegistryObject<Block> VINYL_TURNTABLE_BLOCK = null;
    public static RegistryObject<Item> VINYL_TURNTABLE_ITEM = null;

    public static RegistryObject<Block> MIXER_BLOCK = null;
    public static RegistryObject<Item> MIXER_ITEM = null;

    private NightClubDevicesGroup(DeferredRegister<Block> blocks, DeferredRegister<Item> items){
        this.blocks = blocks;
        this.items = items;
    }

    public static void weave(DeferredRegister<Block> blocks, DeferredRegister<Item> items){
        new NightClubDevicesGroup(blocks,items);
        VINYL_TURNTABLE_BLOCK = blocks.register("vinyl_turntable", () -> new VinylTurntableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1L,3L),1,15,1,15,0,6,PIXEL_BIT));
        VINYL_TURNTABLE_ITEM = items.register("vinyl_turntable" , () -> new BlockItem(VINYL_TURNTABLE_BLOCK.get(),new Item.Properties().group(NightClubDevicesGroup.NIGHT_CLUB_DEVICES)));
        MIXER_BLOCK = blocks.register("mixer", () -> new MixerBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1L,3L),1,15,1,15,0,4,PIXEL_BIT));
        MIXER_ITEM = items.register("mixer" , () -> new BlockItem(MIXER_BLOCK.get(),new Item.Properties().group(NightClubDevicesGroup.NIGHT_CLUB_DEVICES)));
        NIGHT_CLUB_DEVICES = new ItemGroup("lmindustry.night_club_devices") {
            @Override
            public ItemStack createIcon() {
                return new ItemStack(VINYL_TURNTABLE_ITEM.get());
            }
        };
    }
}
