package lmi.lmindustry.CozyLife.HouseholdElectricAppliances;

import lmi.lmindustry.CozyLife.HouseholdElectricAppliances.block.ElectricOvenBlock;
import lmi.lmindustry.CozyLife.HouseholdElectricAppliances.block.RadioBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class HouseholdElectricAppliancesGroup {

    private static final double PIXEL_BIT = 16D;

    private static DeferredRegister<Block> blocks = null;
    private static DeferredRegister<Item> items = null;

    public static ItemGroup HOUSEHOLD_ELECTRIC_APPLIANCES = null;

    public static RegistryObject<Block> RADIO_BLOCK = null;
    public static RegistryObject<Item> RADIO_ITEM = null;

    public static RegistryObject<Block> ELECTRIC_OVEN_BLOCK = null;
    public static RegistryObject<Item> ELECTRIC_OVEN_ITEM = null;

    private HouseholdElectricAppliancesGroup(DeferredRegister<Block> blocks, DeferredRegister<Item> items){
        this.blocks = blocks;
        this.items = items;
    }

    public static void weave(DeferredRegister<Block> blocks, DeferredRegister<Item> items){
        new HouseholdElectricAppliancesGroup(blocks,items);
        RADIO_BLOCK = blocks.register("radio", () -> new RadioBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1L,3L),2,14,5,11,0,12,PIXEL_BIT));
        RADIO_ITEM = items.register("radio" , () -> new BlockItem(RADIO_BLOCK.get(),new Item.Properties().group(HouseholdElectricAppliancesGroup.HOUSEHOLD_ELECTRIC_APPLIANCES)));
        ELECTRIC_OVEN_BLOCK = blocks.register("electric_oven", () -> new ElectricOvenBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1L,3L),0,16,0,13,0,13,PIXEL_BIT));
        ELECTRIC_OVEN_ITEM = items.register("electric_oven" , () -> new BlockItem(ELECTRIC_OVEN_BLOCK.get(),new Item.Properties().group(HouseholdElectricAppliancesGroup.HOUSEHOLD_ELECTRIC_APPLIANCES)));
        HOUSEHOLD_ELECTRIC_APPLIANCES = new ItemGroup("lmindustry.household_electric_appliances") {
            @Override
            public ItemStack createIcon() {
                return new ItemStack(RADIO_ITEM.get());
            }
        };
    }
}
