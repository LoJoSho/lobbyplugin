package me.lojosho.lobbyplugin.listeners;

import me.lojosho.lobbyplugin.Lobbyplugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class VoidAvoidance implements Listener {

    private final Lobbyplugin plugin;

    public VoidAvoidance(Lobbyplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getPlayer().getLocation().getBlockY() <= 0) {
            event.getPlayer().teleportAsync(plugin.getServer().getWorld("world").getSpawnLocation());
        }
    }
}
