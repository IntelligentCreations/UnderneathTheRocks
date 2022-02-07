package dev.intelligentcreations.utr;

import dev.intelligentcreations.utr.common.registries.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnderneathTheRocks implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Underneath The Rocks");
	public static final String MOD_ID = "utr";

	@Override
	public void onInitialize() {
		ItemRegistry.register();
		BlockRegistry.register();
		BlockEntityRegistry.register();
		OreGenRegistry.register();
		ScreenHandlersRegistry.register();
		SoundRegistry.register();
		LOGGER.info("Initialized.");
	}
}
