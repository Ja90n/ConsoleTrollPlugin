package com.blub.consoletrollplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class mlgCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            try {
                Player target = Bukkit.getPlayer(args[0]);
                target.sendMessage(ChatColor.LIGHT_PURPLE + "Je bent " + ChatColor.WHITE + "50" + ChatColor.LIGHT_PURPLE + " blocken de lucht in gestuurt, succes met de mlg");
                target.teleport(target.getLocation().add(0, 50, 0));
                try {
                    ItemStack hand = target.getInventory().getItemInMainHand();
                    try {
                        target.getWorld().dropItem(target.getLocation(), hand);
                    } catch (Exception e) {}
                    target.getInventory().setItemInMainHand(new ItemStack(Material.WATER_BUCKET));
                } catch (Exception e){}
            } catch (NullPointerException e){
                sender.sendMessage(ChatColor.RED + "You need to fill in the name of an online player!");
            }
        } else if (args.length == 2){
            try {
                Player target = Bukkit.getPlayer(args[0]);
                try {
                    int height = Integer.parseInt(args[1]);
                    target.teleport(target.getLocation().add(0,height,0));
                    target.sendMessage(ChatColor.LIGHT_PURPLE + "Je bent " + ChatColor.WHITE + height + ChatColor.LIGHT_PURPLE +" blocken de lucht in gestuurt, succes met de mlg");
                    try {
                        ItemStack hand = target.getInventory().getItemInMainHand();
                        try {
                            target.getWorld().dropItem(target.getLocation(), hand);
                        } catch (Exception e) {}
                        target.getInventory().setItemInMainHand(new ItemStack(Material.WATER_BUCKET));
                    } catch (Exception e){}
                } catch (IllegalArgumentException e){
                    target.sendMessage(ChatColor.RED + "You need to fill in a number");
                }
            } catch (NullPointerException e){
                sender.sendMessage(ChatColor.RED + "You need to fill in the name of an online player!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid arguments, try: /mlg <player> <height>");
        }
        return false;
    }
}

