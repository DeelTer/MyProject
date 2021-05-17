package ru.deelter.myproject;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import ru.deelter.myproject.commands.TestCommand;
import ru.deelter.myproject.utils.Console;

import java.io.File;

public final class MyProject extends JavaPlugin {

    private static MyProject instance;

    public static MyProject getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        File config = new File(instance.getDataFolder().getPath() + "/config.yml");
        if (!config.exists()) {
            Console.debug("Load new configuration");
            saveDefaultConfig();
        }
        Config.load(this);

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
}
