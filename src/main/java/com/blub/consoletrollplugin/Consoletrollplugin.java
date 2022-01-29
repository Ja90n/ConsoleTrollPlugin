package com.blub.consoletrollplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Consoletrollplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "| Starting ConsoleTrollPlugin v1.0 |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "---------------------------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        getCommand("mlg").setExecutor(new mlgCommand());
        getCommand("vanish").setExecutor(new vanishCommand());
        getCommand("mlg").setTabCompleter(new mlgTabComplete());
        getCommand("vanish").setTabCompleter(new vanishTabComplete());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
