package me.lojosho.lobbyplugin.listeners;

import me.lojosho.lobbyplugin.Lobbyplugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Joining implements Listener {

    private final Lobbyplugin plugin;

    public Joining(Lobbyplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Objects.requireNonNull(event.getJoinMessage()).contains("join")) {
            event.setJoinMessage(null);
        }
        //String playerName = event.getPlayer().getDisplayName();
        //if (event.getPlayer().hasPermission("group.donor1")) {
        //    Bukkit.broadcastMessage(playerName + "has joined!");
        //}
        player.getInventory().clear();
        player.getInventory().setItem(4, Navigator());
        // MOTD Handler
        for (String line : plugin.getConfig().getStringList("motdtext")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        }
    }


    public ItemStack Navigator() {
        ItemStack Navi = new ItemStack(Material.COMPASS);
        ItemMeta naviMeta = Navi.getItemMeta();
        naviMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        naviMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        naviMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lServer Navigation"));
        Navi.setItemMeta(naviMeta);
        return Navi;
    }

}
