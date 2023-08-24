package com.darktroll.sethome.cmd;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHomeCommand implements CommandExecutor {

    private final PlayerManager manager = PlayerManager.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) sender.sendMessage("Only for players");
        if(args.length < 1) return false;
        Player player = (Player) sender;

        try {
            HomeUnit home = new HomeUnit(player, player.getLocation(), args[0], Material.OAK_SAPLING);
            manager.getPlayers().get(player).getHomeList().add(home);
            manager.getPlayers().get(player).getHomeListUI().update(home);
            player.sendMessage(ChatColor.GREEN + "Точка дома " + args[0] + " создана.");
        } catch (Exception e) {
            player.sendMessage("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        return true;
    }
}