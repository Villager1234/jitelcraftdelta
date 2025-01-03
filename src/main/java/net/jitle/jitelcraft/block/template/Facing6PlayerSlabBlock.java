package net.jitle.jitelcraft.block.template;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class Facing6PlayerSlabBlock extends SlabBlock {
    public static final EnumProperty<Direction> FACING_BOTTOM = DirectionProperty.create("facing_bottom", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);//BlockStateProperties.FACING;
    public static final EnumProperty<Direction> FACING_TOP = DirectionProperty.create("facing_top", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
    //public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    //public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public Facing6PlayerSlabBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING_TOP, Direction.UP).setValue(FACING_BOTTOM, Direction.DOWN).setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        //return this.defaultBlockState().setValue(FACING, context.isSecondaryUseActive() ? context.getNearestLookingDirection() : context.getNearestLookingDirection().getOpposite());
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = pContext.getLevel().getBlockState(blockpos);
        Direction facing = pContext.isSecondaryUseActive() ? pContext.getNearestLookingDirection() : pContext.getNearestLookingDirection().getOpposite();
        if (blockstate.is(this)) {
            return blockstate
                    .setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, Boolean.FALSE)
                    .setValue(blockstate.getValue(TYPE) == SlabType.BOTTOM ? FACING_TOP : FACING_BOTTOM, facing);
        } else {
            FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
            Direction direction = pContext.getClickedFace();
            //return direction != Direction.DOWN && (direction == Direction.UP || !(pContext.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? blockstate1 : blockstate1.setValue(SLAB_TYPE, SlabType.TOP);
            SlabType slabak = direction != Direction.DOWN && (direction == Direction.UP || !(pContext.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? SlabType.BOTTOM : SlabType.TOP;
            return this.defaultBlockState()
                    .setValue(TYPE, slabak)
                    .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                    .setValue(slabak == SlabType.BOTTOM ? FACING_BOTTOM : FACING_TOP, facing);
        }
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING_BOTTOM, FACING_TOP, TYPE, WATERLOGGED);
        //builder.add(FACING_BOTTOM, FACING_TOP);
    }
    @Override
    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        SlabType slabtype = pState.getValue(TYPE);
        return switch (slabtype) {
            case DOUBLE -> Shapes.block();
            case TOP -> Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
            default -> Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
        };
    }
    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING_BOTTOM, rot.rotate(state.getValue(FACING_BOTTOM))).setValue(FACING_TOP, rot.rotate(state.getValue(FACING_TOP)));
    }
    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.setValue(FACING_BOTTOM, mirrorIn.getRotation(state.getValue(FACING_BOTTOM)).rotate(state.getValue(FACING_BOTTOM)))
                .setValue(FACING_TOP, mirrorIn.getRotation(state.getValue(FACING_TOP)).rotate(state.getValue(FACING_TOP)));
                //.rotate(mirrorIn.getRotation(state.getValue(FACING_TOP)));
    }
}