package net.jitle.jitelcraft.block;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
//import net.minecraft.world.level.block.RedstoneTorchBlock;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class RedstoneTorchCeilingBlock extends TorchCeilingBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private static final Map<BlockGetter, List<RedstoneTorchCeilingBlock.Toggle>> RECENT_TOGGLES = new WeakHashMap<>();
    public static final int RECENT_TOGGLE_TIMER = 60;
    public static final int MAX_RECENT_TOGGLES = 8;
    public static final int RESTART_DELAY = 160;
    private static final int TOGGLE_DELAY = 2;
    public RedstoneTorchCeilingBlock(BlockBehaviour.Properties p_55678_) {
        super(p_55678_, DustParticleOptions.REDSTONE);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.TRUE));
    }
    public void onPlace(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pOldState, boolean pIsMoving) {
        for(Direction direction : Direction.values()) {
            pLevel.updateNeighborsAt(pPos.relative(direction), this);
        }
    }
    public void onRemove(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pNewState, boolean pIsMoving) {
        if (!pIsMoving) {
            for(Direction direction : Direction.values()) {
                pLevel.updateNeighborsAt(pPos.relative(direction), this);
            }
        }
    }
    public int getSignal(BlockState pBlockState, @NotNull BlockGetter pBlockAccess, @NotNull BlockPos pPos, @NotNull Direction pSide) {
        return pBlockState.getValue(LIT) && Direction.DOWN != pSide ? 15 : 0;
    }
    protected boolean hasNeighborSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        return pLevel.hasSignal(pPos.above(), Direction.UP);
    }
    public void tick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        boolean flag = this.hasNeighborSignal(pLevel, pPos, pState);
        List<RedstoneTorchCeilingBlock.Toggle> list = RECENT_TOGGLES.get(pLevel);
        while(list != null && !list.isEmpty() && pLevel.getGameTime() - (list.get(0)).when > 60L) {
            list.remove(0);
        }
        if (pState.getValue(LIT)) {
            if (flag) {
                pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.FALSE), 3);
                if (isToggledTooFrequently(pLevel, pPos, true)) {
                    pLevel.levelEvent(1502, pPos, 0);
                    pLevel.scheduleTick(pPos, pLevel.getBlockState(pPos).getBlock(), 160);
                }
            }
        } else if (!flag && !isToggledTooFrequently(pLevel, pPos, false)) {
            pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.TRUE), 3);
        }
    }
    public void neighborChanged(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Block pBlock, @NotNull BlockPos pFromPos, boolean pIsMoving) {
        if (pState.getValue(LIT) == this.hasNeighborSignal(pLevel, pPos, pState) && !pLevel.getBlockTicks().willTickThisTick(pPos, this)) {
            pLevel.scheduleTick(pPos, this, 2);
        }
    }
    public int getDirectSignal(@NotNull BlockState pBlockState, @NotNull BlockGetter pBlockAccess, @NotNull BlockPos pPos, @NotNull Direction pSide) {
        return pSide == Direction.UP ? pBlockState.getSignal(pBlockAccess, pPos, pSide) : 0;
    }
    public boolean isSignalSource(@NotNull BlockState pState) {
        return true;
    }
    public void animateTick(@NotNull BlockState pState, Level pLevel, BlockPos pPos, @NotNull RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            double d0 = (double)pPos.getX() + 0.5D + (pRandom.nextDouble() - 0.5D) * 0.2D;
            double d1 = (double)pPos.getY() + 0.3D + (pRandom.nextDouble() - 0.5D) * 0.2D;
            double d2 = (double)pPos.getZ() + 0.5D + (pRandom.nextDouble() - 0.5D) * 0.2D;
            pLevel.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }
    private static boolean isToggledTooFrequently(Level pLevel, BlockPos pPos, boolean pLogToggle) {
        List<RedstoneTorchCeilingBlock.Toggle> list = RECENT_TOGGLES.computeIfAbsent(pLevel, (p_55680_) -> Lists.newArrayList());
        if (pLogToggle) {
            list.add(new RedstoneTorchCeilingBlock.Toggle(pPos.immutable(), pLevel.getGameTime()));
        }
        int i = 0;
        for (Toggle redstonetorchblock$toggle : list) {
            if (redstonetorchblock$toggle.pos.equals(pPos)) {
                ++i;
                if (i >= 8) {
                    return true;
                }
            }
        }
        return false;
    }
    public static class Toggle {
        final BlockPos pos;
        final long when;
        public Toggle(BlockPos pPos, long pWhen) {
            this.pos = pPos;
            this.when = pWhen;
        }
    }
}