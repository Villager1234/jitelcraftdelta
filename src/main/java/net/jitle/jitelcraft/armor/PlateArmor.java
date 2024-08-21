package net.jitle.jitelcraft.armor;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class PlateArmor extends ArmorItem {
    public PlateArmor(ArmorItem.Type type, Item.Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(ArmorItem.@NotNull Type type) {
                return new int[]{11, 16, 15, 13}[type.ordinal()] * 14;
            }
            @Override
            public int getDefenseForType(ArmorItem.@NotNull Type type) {
                return new int[]{2, 4, 0, 0}[type.ordinal()];
            }
            @Override
            public int getEnchantmentValue() {
                return 12;
            }
            @Override
            public @NotNull SoundEvent getEquipSound() {
                return Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_generic")));
            }
            @Override
            public @NotNull Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(Blocks.SMOOTH_STONE_SLAB));
            }
            @Override
            public @NotNull String getName() {
                return "jitelcraft:plate_armor";
            }
            @Override
            public float getToughness() {
                return 1f;
            }
            @Override
            public float getKnockbackResistance() {
                return 0.12f;
            }
        }, type, properties);
    }
    public static class PlateArmorItem extends PlateArmor {
        public PlateArmorItem(ArmorItem.Type armorType) {
            super(armorType, new Item.Properties());
        }
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "jitelcraft:textures/models/armor/plate.png";
        }
    }
    /*public static class Chestplate extends PlateArmor {
        public Chestplate() {
            super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
        }
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "jitelcraft:textures/models/armor/plate.png";
        }
    }*/
}
