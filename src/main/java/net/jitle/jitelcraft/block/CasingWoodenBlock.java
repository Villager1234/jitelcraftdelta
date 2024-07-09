package net.jitle.jitelcraft.block;

import net.jitle.jitelcraft.block.template.FacingXyzBlockBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CasingWoodenBlock extends FacingXyzBlockBlock {
    public CasingWoodenBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .sound(SoundType.WOOD)
                .strength(2f, 2f)
                .requiresCorrectToolForDrops());
    }
    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, BlockGetter world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("text.jitelcraft.tier.1"));
    }
}