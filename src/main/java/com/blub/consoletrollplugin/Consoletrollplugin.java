package com.blub.consoletrollplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Consoletrollplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Boom plugin has been loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
