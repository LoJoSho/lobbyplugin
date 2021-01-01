package me.lojosho.lobbyplugin;

import me.lojosho.lobbyplugin.commands.discord;
import me.lojosho.lobbyplugin.listeners.VoidAvoidance;
import me.lojosho.lobbyplugin.listeners.Joining;
import me.lojosho.lobbyplugin.listeners.Leaving;
import me.lojosho.lobbyplugin.listeners.PlayerClick;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobbyplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        registerListeners();
        registerCommands();
    }
    @Override
    public void onDisable() {
        this.getLogger().info("Lobby Plugin is disabling itself...");
    }
    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new Joining(this), this);
        getServer().getPluginManager().registerEvents(new Leaving(), this);
        getServer().getPluginManager().registerEvents(new PlayerClick(this), this);
        getServer().getPluginManager().registerEvents(new VoidAvoidance(this), this);
    }

    public void registerCommands() {
        getCommand("discord").setExecutor((CommandExecutor) new discord(this));
    }
}
