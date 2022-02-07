package dev.intelligentcreations.utr.common.registries;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundRegistry {
    public static final Identifier ANALYZING_SOUND = new Identifier("utr:analyzer");
    public static SoundEvent ANALYZING_SOUND_EVENT = new SoundEvent(ANALYZING_SOUND);

    public static void register() {
        Registry.register(Registry.SOUND_EVENT, ANALYZING_SOUND, ANALYZING_SOUND_EVENT);
    }
}
