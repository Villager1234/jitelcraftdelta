package net.jitle.jitelcraft;

import net.jitle.jitelcraft.block.*;
import net.jitle.jitelcraft.block.mechanism.*;
import net.jitle.jitelcraft.block.template.*;
import net.jitle.jitelcraft.block.LuxmeterBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class JitelBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JitelcraftMod.MODID);
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SIMPLE ITEMS
    //public static final RegistryObject<Block> TEST = BLOCKS.register("test", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK)));
    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.ICE)
            .sound(SoundType.METAL)
            .strength(6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_ORE = registerBlock("aluminum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(3)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_ORE_DEEPSLATE = registerBlock("aluminum_ore_deepslate", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DEEPSLATE)
            .sound(SoundType.DEEPSLATE)
            .strength(4.5f, 3)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_RAW_BLOCK = registerBlock("aluminum_raw_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT)
            .strength(5, 6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BRASS_BLOCK = registerBlock("brass_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .sound(SoundType.METAL)
            .strength(5, 6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CASING_STONE = registerBlock("casing_stone", () -> new DescrBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(3.5f)
            .requiresCorrectToolForDrops(),
            "text.jitelcraft.tier.2"));
    public static final RegistryObject<Block> COILBLOCK_ALUMINUM = registerBlock("coilblock_aluminum", () -> new CoilBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.ICE)
            .sound(SoundType.METAL)
            .strength(4)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COILBLOCK_COPPER = registerBlock("coilblock_copper", () -> new CoilBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .sound(SoundType.METAL)
            .strength(4)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRUSHER_TIER1 = registerBlock("crusher_tier1", () -> new CrusherBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .sound(SoundType.WOOD)
            .strength(3)
            .requiresCorrectToolForDrops(), "1"));
    public static final RegistryObject<Block> CRUSHER_TIER2 = registerBlock("crusher_tier2", () -> new CrusherBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(4)
            .requiresCorrectToolForDrops(), "2"));
    public static final RegistryObject<Block> HALITE = registerBlock("halite", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.QUARTZ)
            .sound(SoundType.STONE)
            .strength(1.5f, 6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> JITEL_BLOCK = registerBlock("jitel_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_WHITE)
            .sound(SoundType.STONE)
            .strength(4)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> JITEL_ORE = registerBlock("jitel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(3)
            .requiresCorrectToolForDrops(),
            UniformInt.of(2,4)));
    public static final RegistryObject<Block> JITEL_ORE_DEEPSLATE = registerBlock("jitel_ore_deepslate", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DEEPSLATE)
            .sound(SoundType.DEEPSLATE)
            .strength(4.5f, 3)
            .requiresCorrectToolForDrops(),
            UniformInt.of(2,4)));
    public static final RegistryObject<Block> NO_TEXTURE_BLOCK = registerBlock("no_texture_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(1.5f)));
    public static final RegistryObject<Block> NO_TEXTURE_BRICKS = registerBlock("no_texture_bricks", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(2)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NO_TEXTURE_BRICKS_SLAB = registerBlock("no_texture_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(2)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NO_TEXTURE_BRICKS_STAIRS = registerBlock("no_texture_bricks_stairs", () -> new StairBlock(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(2)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NO_TEXTURE_BRICKS_WALL = registerBlock("no_texture_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(2)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NO_TEXTURE_SLAB = registerBlock("no_texture_slab", () -> new SlabBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(1.5f)));
    public static final RegistryObject<Block> NO_TEXTURE_STAIRS = registerBlock("no_texture_stairs", () -> new StairBlock(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(1.5f)));
    public static final RegistryObject<Block> NO_TEXTURE_WALL = registerBlock("no_texture_wall", () -> new WallBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(1.5f)));
    public static final RegistryObject<Block> OPAL_BLOCK = registerBlock("opal_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIAMOND)
            .sound(SoundType.METAL)
            .strength(5, 6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OPAL_ORE = registerBlock("opal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(3)
            .requiresCorrectToolForDrops(),
            UniformInt.of(3,5)));
    public static final RegistryObject<Block> OPAL_ORE_DEEPSLATE = registerBlock("opal_ore_deepslate", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DEEPSLATE)
            .sound(SoundType.DEEPSLATE)
            .strength(4.5f, 3)
            .requiresCorrectToolForDrops(),
            UniformInt.of(3,5)));
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY)
            .sound(SoundType.METAL)
            .strength(6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.CLAY)
            .sound(SoundType.METAL)
            .strength(5, 6)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .strength(3)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZINC_ORE_DEEPSLATE = registerBlock("zinc_ore_deepslate", () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.DEEPSLATE)
            .sound(SoundType.DEEPSLATE)
            .strength(4.5f, 3)
            .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZINC_RAW_BLOCK = registerBlock("zinc_raw_block", () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_CYAN)
            .strength(5, 6)
            .requiresCorrectToolForDrops()));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ FULL IMPORT ITEMS
    public static final RegistryObject<Block> CASING_WOODEN = registerBlock("casing_wooden", CasingWoodenBlock::new);
    public static final RegistryObject<Block> CHROMAKEY_BLACK = registerBlock("chromakey_black", ChromakeyBlackBlock::new);
    public static final RegistryObject<Block> LAMP_ANALOG = registerBlock("lamp_analog", LampAnalogBlock::new);
    public static final RegistryObject<Block> LUXMETER = registerBlock("luxmeter", LuxmeterBlock::new);
    public static final RegistryObject<Block> OMNIHOPPER = registerBlock("omnihopper", OmnihopperBlock::new);
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ COPY VANILLA ITEMS
    public static final RegistryObject<Block> IRON_DOOR_WL = registerBlock("iron_door_wl", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR), BlockSetType.IRON));
    public static final RegistryObject<Block> IRON_TRAPDOOR_WL = registerBlock("iron_trapdoor_wl", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CHROMAKEYS
    public static final RegistryObject<Block> CHROMAKEY_BLUE = registerBlock("chromakey_blue", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CHROMAKEY_BROWN = registerBlock("chromakey_brown", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT)));
    public static final RegistryObject<Block> CHROMAKEY_CYAN = registerBlock("chromakey_cyan", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM)));
    public static final RegistryObject<Block> CHROMAKEY_GRAY = registerBlock("chromakey_gray", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> CHROMAKEY_GREEN = registerBlock("chromakey_green", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD)));
    public static final RegistryObject<Block> CHROMAKEY_LIGHT_BLUE = registerBlock("chromakey_light_blue", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS)));
    public static final RegistryObject<Block> CHROMAKEY_LIGHT_GRAY = registerBlock("chromakey_light_gray", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> CHROMAKEY_LIME = registerBlock("chromakey_lime", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHROMAKEY_MAGENTA = registerBlock("chromakey_magenta", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM)));
    public static final RegistryObject<Block> CHROMAKEY_ORANGE = registerBlock("chromakey_orange", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> CHROMAKEY_PINK = registerBlock("chromakey_pink", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> CHROMAKEY_PURPLE = registerBlock("chromakey_purple", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> CHROMAKEY_RED = registerBlock("chromakey_red", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE)));
    public static final RegistryObject<Block> CHROMAKEY_WHITE = registerBlock("chromakey_white", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW)));
    public static final RegistryObject<Block> CHROMAKEY_YELLOW = registerBlock("chromakey_yellow", () -> new ChromakeyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        JitelItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}