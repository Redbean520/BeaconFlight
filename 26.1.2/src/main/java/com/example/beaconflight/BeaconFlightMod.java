package com.example.beaconflight;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeaconFlightMod implements ModInitializer {
    public static final String MOD_ID = "beaconflight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[BeaconFlight] Ready — any beacon effect grants flight.");
    }
}
