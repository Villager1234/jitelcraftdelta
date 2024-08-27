package net.jitle.jitelcraft.blockentity;

import net.jitle.jitelcraft.JCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LuxmeterBlockEntity extends BlockEntity {
    public LuxmeterBlockEntity(BlockPos pos, BlockState state) {
        super(JCBlockEntities.LUXMETER_BE.get(), pos, state);
    }
}
