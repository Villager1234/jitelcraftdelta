package net.jitle.jitelcraft.item.template;

import net.jitle.jitelcraft.FunctionsJ;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PickRemnantStripMinerItem extends PickaxeItem {
    private final Item nextItem;
    private final Tier pTier;
    public PickRemnantStripMinerItem(Item nextItem, Tier pTier, int pDamageAM, float pSpeedAM, Properties pProperties) {
        super(pTier, pDamageAM, pSpeedAM, pProperties);
        this.nextItem = nextItem;
        this.pTier = pTier;
    }
    @Override
    public boolean mineBlock(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntity) {
        stripMine(pStack, pLevel, pState, pPos, pEntity);
        return true;
    }
    private void stripMine(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntity) {
        if (damageDowngradePick(pStack, pLevel, pState, pPos, pEntity)
                && pEntity instanceof Player pleer/*pEntity.getType() == EntityType.PLAYER*/ && !pleer.isSecondaryUseActive()) {
            boolean tru = true;
            int counterTitan/*dom studio*/ = pTier.getLevel();
            int counter = 0;
            Direction entityDir = pEntity.getXRot() > 45 ? Direction.DOWN : pEntity.getXRot() < -45 ? Direction.UP : pEntity.getDirection();
            while (tru && counterTitan > counter) {
                BlockPos nextBP = FunctionsJ.changeBlockPos(pPos, entityDir, counter+1);
                BlockState nextBS = pLevel.getBlockState(nextBP);
                if (pState.getBlock().defaultDestroyTime() >= nextBS.getBlock().defaultDestroyTime() - 1.5
                        && nextBS.getBlock().canHarvestBlock(nextBS, pLevel, nextBP, pleer) && nextBS.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
                    if (!pLevel.destroyBlock(nextBP, false, pEntity)) {
                        tru=false;
                    } else {
                        //nextBS.getBlock().playerDestroy(pLevel, pleer, nextBP, nextBS, null, pStack);
                        Block.dropResources(nextBS, pLevel, nextBP, null, pleer, pStack);
                        /*if (counter % 2 == 0) {
                            damageDowngradePick(pStack, pLevel, nextBS, nextBP, pEntity);
                        }*/
                        damageDowngradePick(pStack, pLevel, nextBS, nextBP, pEntity);
                        tru = damageDowngradePick(pStack, pLevel, nextBS, nextBP, pEntity);
                        counter += 1;
                    }
                } else {
                    tru = false;
                }
            }
        }
    }
    private boolean damageDowngradePick(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntity) {
        if (pStack.getDamageValue() >= pStack.getMaxDamage()-1) {
            ItemStack _setstack = new ItemStack(nextItem);
            _setstack.setCount(1);
            _setstack.setTag(pStack.getTag());

            super.mineBlock(pStack, pLevel, pState, pPos, pEntity);

            pEntity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
            /*if (pEntity instanceof Player _player)
                _player.getInventory().setChanged();*/
            return false;
        } else {
            super.mineBlock(pStack, pLevel, pState, pPos, pEntity);
            return true;
        }
    }
}
