package com.bloomdoom.system;

import com.bloomdoom.BloomDoom;
import com.bloomdoom.registry.ModEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BloomDoom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class Infection {
    private static final int MAX_BLOOM_LEVEL = 3;
    private static final int BLOOM_DURATION = Integer.MAX_VALUE;

    private Infection() {
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity().level().isClientSide) {
            return;
        }

        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            tryInfect(attacker, event.getEntity(), attacker.getRandom());
        }
    }

    public static boolean tryInfect(LivingEntity attacker, LivingEntity target, RandomSource random) {
        if (attacker == target || !attacker.isAlive() || !target.isAlive()) {
            return false;
        }

        int attackerLevel = getBloomLevel(attacker);
        int chance = getInfectionChance(attackerLevel);
        if (chance == 0 || random.nextInt(100) >= chance) {
            return false;
        }

        int targetLevel = getBloomLevel(target);
        int newLevel = Math.min(targetLevel + 1, MAX_BLOOM_LEVEL);
        return target.addEffect(new MobEffectInstance(
                ModEffects.BLOOM.get(),
                BLOOM_DURATION,
                newLevel - 1
        ));
    }

    public static int getBloomLevel(LivingEntity entity) {
        MobEffectInstance bloom = entity.getEffect(ModEffects.BLOOM.get());
        return bloom == null ? 0 : Math.min(bloom.getAmplifier() + 1, MAX_BLOOM_LEVEL);
    }

    public static int getInfectionChance(int bloomLevel) {
        return switch (bloomLevel) {
            case 1 -> 40;
            case 2 -> 70;
            case 3 -> 100;
            default -> 0;
        };
    }
}
