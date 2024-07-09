package net.jitle.jitelcraft.item.template;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CraftingRemainingItem extends Item {
    public CraftingRemainingItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        return new ItemStack(this);
    }
}