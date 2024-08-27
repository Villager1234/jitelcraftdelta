package net.jitle.jitelcraft;

import net.jitle.jitelcraft.armor.*;
import net.jitle.jitelcraft.item.*;
import net.jitle.jitelcraft.item.template.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class JCItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JitelcraftMod.MODID);
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SIMPLE ITEMS
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_GEAR = ITEMS.register("aluminum_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_RAW = ITEMS.register("aluminum_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_ROD = ITEMS.register("aluminum_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_WIRE = ITEMS.register("aluminum_wire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_GEAR = ITEMS.register("amethyst_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_NUGGET = ITEMS.register("amethyst_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_PLATE = ITEMS.register("amethyst_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_ROD = ITEMS.register("amethyst_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_COMPONENTS = ITEMS.register("brass_components", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_DUST = ITEMS.register("brass_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_GEAR = ITEMS.register("brass_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_ROD = ITEMS.register("brass_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust", () -> new FuelItem(new Item.Properties(),1600));
    public static final RegistryObject<Item> COAL_PLATE = ITEMS.register("coal_plate", () -> new FuelItem(new Item.Properties(),1600));
    public static final RegistryObject<Item> COIL = ITEMS.register("coil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_ALUMINUM = ITEMS.register("coil_aluminum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIL_COPPER = ITEMS.register("coil_copper", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONTROLLER_TIER1 = ITEMS.register("controller_tier1", () -> new DescrItem(new Item.Properties(),"text.jitelcraft.tier.1"));
    public static final RegistryObject<Item> CONTROLLER_TIER2 = ITEMS.register("controller_tier2", () -> new DescrItem(new Item.Properties(),"text.jitelcraft.tier.2"));
    public static final RegistryObject<Item> CONTROLLER_TIER1_DOWN = ITEMS.register("controller_tier1_down", () -> new NameDescrItem(new Item.Properties(),"item.jitelcraft.controller_down","text.jitelcraft.tier.1"));
    public static final RegistryObject<Item> CONTROLLER_TIER2_DOWN = ITEMS.register("controller_tier2_down", () -> new NameDescrItem(new Item.Properties(),"item.jitelcraft.controller_down","text.jitelcraft.tier.2"));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_GEAR = ITEMS.register("copper_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_ROD = ITEMS.register("copper_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRUSHER_PART = ITEMS.register("crusher_part", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GEAR = ITEMS.register("diamond_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_NUGGET = ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PLATE = ITEMS.register("diamond_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_ROD = ITEMS.register("diamond_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_GEAR = ITEMS.register("emerald_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_NUGGET = ITEMS.register("emerald_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PLATE = ITEMS.register("emerald_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_ROD = ITEMS.register("emerald_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLASK_DYE_BLACK = ITEMS.register("flask_dye_black", () -> new CraftingDurRepItem(new Item.Properties().durability(16),/*JCItems.FLASK.get()*/Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_BLUE = ITEMS.register("flask_dye_blue", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_BROWN = ITEMS.register("flask_dye_brown", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_CYAN = ITEMS.register("flask_dye_cyan", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_GRAY = ITEMS.register("flask_dye_gray", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_GREEN = ITEMS.register("flask_dye_green", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_LIGHT_BLUE = ITEMS.register("flask_dye_light_blue", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_LIGHT_GRAY = ITEMS.register("flask_dye_light_gray", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_LIME = ITEMS.register("flask_dye_lime", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_MAGENTA = ITEMS.register("flask_dye_magenta", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_ORANGE = ITEMS.register("flask_dye_orange", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_PINK = ITEMS.register("flask_dye_pink", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_PURPLE = ITEMS.register("flask_dye_purple", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_RED = ITEMS.register("flask_dye_red", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_WHITE = ITEMS.register("flask_dye_white", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> FLASK_DYE_YELLOW = ITEMS.register("flask_dye_yellow", () -> new CraftingDurRepItem(new Item.Properties().durability(16),Items.GLASS_BOTTLE));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_GEAR = ITEMS.register("gold_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_ROD = ITEMS.register("gold_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new CraftingDurabilityItem(new Item.Properties().durability(16)));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_GEAR = ITEMS.register("iron_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JITEL_DUST = ITEMS.register("jitel_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JITEL_GEM = ITEMS.register("jitel_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JITEL_NUGGET = ITEMS.register("jitel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_GEAR = ITEMS.register("lapis_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_NUGGET = ITEMS.register("lapis_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_PLATE = ITEMS.register("lapis_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_ROD = ITEMS.register("lapis_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOTOR_TIER1 = ITEMS.register("motor_tier1", () -> new DescrItem(new Item.Properties(),"text.jitelcraft.tier.1"));
    public static final RegistryObject<Item> MOTOR_TIER2 = ITEMS.register("motor_tier2", () -> new DescrItem(new Item.Properties(),"text.jitelcraft.tier.2"));
    public static final RegistryObject<Item> MOTOR_TIER1_DOWN = ITEMS.register("motor_tier1_down", () -> new NameDescrItem(new Item.Properties(),"item.jitelcraft.motor_down","text.jitelcraft.tier.1"));
    public static final RegistryObject<Item> MOTOR_TIER2_DOWN = ITEMS.register("motor_tier2_down", () -> new NameDescrItem(new Item.Properties(),"item.jitelcraft.motor_down","text.jitelcraft.tier.2"));
    public static final RegistryObject<Item> NETHERITE_DUST = ITEMS.register("netherite_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GEAR = ITEMS.register("netherite_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_PLATE = ITEMS.register("netherite_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_ROD = ITEMS.register("netherite_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_DUST = ITEMS.register("opal_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_GEAR = ITEMS.register("opal_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_GEM = ITEMS.register("opal_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_NUGGET = ITEMS.register("opal_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_PLATE = ITEMS.register("opal_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_ROD = ITEMS.register("opal_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_DUST = ITEMS.register("quartz_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_GEAR = ITEMS.register("quartz_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_NUGGET = ITEMS.register("quartz_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_PLATE = ITEMS.register("quartz_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_ROD = ITEMS.register("quartz_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_COMPONENTS = ITEMS.register("steel_components", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_GEAR = ITEMS.register("steel_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STONE_ROD = ITEMS.register("stone_rod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_GEAR = ITEMS.register("wooden_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_GEAR = ITEMS.register("zinc_gear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_PLATE = ITEMS.register("zinc_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_RAW = ITEMS.register("zinc_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_ROD = ITEMS.register("zinc_rod", () -> new Item(new Item.Properties()));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ FULL IMPORT ITEMS
    public static final RegistryObject<Item> JITEL_SWORD = ITEMS.register("jitel_sword", JitelSwordItem::new);
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ TOOLS ITEMS
    public static final RegistryObject<Item> CURSED_PICKAXE = ITEMS.register("cursed_pickaxe", () -> new PickaxeItem(new Tier() {
        @Override public int getUses() {return 1408;}
        @Override public float getSpeed() {return 2;}
        @Override public float getAttackDamageBonus() {return 1;}
        @Override public int getLevel() {return 0;}
        @Override public int getEnchantmentValue() {return 2;}
        @Override public @NotNull Ingredient getRepairIngredient() {return Ingredient.of(ItemTags.create(new ResourceLocation("forge:nuggets/diamond")));}
    }, 1, -2.8f, new Item.Properties()));
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ARMOR ITEMS
    public static final RegistryObject<Item> PLATE_HELMET = ITEMS.register("plate_helmet", () -> new PlateArmor.PlateArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> PLATE_CHESTPLATE = ITEMS.register("plate_chestplate", () -> new PlateArmor.PlateArmorItem(ArmorItem.Type.CHESTPLATE));
    //public static final RegistryObject<Item> PLATE_CHESTPLATE = ITEMS.register("plate_chestplate", () -> new ArmorItem(null, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
}