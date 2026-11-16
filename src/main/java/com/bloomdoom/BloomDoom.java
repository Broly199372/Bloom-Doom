package com.bloomdoom;

import com.mojang.logging.LogUtils;
import com.bloomdoom.registry.ModEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BloomDoom.MOD_ID)
public class BloomDoom {
    public static final String MOD_ID = "bloomdoom";
    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public BloomDoom() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEffects.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Bloom Doom initialized");
    }
}
