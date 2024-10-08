package net.jitle.jitelcraft.block.template;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

public class Facing6PlayerBlock extends Block {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private final Boolean sneaking;
    public Facing6PlayerBlock(Properties pProperties, Boolean sneaking) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        this.sneaking = sneaking;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, sneaking && context.isSecondaryUseActive() ? context.getNearestLookingDirection() : context.getNearestLookingDirection().getOpposite());
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