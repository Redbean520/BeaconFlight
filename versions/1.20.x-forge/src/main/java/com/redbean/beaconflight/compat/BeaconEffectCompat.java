package com.redbean.beaconflight.compat;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;

/**
 * Checks whether a player has any ambient beacon effect active.
 * <p>
 * This is the <b>MC 1.20.1</b> implementation — uses the old
 * {@code MobEffect[][]} field before the {@code Holder} migration.
 */
public final class BeaconEffectCompat {

    private BeaconEffectCompat() { /* static helper */ }

    public static boolean hasAnyBeaconEffect(ServerPlayer player) {
        for (MobEffect[] tier : BeaconBlockEntity.BEACON_EFFECTS) {
            for (MobEffect effect : tier) {
                if (player.hasEffect(effect)) {
                    var instance = player.getEffect(effect);
                    if (instance != null && instance.isAmbient()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
