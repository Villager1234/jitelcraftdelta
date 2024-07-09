package net.jitle.jitelcraft.block.template;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

public class FacingXyzBlockBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public FacingXyzBlockBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }
    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
        if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
            if (state.getValue(AXIS) == Direction.Axis.X) {
                return state.setValue(AXIS, Direction.Axis.Z);
             } else if (state.getValue(AXIS) == Direction.Axis.Z) {
                return state.setValue(AXIS, Direction.Axis.X);
            }
        }
        return state;
    }
}