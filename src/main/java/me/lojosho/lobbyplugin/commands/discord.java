package me.lojosho.lobbyplugin.commands;

import me.lojosho.lobbyplugin.Lobbyplugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class discord {

    private final Lobbyplugin plugin;

    public discord(Lobbyplugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("discord")) {
            for (String line : plugin.getConfig().getStringList("discord")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
            }
            return true;
        }
        return false;
    }

}
