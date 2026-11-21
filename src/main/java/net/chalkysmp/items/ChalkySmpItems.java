package net.chalkysmp.items;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChalkySmpItems implements ModInitializer {
    public static final String MOD_ID = "chalkysmp_items";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();
        LOGGER.info("ChalkySMP Items loaded!");
    }
}
