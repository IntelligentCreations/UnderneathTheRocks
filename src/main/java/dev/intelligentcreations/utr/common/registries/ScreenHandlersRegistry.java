package dev.intelligentcreations.utr.common.registries;

import dev.intelligentcreations.utr.common.screenhandlers.impl.AnalyzerScreenHandler;
import dev.intelligentcreations.utr.common.screenhandlers.init.UTRScreenHandlerInit;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

import static dev.intelligentcreations.utr.common.registries.BlockEntityRegistry.ANALYZER_IDENTIFIER;

public class ScreenHandlersRegistry {
    public static void register() {
        UTRScreenHandlerInit.ANALYZER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(ANALYZER_IDENTIFIER, AnalyzerScreenHandler::new);
    }
}
