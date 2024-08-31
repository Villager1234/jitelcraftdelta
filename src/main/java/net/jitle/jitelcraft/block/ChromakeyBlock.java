package net.jitle.jitelcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

public class ChromakeyBlock extends RedstoneLampBlock {
    public ChromakeyBlock(Properties pProperties) {
        super(pProperties
                .sound(SoundType.WOOL)
                .strength(1)
                .lightLevel((bs) -> bs.getValue(BlockStateProperties.LIT) ? 0 : 15)
                .isValidSpawn((bs, bg, bp, et) -> false));
    }
    public float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 1.0F;
    }
    /*@Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Block.box(0, 0, 0, 16, 16, 15);
    }*/
}