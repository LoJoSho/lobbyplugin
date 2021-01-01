package me.lojosho.lobbyplugin.listeners;

import me.lojosho.lobbyplugin.Lobbyplugin;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerClick implements Listener {

    public PlayerClick(Lobbyplugin plugin) {
    }

    @EventHandler
    public void PlayerLClick(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.DURABILITY)) {
            event.getPlayer().performCommand("servers");
        }
    }
}
