package lmi.lmindustry.CozyLife.HouseholdElectricAppliances.tailEntity;

import lmi.lmindustry.CozyLife.HouseholdElectricAppliances.HouseholdElectricAppliancesGroup;
import lmi.lmindustry.utils.TileEntityTypeRegisterUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IClearable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.HashMap;
import java.util.Map;

public class RadioTileEntity extends TileEntity implements IClearable {

    private CompoundNBT channelList = new CompoundNBT();

    public RadioTileEntity() {
        super(TileEntityType.Builder.create(RadioTileEntity::new, HouseholdElectricAppliancesGroup.RADIO_BLOCK.get()).build(null));
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        if (nbt.contains("channel_list", 10)) {
            this.setChannelList(nbt.getCompound("channel_list"));
        }

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.put("channel_list", getChannelList());
        return compound;
    }

    public CompoundNBT getChannelList(){
        return this.channelList;
    }

    public void setChannelList(CompoundNBT compound){
        this.channelList = compound;
        this.markDirty();
    }

    @Override
    public void clear() {

    }
}
