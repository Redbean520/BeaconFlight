package com.redbean.beaconflight.neoforge;

import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("beaconflight")
public class BeaconFlightNeoForge {
    public static final String MOD_ID = "beaconflight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public BeaconFlightNeoForge() {
        LOGGER.info("[BeaconFlight] Ready — any beacon effect grants flight.");
    }
}
