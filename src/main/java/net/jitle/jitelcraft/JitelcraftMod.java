package net.jitle.jitelcraft;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JitelcraftMod.MODID)
public class JitelcraftMod {
    public static final String MODID = "jitelcraft";
    public JitelcraftMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        JitelItems.ITEMS.register(bus);
        JitelBlocks.BLOCKS.register(bus);
        JitelTabs.TABS.register(bus);
        JitelBlockEntities.BLOCK_ENTITIES.register(bus);
    }
}