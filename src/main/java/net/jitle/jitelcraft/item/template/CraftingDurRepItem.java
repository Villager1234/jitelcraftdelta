package net.jitle.jitelcraft.item.template;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CraftingDurRepItem extends Item {
    private final Item newItem;
    public CraftingDurRepItem(Properties pProperties, Item newItem) {
        super(pProperties);
        this.newItem = newItem;
    }
    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemstack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return new ItemStack(this.newItem);
        }
        return retval;
    }
}