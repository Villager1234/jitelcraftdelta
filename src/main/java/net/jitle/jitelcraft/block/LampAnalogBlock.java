package net.jitle.jitelcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class LampAnalogBlock extends Block {
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public LampAnalogBlock() {
        super(Properties.of()
                .sound(SoundType.GLASS)
                .strength(0.5f)
                .lightLevel((bs) -> bs.getValue(POWER)));
        this.registerDefaultState(this.stateDefinition.any().setValue(POWER, 0));
    }
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(POWER, context.getLevel().getBestNeighborSignal(context.getClickedPos()));
    }
    @Override
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pBlock, @NotNull BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            int flag = pState.getValue(POWER);
            if (flag > pLevel.getBestNeighborSignal(pPos)) {
                pLevel.scheduleTick(pPos, this, 4);
            } else if (flag < pLevel.getBestNeighborSignal(pPos)) {
                    pLevel.setBlock(pPos, pState.setValue(POWER, pLevel.getBestNeighborSignal(pPos)), 2);
            }
        }
    }
    @Override
    public void tick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        if ((pState.getValue(POWER)) != pLevel.getBestNeighborSignal(pPos)) {
            pLevel.setBlock(pPos, pState.setValue(POWER, pLevel.getBestNeighborSignal(pPos)), 2);
        }
    }
}