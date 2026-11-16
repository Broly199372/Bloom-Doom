package com.bloomdoom.registry;

import com.bloomdoom.BloomDoom;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEffects {
    private static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BloomDoom.MOD_ID);

    public static final RegistryObject<MobEffect> BLOOM = EFFECTS.register(
            "bloom",
            () -> new MobEffect(MobEffectCategory.HARMFUL, 0x6B8E23) {
            });

    private ModEffects() {
    }

    public static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }
}
