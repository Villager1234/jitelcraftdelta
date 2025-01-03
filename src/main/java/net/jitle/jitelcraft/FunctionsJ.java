package net.jitle.jitelcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class FunctionsJ {
    public static BlockPos changeBlockPos(BlockPos pPos, Direction pFacing, int var) {
        int pX = pPos.getX();
        int pY = pPos.getY();
        int pZ = pPos.getZ();
        switch (pFacing) {
            case DOWN -> pY=pY-var;
            case UP -> pY=pY+var;
            case WEST -> pX=pX-var;
            case EAST -> pX=pX+var;
            case NORTH -> pZ=pZ-var;
            case SOUTH -> pZ=pZ+var;
        }
        return new BlockPos(pX, pY, pZ);
    }/*
    public static BlockPos changeBlockPos(BlockPlaceContext context, int var) {
        return changeBlockPos(context.getClickedPos(), context.getClickedFace(), var);
    }*/
}
