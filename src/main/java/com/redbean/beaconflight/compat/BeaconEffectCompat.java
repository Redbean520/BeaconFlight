package com.redbean.beaconflight.compat;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;

import java.util.List;

/**
 * Checks whether a player has any ambient beacon effect active.
 * <p>
 * This is the <b>MC 1.21+</b> implementation — the field changed from
 * {@code MobEffect[][]} to {@code List<Holder<MobEffect>>}.
 * <p>
 * MC 1.20.x uses its own versioned overlay at
 * {@code versions/1.20.x-fabric/.../compat/BeaconEffectCompat.java}
 * and {@code versions/1.20.x-forge/.../compat/BeaconEffectCompat.java}.
 */
public final class BeaconEffectCompat {

    private BeaconEffectCompat() { /* static helper */ }

    public static boolean hasAnyBeaconEffect(ServerPlayer player) {
        for (List<Holder<MobEffect>> tier : BeaconBlockEntity.BEACON_EFFECTS) {
            for (Holder<MobEffect> holder : tier) {
                if (player.hasEffect(holder)) {
                    var instance = player.getEffect(holder);
                    if (instance != null && instance.isAmbient()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
