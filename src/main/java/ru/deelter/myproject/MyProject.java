package ru.deelter.myproject;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.deelter.myproject.commands.TestCommand;
import ru.deelter.myproject.listeners.CustomListener;

public final class MyProject extends JavaPlugin {

    private static MyProject instance;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        Config.load();

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new CustomListener(), this);

        PluginCommand command = getCommand("test");
        if (command != null) {
            command.setExecutor(new TestCommand());
            command.setTabCompleter(new TestCommand());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MyProject getInstance() {
        return instance;
    }
}
