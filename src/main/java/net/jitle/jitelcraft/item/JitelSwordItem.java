package net.jitle.jitelcraft.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class JitelSwordItem extends SwordItem {
    public JitelSwordItem() {
        super(new Tier() {
            @Override public int getUses() {return 1125;}
            @Override public float getSpeed() {return 6;}
            @Override public float getAttackDamageBonus() {return 2;}
            @Override public int getLevel() {return 2;}
            @Override public int getEnchantmentValue() {return 12;}
            @Override public @NotNull Ingredient getRepairIngredient() {return Ingredient.of(ItemTags.create(new ResourceLocation("forge:gems/jitel")));}
        }, 4, -3.2f, new Item.Properties());
    }
}