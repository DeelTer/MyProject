package ru.deelter.myproject;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static final MyProject INSTANCE = MyProject.getInstance();

    private static boolean DEBUG_ENABLE;

    public static void load() {
        FileConfiguration config = INSTANCE.getConfig();
        DEBUG_ENABLE = config.getBoolean("debug");
    }

    public static void reload() {
        INSTANCE.reloadConfig();
        load();
    }

    public static boolean isDebugEnable() {
        return DEBUG_ENABLE;
    }
}
