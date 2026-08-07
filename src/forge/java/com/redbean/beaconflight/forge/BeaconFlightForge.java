package com.redbean.beaconflight.forge;

import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("beaconflight")
public class BeaconFlightForge {
    public static final String MOD_ID = "beaconflight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public BeaconFlightForge() {
        LOGGER.info("[BeaconFlight] Ready — any beacon effect grants flight.");
    }
}
