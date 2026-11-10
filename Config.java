package com.example.cncd;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DARK_NIGHTS = BUILDER
            .comment("Включить более тёмные ночи (только на клиенте)")
            .define("darkNights", true);

    public static final ModConfigSpec.DoubleValue NIGHT_DARKNESS = BUILDER
            .comment("Насколько темнее ночь: 0.0 = как в ванили, 1.0 = почти кромешная тьма")
            .defineInRange("nightDarkness", 0.85, 0.0, 1.0);

    public static final ModConfigSpec SPEC = BUILDER.build();

    private Config() {}
}
