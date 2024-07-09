package net.jitle.jitelcraft.item.template;

import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class NameItem extends Item {
    private final String name;
    public NameItem(Properties pProperties, String name) {
        super(pProperties);
        this.name = name;
    }
    @Override
    public @NotNull String getDescriptionId() {
        //return Util.makeDescriptionId("item", new ResourceLocation(this.name));
        return this.name;
    }
}