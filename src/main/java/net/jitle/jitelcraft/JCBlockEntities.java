package net.jitle.jitelcraft;

import net.jitle.jitelcraft.blockentity.LuxmeterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JitelcraftMod.MODID);

    public static final RegistryObject<BlockEntityType<LuxmeterBlockEntity>> LUXMETER_BE = BLOCK_ENTITIES.register("luxmeter_be",
            () -> BlockEntityType.Builder.of(LuxmeterBlockEntity::new, JCBlocks.LUXMETER.get()).build(null));
}
