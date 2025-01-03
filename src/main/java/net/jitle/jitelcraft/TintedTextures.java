package net.jitle.jitelcraft;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

public class TintedTextures {
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        //@OnlyIn(Dist.CLIENT)
        public static void itemColorLoad(RegisterColorHandlersEvent.@NotNull Item event) {
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Red darker d90808 ==*/14223368 : -1, JCItems.CONTROLLER_TIER1_DOWN.get(), JCItems.MOTOR_TIER1_DOWN.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Orange f6520c ==*/16142860 : -1, JCItems.CONTROLLER_TIER2_DOWN.get(), JCItems.MOTOR_TIER2_DOWN.get(), JCItems.FLASK_DYE_ORANGE.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Black 161616 ==*/1447446 : -1, JCItems.FLASK_DYE_BLACK.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Blue 1152f7 ==*/1135351 : -1, JCItems.FLASK_DYE_BLUE.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Brown 94582b ==*/9721899 : -1, JCItems.FLASK_DYE_BROWN.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Cyan 29cbc1 ==*/2739137 : -1, JCItems.FLASK_DYE_CYAN.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Gray 5f5f5f ==*/6250335 : -1, JCItems.FLASK_DYE_GRAY.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Green 1fcf1f ==*/2084639 : -1, JCItems.FLASK_DYE_GREEN.get()/*, JCItems.CONTROLLER_TIER5_DOWN.get(), JCItems.MOTOR_TIER5_DOWN.get()*/);
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Light blue 4da2e3 ==*/5087971 : -1, JCItems.FLASK_DYE_LIGHT_BLUE.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Light gray bfbfbf ==*/12566463 : -1, JCItems.FLASK_DYE_LIGHT_GRAY.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Lime 72ec4d ==*/7531597 : -1, JCItems.FLASK_DYE_LIME.get()/*, JCItems.CONTROLLER_TIER4_DOWN.get(), JCItems.MOTOR_TIER4_DOWN.get()*/);
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Magenta de19ac ==*/14555564 : -1, JCItems.FLASK_DYE_MAGENTA.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Pink fa6dca ==*/16412106 : -1, JCItems.FLASK_DYE_PINK.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Purple 902ad7 ==*/9448151 : -1, JCItems.FLASK_DYE_PURPLE.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Red f60c0c ==*/16124940 : -1, JCItems.FLASK_DYE_RED.get());
            event.getItemColors().register((stack, index) -> index == 1 ?
                    /*== Yellow ecdc0d ==*/15522829 : -1, JCItems.FLASK_DYE_YELLOW.get()/*, JCItems.CONTROLLER_TIER3_DOWN.get(), JCItems.MOTOR_TIER3_DOWN.get()*/);
        }
    }
    /*public static int downTierColor(int tier) {
        return switch (tier) {
            case 1 -> 10420224;
            case 2 -> 15616000;
            default -> -1;
        };
    }*/
}
