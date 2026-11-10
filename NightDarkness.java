package com.example.cncd;

public class NightDarkness {
    /**
     * Принимает ванильный skyDarken (от 0.2 ночью до 1.0 днём) и делает ночь темнее.
     * Меняется только небесный свет, блочный свет (факелы, динамический свет
     * от предметов в руке) не затрагивается.
     */
    public static float apply(float vanilla) {
        float strength;
        try {
            if (!Config.DARK_NIGHTS.get()) return vanilla;
            strength = Config.NIGHT_DARKNESS.get().floatValue();
        } catch (Throwable t) {
            // конфиг ещё не загружен
            return vanilla;
        }
        float day = Math.max(0.0f, Math.min(1.0f, (vanilla - 0.2f) / 0.8f)); // 0 = глубокая ночь, 1 = день
        float night = 1.0f - day;
        return Math.max(0.0f, vanilla - strength * 0.2f * night);
    }

    private NightDarkness() {}
}
