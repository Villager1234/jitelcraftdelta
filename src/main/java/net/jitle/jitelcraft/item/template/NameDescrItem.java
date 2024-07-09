package net.jitle.jitelcraft.item.template;

import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NameDescrItem extends Item {
    private final String name;
    private final String descr;
    public NameDescrItem(Properties pProperties, String name, String descr) {
        super(pProperties);
        this.name = name;
        this.descr = descr;
    }
    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable(this.descr));
    }
    @Override
    public @NotNull String getDescriptionId() {
        return this.name;
    }
}