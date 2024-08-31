package net.jitle.jitelcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
//import net.minecraft.world.level.block.RedstoneWallTorchBlock;

import javax.annotation.Nullable;

public class RedstoneWallTorchCeilingBlock extends RedstoneTorchCeilingBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public RedstoneWallTorchCeilingBlock(BlockBehaviour.Properties p_55744_) {
        super(p_55744_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.TRUE));
    }
    public @NotNull String getDescriptionId() {
        return this.asItem().getDescriptionId();
    }
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return WallTorchBlock.getShape(pState);
    }
    public boolean canSurvive(@NotNull BlockState pState, @NotNull LevelReader pLevel, BlockPos pPos) {
        return Blocks.WALL_TORCH.canSurvive(pState, pLevel, pPos);
    }
    public @NotNull BlockState updateShape(@NotNull BlockState pState, @NotNull Direction pFacing, @NotNull BlockState pFacingState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pCurrentPos, @NotNull BlockPos pFacingPos) {
        return Blocks.WALL_TORCH.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }
    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        BlockState blockstate = Blocks.WALL_TORCH.getStateForPlacement(pContext);
        return blockstate == null ? null : this.defaultBlockState().setValue(FACING, blockstate.getValue(FACING));
    }
    public void animateTick(@NotNull BlockState pState, Level pLevel, BlockPos pPos, @NotNull RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            Direction direction = pState.getValue(FACING).getOpposite();
            double d1 = (double)pPos.getX() + 0.5D + (pRandom.nextDouble() - 0.5D) * 0.2D + 0.27D * (double)direction.getStepX();
            double d2 = (double)pPos.getY() + 0.3D + (pRandom.nextDouble() - 0.5D) * 0.2D;
            double d3 = (double)pPos.getZ() + 0.5D + (pRandom.nextDouble() - 0.5D) * 0.2D + 0.27D * (double)direction.getStepZ();
            pLevel.addParticle(this.flameParticle, d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }
    protected boolean hasNeighborSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction direction = pState.getValue(FACING).getOpposite();
        return pLevel.hasSignal(pPos.relative(direction), direction);
    }
    public int getSignal(BlockState pBlockState, @NotNull BlockGetter pBlockAccess, @NotNull BlockPos pPos, @NotNull Direction pSide) {
        return pBlockState.getValue(LIT) && pBlockState.getValue(FACING) != pSide ? 15 : 0;
    }
    public @NotNull BlockState rotate(@NotNull BlockState pState, @NotNull Rotation pRotation) {
        return Blocks.WALL_TORCH.rotate(pState, pRotation);
    }
    public @NotNull BlockState mirror(@NotNull BlockState pState, @NotNull Mirror pMirror) {
        return Blocks.WALL_TORCH.mirror(pState, pMirror);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LIT);
    }
}
