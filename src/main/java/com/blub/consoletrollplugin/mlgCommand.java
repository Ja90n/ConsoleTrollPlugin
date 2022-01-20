package com.blub.consoletrollplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mlgCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(args.length == 2)) {
            sender.sendMessage(ChatColor.RED + "Invalid arguments, try: /mlg <Player> <height of mlg>");
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                sender.sendMessage(ChatColor.RED + "You need to fill in the name of an online player!");
            }
            try {
                int height = Integer.parseInt(args[0]);
                target.teleport(target.getLocation().add(0, height, 0));

            } catch (IllegalArgumentException e) {
                sender.sendMessage(ChatColor.RED + "You need to fill in a number");
            }
        }
        return false;
    }
}
