package net.jitle.jitelcraft.block.mechanism;

import net.jitle.jitelcraft.block.template.Facing4PlayerBlock;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CrusherBlock extends Facing4PlayerBlock {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    private final String tier;
    public CrusherBlock(Properties pProperties, String tier) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVE, Boolean.FALSE).setValue(FACING, Direction.NORTH));
        this.tier=tier;
    }
    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, BlockGetter world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("text.jitelcraft.tier."+this.tier));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(ACTIVE).add(FACING);
    }
}