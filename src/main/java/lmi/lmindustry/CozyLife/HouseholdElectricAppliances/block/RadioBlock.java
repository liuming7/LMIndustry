package lmi.lmindustry.CozyLife.HouseholdElectricAppliances.block;

import lmi.lmindustry.CozyLife.HouseholdElectricAppliances.tailEntity.RadioTileEntity;
import lmi.lmindustry.utils.CalculateUtil;
import lmi.lmindustry.utils.StatsRegisteUtil;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.IStatFormatter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class RadioBlock extends Block implements ITileEntityProvider{

    private double pixelBit;
    private int west;
    private int east;
    private int north;
    private int south;
    private int bottom;
    private int top;

    private static final DirectionProperty FACING = HorizontalFaceBlock.HORIZONTAL_FACING;
    public RadioBlock(Properties properties,int west,int east,int north,int south,int bottom,int top,double pixelBit) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
        this.west = west;this.east = east;this.north = north;this.south = south;this.bottom = bottom;this.top = top;this.pixelBit = pixelBit;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction dir = state.get(FACING);
        if(dir.getString().equals("north")||dir.getString().equals("south")){
            return CalculateUtil.calculateVoxelNorth(west,east,north,south,bottom,top,pixelBit);
        }else if(dir.getString().equals("west")||dir.getString().equals("east")){
            return CalculateUtil.calculateVoxelWest(west,east,north,south,bottom,top,pixelBit);
        }else{
            return null;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack){

    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit){
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            this.interactWith(worldIn, pos, player);
            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player){

    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player){
        super.onBlockHarvested(worldIn,pos,state,player);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn){

    }

    @Override
    public boolean hasTileEntity(BlockState state){
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new RadioTileEntity();
    }

    /**
     * Interface for handling interaction with blocks that impliment AbstractFurnaceBlock. Called in onBlockActivated
     * inside AbstractFurnaceBlock.
     */
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof RadioTileEntity) {
            player.openContainer((INamedContainerProvider)tileentity);
            player.addStat(StatsRegisteUtil.registerCustom("interact_with_radio", IStatFormatter.DEFAULT));
        }
    }
}
