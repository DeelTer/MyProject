package ru.deelter.myproject.utils;

import org.bukkit.Bukkit;
import ru.deelter.myproject.Config;

public class Console {

    /** Send message to console */
    public static void info(String s) {
        Bukkit.getLogger().info(Colors.set(s));
    }

    public static void debug(String s) {
        if (Config.DEBUG)
            info("&f" + s);
    }
}
