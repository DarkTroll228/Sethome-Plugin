package com.darktroll.sethome.tab;

import com.darktroll.sethome.managers.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HomeTabCompleter implements TabCompleter {
    private final PlayerManager playerManager = PlayerManager.getInstance();


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player)) return null;
        Player player = (Player) sender;


        return null;
    }
}
