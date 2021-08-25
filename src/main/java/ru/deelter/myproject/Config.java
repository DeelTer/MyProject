package ru.deelter.myproject;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static final MyProject INSTANCE = MyProject.getInstance();

    public static boolean DEBUG;

    public static void reload() {
        INSTANCE.reloadConfig();
        load();
    }

    public static void load() {
        FileConfiguration config = INSTANCE.getConfig();
        DEBUG = config.getBoolean("debug");
    }
}
