package ru.deelter.myproject.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatColor;

public class Colors {

    /** @return Colorized String with color placeholders */
    public static String set(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    /** @return Colorized Component with color placeholders */
    public static Component component(String s) {
        return LegacyComponentSerializer.legacySection().deserialize(set(s)).decoration(TextDecoration.ITALIC, false);
    }

    /** @return Stripped String */
    public static String strip(String s) {
        return ChatColor.stripColor(s);
    }

    /** @return color from hex */
    public static ChatColor from(String hex) {
        return ChatColor.of(hex);
    }
}
