package net.jitle.jitelcraft.block;

import net.jitle.jitelcraft.JitelBlockEntities;
import net.jitle.jitelcraft.block.template.Facing6PlayerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LuxmeterBlock extends Facing6PlayerBlock implements EntityBlock {
    public static final IntegerProperty MODE = IntegerProperty.create("mode", 1, 3);
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public LuxmeterBlock() {
        super(Properties.of()
                .mapColor(MapColor.STONE)
                .strength(4)
                .requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(MODE, 1).setValue(POWER, 0).setValue(FACING, Direction.NORTH));
    }
    @NotNull
    private static BlockPos changeBlockPos(BlockPos pPos, Direction pFacing) {
        int pX = pPos.getX();
        int pY = pPos.getY();
        int pZ = pPos.getZ();
        switch (pFacing) {
            case DOWN -> pY=pY-1;
            case UP -> pY=pY+1;
            case WEST -> pX=pX-1;
            case EAST -> pX=pX+1;
            case NORTH -> pZ=pZ-1;
            case SOUTH -> pZ=pZ+1;
        }
        return new BlockPos(pX, pY, pZ);
    }
    //1-COMMON 2-SKY 3-BLOCK
    private static void updateSignalStrength(BlockState pState, Level pLevel, BlockPos pPos, Boolean pTimeCheck) {
        if (!pTimeCheck || (pLevel.getGameTime() % 20L) == 0L) {
            BlockPos pLightPos = changeBlockPos(pPos, pState.getValue(FACING));
            int pLight = 0;
            switch (pState.getValue(MODE)) {
                case 1 -> pLight = pLevel.getRawBrightness(pLightPos, 0);
                case 2 -> pLight = pLevel.getBrightness(LightLayer.SKY, pLightPos);
                case 3 -> pLight = pLevel.getBrightness(LightLayer.BLOCK, pLightPos);
            }
            if (pState.getValue(POWER)!=pLight) {
                pLevel.setBlock(pPos, pState.setValue(POWER, pLight), 3);
            }
        }
        //pLevel.scheduleTick(pPos, pState.getBlock(), 4);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        if (pPlayer.mayBuild()) {
            if (pLevel.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                pLevel.setBlock(pPos, pState.cycle(MODE), 3);
                //pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, pState.cycle(MODE)));
                //pLevel.scheduleTick(pPos, pState.getBlock(), 4);
                updateSignalStrength(pState.cycle(MODE), pLevel, pPos, false);
                return InteractionResult.CONSUME;
            }
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }
    /*@Override
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pBlock, @NotNull BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            pLevel.scheduleTick(pPos, pState.getBlock(), 4);
            updateSignalStrength(pState, pLevel, pPos);
        }
    }*/
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return JitelBlockEntities.LUXMETER_BE.get().create(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        //return level.isClientSide /*&& (level.getGameTime() % 40L == 0L)*/ ? null : ();
        return !level.isClientSide ? (level0, pos0, state0, blockEntity) -> updateSignalStrength(state0, level0, pos0, true) : null;
    }
    public int getSignal(@NotNull BlockState pState, @NotNull BlockGetter pBlockAccess, @NotNull BlockPos pPos, @NotNull Direction pSide) {
        return pState.getValue(POWER);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(MODE).add(POWER).add(FACING);
    }
}