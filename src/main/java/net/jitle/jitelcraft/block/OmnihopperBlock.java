package net.jitle.jitelcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class OmnihopperBlock extends Block {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private static final VoxelShape MIDDLE_X = Block.box(2.0D, 3.0D, 3.0D, 14.0D, 13.0D, 13.0D);
    private static final VoxelShape MIDDLE_Y = Block.box(3.0D, 2.0D, 3.0D, 13.0D, 14.0D, 13.0D);
    private static final VoxelShape MIDDLE_Z = Block.box(3.0D, 3.0D, 2.0D, 13.0D, 13.0D, 14.0D);
    private static final VoxelShape END_X = Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);
    private static final VoxelShape END_Y = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    private static final VoxelShape END_Z = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D);
    public OmnihopperBlock() {
        super(Properties.of()
                .mapColor(MapColor.WOOD)
                .sound(SoundType.WOOD)
                .strength(3.5f)
                .requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.DOWN));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case UP -> Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), MIDDLE_Y, END_Y);
            case DOWN -> Shapes.or(box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D), MIDDLE_Y, END_Y);
            case EAST -> Shapes.or(box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D), MIDDLE_X, END_X);
            case WEST -> Shapes.or(box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), MIDDLE_X, END_X);
            case NORTH -> Shapes.or(box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D), MIDDLE_Z, END_Z);
            case SOUTH -> Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D), MIDDLE_Z, END_Z);
        };
    }
    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }
    //FACING6BLOCK
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getClickedFace().getOpposite());
    }
    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }
}