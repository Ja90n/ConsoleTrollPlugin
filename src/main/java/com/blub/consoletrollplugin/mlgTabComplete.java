package com.blub.consoletrollplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class mlgTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> results = new ArrayList<String>();
        if (args.length == 1){
            for (Player target : Bukkit.getOnlinePlayers()){
                results.add(target.getDisplayName());
            }
        } else if (args.length == 2){
            results.add("<number>");
        }
        return results;
    }
}
