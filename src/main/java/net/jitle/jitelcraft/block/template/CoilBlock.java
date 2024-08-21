package net.jitle.jitelcraft.block.template;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

public class CoilBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public CoilBlock(Properties pProperties) {
        super(pProperties.pushReaction(PushReaction.BLOCK));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y).setValue(UP, Boolean.FALSE).setValue(DOWN, Boolean.FALSE));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(AXIS, UP, DOWN);
    }
    @NotNull
    private static BlockPos changeBlockPos(@NotNull BlockPlaceContext context, int var) {
        Direction pFacing = context.getClickedFace();
        int pX = context.getClickedPos().getX();
        int pY = context.getClickedPos().getY();
        int pZ = context.getClickedPos().getZ();
        switch (pFacing) {
            case DOWN -> pY=pY-var;
            case UP -> pY=pY+var;
            case WEST -> pX=pX-var;
            case EAST -> pX=pX+var;
            case NORTH -> pZ=pZ-var;
            case SOUTH -> pZ=pZ+var;
        }
        return new BlockPos(pX, pY, pZ);
    }
    @Override//BLOCK PLACED
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        Boolean pUp = Boolean.FALSE;
        Boolean pDown = Boolean.FALSE;
        if (!pContext.isSecondaryUseActive()) {
            Direction pFacing = pContext.getClickedFace();
            BlockPos neighborPos = changeBlockPos(pContext, -1);
            if (this == pContext.getLevel().getBlockState(neighborPos).getBlock()
                    && pContext.getClickedFace().getAxis() == pContext.getLevel().getBlockState(neighborPos).getValue(AXIS)) {
                if (pFacing == Direction.DOWN || pFacing == Direction.WEST || pFacing == Direction.NORTH) {
                    pUp = Boolean.TRUE;
                } else {
                    pDown = Boolean.TRUE;
                }
            }
            neighborPos = changeBlockPos(pContext, 1);
            if (this == pContext.getLevel().getBlockState(neighborPos).getBlock()
                    && pContext.getClickedFace().getAxis() == pContext.getLevel().getBlockState(neighborPos).getValue(AXIS)) {
                if (pFacing == Direction.DOWN || pFacing == Direction.WEST || pFacing == Direction.NORTH) {
                    pDown = Boolean.TRUE;
                } else {
                    pUp = Boolean.TRUE;
                }
            }
        }
        return this.defaultBlockState().setValue(AXIS, pContext.getClickedFace().getAxis()).setValue(UP, pUp).setValue(DOWN, pDown);
    }
    @Override//NEIGHBOR BROKEN
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pBlock, @NotNull BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            Direction.Axis pAxis = pState.getValue(AXIS);
            if (this != pLevel.getBlockState(pFromPos).getBlock()) {
                int pPosGet = pPos.getY();
                int pFromPosGet = pFromPos.getY();
                if (pAxis == Direction.Axis.X) {
                    pPosGet = pPos.getX();
                    pFromPosGet = pFromPos.getX();
                } else if (pAxis == Direction.Axis.Z) {
                    pPosGet = pPos.getZ();
                    pFromPosGet = pFromPos.getZ();
                }
                if (pPosGet > pFromPosGet && pState.getValue(DOWN)) {
                    pLevel.setBlock(pPos, pState.setValue(DOWN, Boolean.FALSE), 2);
                } else if (pPosGet < pFromPosGet && pState.getValue(UP)) {
                    pLevel.setBlock(pPos, pState.setValue(UP, Boolean.FALSE), 2);
                }
                //NEIGHBOR PLACED
            } else if (pAxis == pLevel.getBlockState(pFromPos).getValue(AXIS)) {
                BlockState pNeighState = pLevel.getBlockState(pFromPos);
                int pPosGet = pPos.getY();
                int pFromPosGet = pFromPos.getY();
                if (pAxis == Direction.Axis.X) {
                    pPosGet = pPos.getX();
                    pFromPosGet = pFromPos.getX();
                } else if (pAxis == Direction.Axis.Z) {
                    pPosGet = pPos.getZ();
                    pFromPosGet = pFromPos.getZ();
                }
                if (pPosGet > pFromPosGet && !pState.getValue(DOWN) && pNeighState.getValue(UP)) {
                    pLevel.setBlock(pPos, pState.setValue(DOWN, Boolean.TRUE), 2);
                } else if (pPosGet < pFromPosGet && !pState.getValue(UP) && pNeighState.getValue(DOWN)) {
                    pLevel.setBlock(pPos, pState.setValue(UP, Boolean.TRUE), 2);
                }
            }
        }
    }
    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        Direction.Axis pAxis = state.getValue(AXIS);
        if (state.getValue(UP) ^ state.getValue(DOWN)) {
            if (rot == Rotation.COUNTERCLOCKWISE_90 && pAxis == Direction.Axis.Z) {
                return state.setValue(AXIS, Direction.Axis.X);
            }
            if (rot == Rotation.CLOCKWISE_90 && pAxis == Direction.Axis.X) {
                return state.setValue(AXIS, Direction.Axis.Z);
            }
            if (rot == Rotation.COUNTERCLOCKWISE_90 && pAxis == Direction.Axis.X) {
                return state.setValue(AXIS, Direction.Axis.Z).cycle(UP).cycle(DOWN);
            }
            if (rot == Rotation.CLOCKWISE_90 && pAxis == Direction.Axis.Z) {
                return state.setValue(AXIS, Direction.Axis.X).cycle(UP).cycle(DOWN);
            }
            if (rot == Rotation.CLOCKWISE_180 && pAxis != Direction.Axis.Y) {
                return state.cycle(UP).cycle(DOWN);
            }
        } else {
            if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
                if (pAxis == Direction.Axis.X) {
                    return state.setValue(AXIS, Direction.Axis.Z);
                } else if (pAxis == Direction.Axis.Z) {
                    return state.setValue(AXIS, Direction.Axis.X);
                }
            }
        }
        return state;
    }
    @Override
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mir) {
        Direction.Axis pAxis = state.getValue(AXIS);
        if ((state.getValue(UP) ^ state.getValue(DOWN)) && (pAxis != Direction.Axis.Y)) {
            if ((mir == Mirror.LEFT_RIGHT && pAxis == Direction.Axis.Z) || (mir == Mirror.FRONT_BACK && pAxis == Direction.Axis.X)) {
                return state.cycle(UP).cycle(DOWN);
            }
        }
        return state;
    }
}