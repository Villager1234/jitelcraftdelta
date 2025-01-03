package net.jitle.jitelcraft.item.template;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PickRemnantItem extends PickaxeItem {
    private final Item nextItem;
    public PickRemnantItem(Item nextItem, Tier pTier, int pDamageAM, float pSpeedAM, Properties pProperties) {
        super(pTier, pDamageAM, pSpeedAM, pProperties);
        this.nextItem = nextItem;
    }
    @Override
    public boolean mineBlock(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntity) {
        if (pStack.getDamageValue() >= pStack.getMaxDamage()-1) {
            ItemStack _setstack = new ItemStack(nextItem).copy();
            _setstack.setCount(1);
            _setstack.setTag(pStack.getTag());

            super.mineBlock(pStack, pLevel, pState, pPos, pEntity);

            pEntity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
            /*if (pEntity instanceof Player _player)
                _player.getInventory().setChanged();*/
        } else {
            super.mineBlock(pStack, pLevel, pState, pPos, pEntity);
        }
        return true;
    }
    /*@Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return pState.is(BlockTags.MINEABLE_WITH_PICKAXE) ? this.speed : 1.0F;
    }*/
    public static Tier Tir(Tier initial, int usesMultiplier, float speed, Ingredient repairerItem) {
        return new Tier() {
            @Override public int getUses() {return initial.getUses()*usesMultiplier;}
            @Override public float getSpeed() {return /*initial.getSpeed()* */speed/*(float) Math.ceil(Math.pow(initial.getSpeed(), 1.15f) * 100) /100+0.75f*/;}
            @Override public float getAttackDamageBonus() {return initial.getAttackDamageBonus();}
            @Override public int getLevel() {return initial.getLevel();}
            @Override public int getEnchantmentValue() {return initial.getEnchantmentValue()-4;}
            @Override public @NotNull Ingredient getRepairIngredient() {return repairerItem;}
        };
    }
    public static Tier Tir(Tier initial, int usesMultiplier, float speed, String repairerTag) {
        return Tir(initial, usesMultiplier, speed, Ingredient.of(ItemTags.create(new ResourceLocation(repairerTag))));
    }
}
