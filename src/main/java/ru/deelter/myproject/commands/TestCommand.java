package ru.deelter.myproject.commands;

import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.myproject.Config;
import ru.deelter.myproject.utils.Colors;

import java.util.ArrayList;
import java.util.List;

public class TestCommand implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage(Colors.set("&cNo arguments"));
            return true;
        }

        // Reload config
        if (args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage("Config reloaded");
            Config.reload();
            return true;
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (args.length == 1) suggestions.add("reload");
        return filter(suggestions, args);
    }

    private static List<String> filter(@NotNull List<String> variables, String[] args) {
        List<String> result = new ArrayList<>();
        String lastArg = args[args.length - 1];
        for (String variable : variables) if (variable.startsWith(lastArg)) result.add(variable);
        return result;
    }
}
