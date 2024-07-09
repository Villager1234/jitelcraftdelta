package net.jitle.jitelcraft.item.template;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CraftingReplacingItem extends Item {
    private final Item newItem;
    public CraftingReplacingItem(Properties pProperties, Item newItem) {
        super(pProperties);
        this.newItem = newItem;
    }
    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        return new ItemStack(this.newItem);
    }
}