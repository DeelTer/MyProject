package ru.deelter.myproject.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.myproject.Config;
import ru.deelter.myproject.MyProject;
import ru.deelter.myproject.utils.Colors;

import java.util.ArrayList;
import java.util.List;

public class TestCommand implements CommandExecutor, @Nullable TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage(Colors.set("&cNo arguments"));
            return true;
        }

        /* Reload config command */
        if (args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage(Colors.set("&eConfig reloaded!"));
            Config.reload(MyProject.getInstance());
            return true;
        }
        //TODO maybe new args here
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (args.length == 1) {
            suggestions.add("reload");
            return suggestions;
        }
        return null;
    }
}
