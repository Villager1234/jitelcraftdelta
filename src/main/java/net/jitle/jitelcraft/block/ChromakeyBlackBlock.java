package net.jitle.jitelcraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class ChromakeyBlackBlock extends Block {
    public ChromakeyBlackBlock() {
        super(Properties.of()
                .mapColor(MapColor.COLOR_BLACK)
                .sound(SoundType.WOOL)
                .strength(1)
                .isValidSpawn((bs, bg, bp, et) -> false));
    }
    public float getShadeBrightness(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 1.0F;
    }
}