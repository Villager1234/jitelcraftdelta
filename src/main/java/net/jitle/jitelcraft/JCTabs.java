package net.jitle.jitelcraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JCTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JitelcraftMod.MODID);
    public static final RegistryObject<CreativeModeTab> JITELCRAFT_TAB = TABS.register("jitelcraft_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(JCItems.JITEL_GEM.get()))
            .title(Component.translatable("itemGroup.jitelcraft.main"))
            .displayItems((pParameters, pOutput) -> {
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ MOD MATERIALS
                pOutput.accept(JCBlocks.JITEL_ORE.get());
                pOutput.accept(JCBlocks.JITEL_ORE_DEEPSLATE.get());
                pOutput.accept(JCItems.JITEL_GEM.get());
                pOutput.accept(JCItems.JITEL_NUGGET.get());
                pOutput.accept(JCBlocks.JITEL_BLOCK.get());
                pOutput.accept(JCItems.JITEL_DUST.get());
                pOutput.accept(JCBlocks.ZINC_ORE.get());
                pOutput.accept(JCBlocks.ZINC_ORE_DEEPSLATE.get());
                pOutput.accept(JCItems.ZINC_RAW.get());
                pOutput.accept(JCBlocks.ZINC_RAW_BLOCK.get());
                pOutput.accept(JCItems.ZINC_INGOT.get());
                pOutput.accept(JCItems.ZINC_NUGGET.get());
                pOutput.accept(JCBlocks.ZINC_BLOCK.get());
                pOutput.accept(JCItems.ZINC_ROD.get());
                pOutput.accept(JCItems.ZINC_PLATE.get());
                pOutput.accept(JCItems.ZINC_GEAR.get());
                pOutput.accept(JCItems.ZINC_DUST.get());
                pOutput.accept(JCBlocks.ALUMINUM_ORE.get());
                pOutput.accept(JCBlocks.ALUMINUM_ORE_DEEPSLATE.get());
                pOutput.accept(JCItems.ALUMINUM_RAW.get());
                pOutput.accept(JCBlocks.ALUMINUM_RAW_BLOCK.get());
                pOutput.accept(JCItems.ALUMINUM_INGOT.get());
                pOutput.accept(JCItems.ALUMINUM_NUGGET.get());
                pOutput.accept(JCBlocks.ALUMINUM_BLOCK.get());
                pOutput.accept(JCItems.ALUMINUM_ROD.get());
                pOutput.accept(JCItems.ALUMINUM_PLATE.get());
                pOutput.accept(JCItems.ALUMINUM_GEAR.get());
                pOutput.accept(JCItems.ALUMINUM_DUST.get());
                pOutput.accept(JCItems.ALUMINUM_WIRE.get());
                pOutput.accept(JCItems.STEEL_COMPONENTS.get());
                pOutput.accept(JCItems.STEEL_INGOT.get());
                pOutput.accept(JCItems.STEEL_NUGGET.get());
                pOutput.accept(JCBlocks.STEEL_BLOCK.get());
                pOutput.accept(JCItems.STEEL_ROD.get());
                pOutput.accept(JCItems.STEEL_PLATE.get());
                pOutput.accept(JCItems.STEEL_GEAR.get());
                pOutput.accept(JCItems.STEEL_DUST.get());
                pOutput.accept(JCItems.BRASS_COMPONENTS.get());
                pOutput.accept(JCItems.BRASS_INGOT.get());
                pOutput.accept(JCItems.BRASS_NUGGET.get());
                pOutput.accept(JCBlocks.BRASS_BLOCK.get());
                pOutput.accept(JCItems.BRASS_ROD.get());
                pOutput.accept(JCItems.BRASS_PLATE.get());
                pOutput.accept(JCItems.BRASS_GEAR.get());
                pOutput.accept(JCItems.BRASS_DUST.get());
                pOutput.accept(JCBlocks.OPAL_ORE.get());
                pOutput.accept(JCBlocks.OPAL_ORE_DEEPSLATE.get());
                pOutput.accept(JCItems.OPAL_GEM.get());
                pOutput.accept(JCItems.OPAL_NUGGET.get());
                pOutput.accept(JCBlocks.OPAL_BLOCK.get());
                pOutput.accept(JCItems.OPAL_ROD.get());
                pOutput.accept(JCItems.OPAL_PLATE.get());
                pOutput.accept(JCItems.OPAL_GEAR.get());
                pOutput.accept(JCItems.OPAL_DUST.get());
                pOutput.accept(JCBlocks.HALITE.get());
                pOutput.accept(JCItems.SALT.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ VANILLA MATERIALS
                pOutput.accept(JCItems.WOODEN_GEAR.get());
                pOutput.accept(JCItems.STONE_ROD.get());
                pOutput.accept(JCItems.COAL_PLATE.get());
                pOutput.accept(JCItems.COAL_DUST.get());
                pOutput.accept(JCItems.COPPER_NUGGET.get());
                pOutput.accept(JCItems.COPPER_ROD.get());
                pOutput.accept(JCItems.COPPER_PLATE.get());
                pOutput.accept(JCItems.COPPER_GEAR.get());
                pOutput.accept(JCItems.COPPER_DUST.get());
                pOutput.accept(JCItems.COPPER_WIRE.get());
                pOutput.accept(JCItems.IRON_ROD.get());
                pOutput.accept(JCItems.IRON_PLATE.get());
                pOutput.accept(JCItems.IRON_GEAR.get());
                pOutput.accept(JCItems.IRON_DUST.get());
                pOutput.accept(JCItems.GOLD_ROD.get());
                pOutput.accept(JCItems.GOLD_PLATE.get());
                pOutput.accept(JCItems.GOLD_GEAR.get());
                pOutput.accept(JCItems.GOLD_DUST.get());
                pOutput.accept(JCItems.DIAMOND_NUGGET.get());
                pOutput.accept(JCItems.DIAMOND_ROD.get());
                pOutput.accept(JCItems.DIAMOND_PLATE.get());
                pOutput.accept(JCItems.DIAMOND_GEAR.get());
                pOutput.accept(JCItems.DIAMOND_DUST.get());
                pOutput.accept(JCItems.EMERALD_NUGGET.get());
                pOutput.accept(JCItems.EMERALD_ROD.get());
                pOutput.accept(JCItems.EMERALD_PLATE.get());
                pOutput.accept(JCItems.EMERALD_GEAR.get());
                pOutput.accept(JCItems.EMERALD_DUST.get());
                pOutput.accept(JCItems.NETHERITE_NUGGET.get());
                pOutput.accept(JCItems.NETHERITE_ROD.get());
                pOutput.accept(JCItems.NETHERITE_PLATE.get());
                pOutput.accept(JCItems.NETHERITE_GEAR.get());
                pOutput.accept(JCItems.NETHERITE_DUST.get());
                pOutput.accept(JCItems.LAPIS_NUGGET.get());
                pOutput.accept(JCItems.LAPIS_ROD.get());
                pOutput.accept(JCItems.LAPIS_PLATE.get());
                pOutput.accept(JCItems.LAPIS_GEAR.get());
                pOutput.accept(JCItems.LAPIS_DUST.get());
                pOutput.accept(JCItems.QUARTZ_NUGGET.get());
                pOutput.accept(JCItems.QUARTZ_ROD.get());
                pOutput.accept(JCItems.QUARTZ_PLATE.get());
                pOutput.accept(JCItems.QUARTZ_GEAR.get());
                pOutput.accept(JCItems.QUARTZ_DUST.get());
                pOutput.accept(JCItems.AMETHYST_NUGGET.get());
                pOutput.accept(JCItems.AMETHYST_ROD.get());
                pOutput.accept(JCItems.AMETHYST_PLATE.get());
                pOutput.accept(JCItems.AMETHYST_GEAR.get());
                pOutput.accept(JCItems.AMETHYST_DUST.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TIER 1
                pOutput.accept(JCItems.MOTOR_TIER1.get());
                pOutput.accept(JCItems.CONTROLLER_TIER1.get());
                pOutput.accept(JCItems.MOTOR_TIER1_DOWN.get());
                pOutput.accept(JCItems.CONTROLLER_TIER1_DOWN.get());
                pOutput.accept(JCBlocks.CASING_WOODEN.get());
                //pOutput.accept(JCBlocks.CRUSHER_TIER1.get()); @@@@@@@@@@@ WIP
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TIER 2
                pOutput.accept(JCItems.MOTOR_TIER2.get());
                pOutput.accept(JCItems.CONTROLLER_TIER2.get());
                pOutput.accept(JCItems.MOTOR_TIER2_DOWN.get());
                pOutput.accept(JCItems.CONTROLLER_TIER2_DOWN.get());
                pOutput.accept(JCBlocks.CASING_STONE.get());
                //pOutput.accept(JCBlocks.CRUSHER_TIER2.get()); @@@@@@@@@@@ WIP
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CRAFT PARTS
                pOutput.accept(JCItems.CRUSHER_PART.get());
                pOutput.accept(JCItems.COIL.get());
                pOutput.accept(JCItems.COIL_COPPER.get());
                pOutput.accept(JCItems.COIL_ALUMINUM.get());
                pOutput.accept(JCItems.HAMMER.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TOOLS WEAPONS ARMORS
                pOutput.accept(JCItems.DIAMONDQ_SWORD.get());
                pOutput.accept(JCItems.DIAMONDQ_PICKAXE.get());
                pOutput.accept(JCItems.DIAMONDQ_AXE.get());
                pOutput.accept(JCItems.DIAMONDQ_SHOVEL.get());
                pOutput.accept(JCItems.DIAMONDQ_HOE.get());
                //pOutput.accept(JCItems.JITEL_SWORD.get()); @@@@@@@@@@@ WIP
                pOutput.accept(JCItems.PICKAXE_ALPHA_5.get());
                /*pOutput.accept(JCItems.PICKAXE_ALPHA_4.get());
                pOutput.accept(JCItems.PICKAXE_ALPHA_3.get());
                pOutput.accept(JCItems.PICKAXE_ALPHA_2.get());
                pOutput.accept(JCItems.PICKAXE_ALPHA_1.get());*/
                pOutput.accept(JCItems.PICKAXE_OMEGA_5.get());
                /*pOutput.accept(JCItems.PICKAXE_OMEGA_4.get());
                pOutput.accept(JCItems.PICKAXE_OMEGA_3.get());
                pOutput.accept(JCItems.PICKAXE_OMEGA_2.get());
                pOutput.accept(JCItems.PICKAXE_OMEGA_1.get());
                pOutput.accept(JCItems.PICKAXE_OMEGA_0.get());*/
                pOutput.accept(JCItems.PLATE_HELMET.get());
                pOutput.accept(JCItems.PLATE_CHESTPLATE.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ USEFUL BLOCKS
                pOutput.accept(JCBlocks.IRON_DOOR_WL.get());
                pOutput.accept(JCBlocks.IRON_TRAPDOOR_WL.get());
                pOutput.accept(JCItems.REDSTONE_TORCH_CEILING.get());
                //pOutput.accept(JCBlocks.OMNIHOPPER.get()); @@@@@@@@@@@ WIP
                pOutput.accept(JCBlocks.LUXMETER.get());
                pOutput.accept(JCBlocks.LAMP_ANALOG.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ BUILDING BLOCKS
                pOutput.accept(JCBlocks.COILBLOCK_COPPER.get());
                pOutput.accept(JCBlocks.COILBLOCK_ALUMINUM.get());
                pOutput.accept(JCBlocks.POINTER_BLOCK.get());
                pOutput.accept(JCBlocks.POINTER_PILLAR.get());
                pOutput.accept(JCBlocks.POINTER_SLAB.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_BLOCK.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_STAIRS.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_SLAB.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_WALL.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_BRICKS.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_BRICKS_STAIRS.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_BRICKS_SLAB.get());
                pOutput.accept(JCBlocks.NO_TEXTURE_BRICKS_WALL.get());
                pOutput.accept(JCBlocks.CHROMAKEY_WHITE.get());
                pOutput.accept(JCBlocks.CHROMAKEY_LIGHT_GRAY.get());
                pOutput.accept(JCBlocks.CHROMAKEY_GRAY.get());
                pOutput.accept(JCBlocks.CHROMAKEY_BLACK.get());
                pOutput.accept(JCBlocks.CHROMAKEY_BROWN.get());
                pOutput.accept(JCBlocks.CHROMAKEY_RED.get());
                pOutput.accept(JCBlocks.CHROMAKEY_ORANGE.get());
                pOutput.accept(JCBlocks.CHROMAKEY_YELLOW.get());
                pOutput.accept(JCBlocks.CHROMAKEY_LIME.get());
                pOutput.accept(JCBlocks.CHROMAKEY_GREEN.get());
                pOutput.accept(JCBlocks.CHROMAKEY_CYAN.get());
                pOutput.accept(JCBlocks.CHROMAKEY_LIGHT_BLUE.get());
                pOutput.accept(JCBlocks.CHROMAKEY_BLUE.get());
                pOutput.accept(JCBlocks.CHROMAKEY_PURPLE.get());
                pOutput.accept(JCBlocks.CHROMAKEY_MAGENTA.get());
                pOutput.accept(JCBlocks.CHROMAKEY_PINK.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ FLASKS
                pOutput.accept(JCItems.FLASK_DYE_WHITE.get());
                pOutput.accept(JCItems.FLASK_DYE_LIGHT_GRAY.get());
                pOutput.accept(JCItems.FLASK_DYE_GRAY.get());
                pOutput.accept(JCItems.FLASK_DYE_BLACK.get());
                pOutput.accept(JCItems.FLASK_DYE_BROWN.get());
                pOutput.accept(JCItems.FLASK_DYE_RED.get());
                pOutput.accept(JCItems.FLASK_DYE_ORANGE.get());
                pOutput.accept(JCItems.FLASK_DYE_YELLOW.get());
                pOutput.accept(JCItems.FLASK_DYE_LIME.get());
                pOutput.accept(JCItems.FLASK_DYE_GREEN.get());
                pOutput.accept(JCItems.FLASK_DYE_CYAN.get());
                pOutput.accept(JCItems.FLASK_DYE_LIGHT_BLUE.get());
                pOutput.accept(JCItems.FLASK_DYE_BLUE.get());
                pOutput.accept(JCItems.FLASK_DYE_PURPLE.get());
                pOutput.accept(JCItems.FLASK_DYE_MAGENTA.get());
                pOutput.accept(JCItems.FLASK_DYE_PINK.get());
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ WIP CONTENT
                pOutput.accept(JCItems.JITEL_SWORD.get());
                pOutput.accept(JCBlocks.OMNIHOPPER.get());
                pOutput.accept(JCBlocks.CRUSHER_TIER1.get());
                pOutput.accept(JCBlocks.CRUSHER_TIER2.get());
            })
            .build()
    );
}