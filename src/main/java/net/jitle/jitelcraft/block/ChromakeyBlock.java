package net.jitle.jitelcraft.block;

import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ChromakeyBlock extends RedstoneLampBlock {
    public ChromakeyBlock(Properties pProperties) {
        super(pProperties
                .sound(SoundType.WOOL)
                .strength(1)
                .lightLevel((bs) -> bs.getValue(BlockStateProperties.LIT) ? 0 : 15)
                .isValidSpawn((bs, bg, bp, et) -> true));
                //.hasPostProcess((bs, bg, bp) -> true)
                //.emissiveRendering((bs, bg, bp) -> true)
    }
}