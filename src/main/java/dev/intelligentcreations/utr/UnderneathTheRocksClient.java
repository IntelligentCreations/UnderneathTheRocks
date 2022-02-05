package dev.intelligentcreations.utr;

import dev.intelligentcreations.utr.client.screen.impl.AnalyzerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

import static dev.intelligentcreations.utr.common.screenhandlers.init.UTRScreenHandlerInit.ANALYZER_SCREEN_HANDLER;

@Environment(EnvType.CLIENT)
public class UnderneathTheRocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ANALYZER_SCREEN_HANDLER, AnalyzerScreen::new);
    }
}
