package com.bloomdoom.datagen;

import com.bloomdoom.BloomDoom;
import com.bloomdoom.registry.ModEffects;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BloomDoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class Datagen {
    private Datagen() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(
                event.includeClient(),
                new BloomLanguageProvider(event.getGenerator().getPackOutput())
        );
    }

    private static final class BloomLanguageProvider extends LanguageProvider {
        private BloomLanguageProvider(PackOutput output) {
            super(output, BloomDoom.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            addEffect(ModEffects.BLOOM, "Bloom");
        }
    }
}
