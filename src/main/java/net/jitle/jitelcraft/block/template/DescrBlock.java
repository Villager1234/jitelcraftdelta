package net.jitle.jitelcraft.block.template;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DescrBlock extends Block {
    private final String descr;
    public DescrBlock(Properties pProperties, String descr) {
        super(pProperties);
        this.descr = descr;
    }
    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, BlockGetter world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable(this.descr));
    }
}