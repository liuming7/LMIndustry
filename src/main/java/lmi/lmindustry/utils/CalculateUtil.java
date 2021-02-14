package lmi.lmindustry.utils;

import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class CalculateUtil {

    public static double calculateVoxel(int position,double pixel){
        return position/pixel;
    }

    public static VoxelShape calculateVoxelNorth(int west,int east,int north,int south,int bottom,int top,double pixelBit){
        return VoxelShapes.create(CalculateUtil.calculateVoxel(west,pixelBit),//west
                CalculateUtil.calculateVoxel(bottom,pixelBit),//bottom
                CalculateUtil.calculateVoxel(north,pixelBit),//north
                CalculateUtil.calculateVoxel(east,pixelBit),//east
                CalculateUtil.calculateVoxel(top,pixelBit),//top
                CalculateUtil.calculateVoxel(south,pixelBit));//south
    }

    public static VoxelShape calculateVoxelSouth(int west,int east,int north,int south,int bottom,int top,double pixelBit){
        return VoxelShapes.create(CalculateUtil.calculateVoxel(16-east,pixelBit),//west
                CalculateUtil.calculateVoxel(bottom,pixelBit),//bottom
                CalculateUtil.calculateVoxel(16-south,pixelBit),//north
                CalculateUtil.calculateVoxel(16-west,pixelBit),//east
                CalculateUtil.calculateVoxel(top,pixelBit),//top
                CalculateUtil.calculateVoxel(16-north,pixelBit));//south
    }

    public static VoxelShape calculateVoxelEast(int west,int east,int north,int south,int bottom,int top,double pixelBit){
        return VoxelShapes.create(CalculateUtil.calculateVoxel(16-south, pixelBit),//west
                CalculateUtil.calculateVoxel(bottom, pixelBit),//bottom
                CalculateUtil.calculateVoxel(16-west, pixelBit),//north
                CalculateUtil.calculateVoxel(16-north, pixelBit),//east
                CalculateUtil.calculateVoxel(top, pixelBit),//top
                CalculateUtil.calculateVoxel(16-east, pixelBit));//south
    }

    public static VoxelShape calculateVoxelWest(int west,int east,int north,int south,int bottom,int top,double pixelBit){
        return VoxelShapes.create(CalculateUtil.calculateVoxel(south, pixelBit),//west
                CalculateUtil.calculateVoxel(bottom, pixelBit),//bottom
                CalculateUtil.calculateVoxel(east, pixelBit),//north
                CalculateUtil.calculateVoxel(north, pixelBit),//east
                CalculateUtil.calculateVoxel(top, pixelBit),//top
                CalculateUtil.calculateVoxel(west, pixelBit));//south
    }
}
