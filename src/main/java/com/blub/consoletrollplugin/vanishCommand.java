package com.blub.consoletrollplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class vanishCommand implements CommandExecutor {

    List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("consoletroll.vanish")) {
            if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (vanished.contains(target.getUniqueId())) {
                        vanished.remove(target.getUniqueId());
                        sender.sendMessage("You have shown " + target.getPlayer().getDisplayName());
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            if (!(onlinePlayer == Bukkit.getPlayer("Ja90n"))) {
                                onlinePlayer.showPlayer(target);
                            }
                        }
                    } else {
                        vanished.add(target.getUniqueId());
                        sender.sendMessage("You have hidden " + target.getPlayer().getDisplayName());
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            if (!(onlinePlayer == Bukkit.getPlayer("Ja90n"))) {
                                onlinePlayer.hidePlayer(target);
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    sender.sendMessage("You need to fill in the name of an online player.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid arguments, try: /vanish <player>");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have the permission to use this command!");
        }
        return false;
    }
}
