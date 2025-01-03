package net.jitle.jitelcraft.block.template;

import net.jitle.jitelcraft.FunctionsJ;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
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
    @Override//BLOCK PLACED
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        Boolean pUp = Boolean.FALSE;
        Boolean pDown = Boolean.FALSE;
        if (!pContext.isSecondaryUseActive()) {
            Direction pFacing = pContext.getClickedFace();
            BlockPos neighborPos = FunctionsJ.changeBlockPos(pContext.getClickedPos(), pFacing, -1);
            if (this == pContext.getLevel().getBlockState(neighborPos).getBlock()
                    && pContext.getClickedFace().getAxis() == pContext.getLevel().getBlockState(neighborPos).getValue(AXIS)) {
                if (pFacing == Direction.DOWN || pFacing == Direction.WEST || pFacing == Direction.NORTH) {
                    pUp = Boolean.TRUE;
                } else {
                    pDown = Boolean.TRUE;
                }
            }
            neighborPos = FunctionsJ.changeBlockPos(pContext.getClickedPos(), pFacing, 1);
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
    @Override
    public @NotNull BlockState updateShape(BlockState pState, Direction pFacing, @NotNull BlockState pFacingState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pCurrentPos, @NotNull BlockPos pFacingPos) {
        Direction.Axis pAxis = pState.getValue(AXIS);
        if (pFacing.getAxis() == pAxis) {
            if (this != pFacingState.getBlock()) {
                //NEIGHBOR BROKEN
                if (pFacing == Direction.DOWN || pFacing == Direction.WEST || pFacing == Direction.NORTH) {
                    return pState.getValue(DOWN) ? pState.setValue(DOWN, Boolean.FALSE) : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
                } else {
                    return pState.getValue(UP) ? pState.setValue(UP, Boolean.FALSE) : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
                }
            } else if (pAxis == pFacingState.getValue(AXIS)) {
                //NEIGHBOR PLACED
                if (pFacing == Direction.DOWN || pFacing == Direction.WEST || pFacing == Direction.NORTH) {
                    return !pState.getValue(DOWN) && pFacingState.getValue(UP) ? pState.setValue(DOWN, Boolean.TRUE) : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
                } else {
                    return !pState.getValue(UP) && pFacingState.getValue(DOWN) ? pState.setValue(UP, Boolean.TRUE) : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
                }
            }
        }
        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
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