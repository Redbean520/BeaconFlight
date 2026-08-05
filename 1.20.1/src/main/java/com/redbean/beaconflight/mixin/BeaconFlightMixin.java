package com.redbean.beaconflight.mixin;

import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Grants creative flight whenever the player has an active beacon effect.
 * No scanning, no timers — the vanilla beacon handles range, duration,
 * and the ~9 s grace period automatically.
 */
@Mixin(ServerPlayer.class)
public abstract class BeaconFlightMixin {

    /** Check beacon effects only every N ticks (~0.5 s) — beacon grace period is several seconds. */
    @Unique
    private static final int CHECK_INTERVAL = 10;

    @Inject(method = "tick", at = @At("TAIL"))
    private void beaconflight$tick(CallbackInfo ci) {
        ServerPlayer self = (ServerPlayer) (Object) this;
        if (self.isSpectator()) return;

        // Skip checks between intervals: beacon effects last several seconds,
        // so a 0.5 s poll is more than responsive enough.
        if (self.tickCount % CHECK_INTERVAL != 0) return;

        Abilities abilities = self.getAbilities();
        boolean hasBeacon = hasAnyBeaconEffect(self);

        if (hasBeacon) {
            if (!abilities.mayfly) {
                abilities.mayfly = true;
                if (self.connection != null) {
                    self.connection.send(new ClientboundPlayerAbilitiesPacket(abilities));
                }
            }
        } else {
            if (abilities.mayfly && !self.isCreative()) {
                abilities.mayfly = false;
                abilities.flying = false;
                if (self.connection != null) {
                    self.connection.send(new ClientboundPlayerAbilitiesPacket(abilities));
                }
            }
        }
    }

    private static boolean hasAnyBeaconEffect(ServerPlayer player) {
        for (MobEffect[] tier : BeaconBlockEntity.BEACON_EFFECTS) {
            for (MobEffect effect : tier) {
                if (player.hasEffect(effect) && player.getEffect(effect).isAmbient()) {
                    return true;
                }
            }
        }
        return false;
    }
}
