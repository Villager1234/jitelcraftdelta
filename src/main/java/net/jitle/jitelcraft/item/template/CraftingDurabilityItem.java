package net.jitle.jitelcraft.item.template;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CraftingDurabilityItem extends Item {
    public CraftingDurabilityItem(Properties pProperties) {
        super(pProperties);
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
            return ItemStack.EMPTY;
        }
        return retval;
    }
}