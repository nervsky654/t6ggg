package com.example.cncd.mixin;

import com.example.cncd.NightDarkness;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LightTexture.class)
public class LightTextureMixin {

    @Redirect(
            method = "updateLightTexture",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/ClientLevel;getSkyDarken(F)F"
            )
    )
    private float cncd$darkerNights(ClientLevel level, float partialTick) {
        float vanilla = level.getSkyDarken(partialTick);
        if (!level.dimensionType().hasSkyLight()) return vanilla;
        return NightDarkness.apply(vanilla);
    }
}
