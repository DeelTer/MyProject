package ru.deelter.myproject;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static boolean DEBUG;

    public static void reload(MyProject plugin) {
        plugin.reloadConfig();
        load(plugin);
    }

    public static void load(MyProject plugin) {
        FileConfiguration config = plugin.getConfig();
        DEBUG = config.getBoolean("debug");
    }
}
