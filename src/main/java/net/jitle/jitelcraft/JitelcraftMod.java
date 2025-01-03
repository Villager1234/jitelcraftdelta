package net.jitle.jitelcraft;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JitelcraftMod.MODID)
public class JitelcraftMod {
    public static final String MODID = "jitelcraft";
    public JitelcraftMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        JCItems.ITEMS.register(bus);
        JCBlocks.BLOCKS.register(bus);
        JCTabs.TABS.register(bus);
        JCBlockEntities.BLOCK_ENTITIES.register(bus);
        //MinecraftForge.EVENT_BUS.register(this);
    }
}