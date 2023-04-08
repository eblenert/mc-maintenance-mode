package ro.tbcl.MaintenanceMode;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Bukkit.broadcastMessage("Player joined");
        Bukkit.broadcastMessage(String.format("Plugin is %1$s", ToggleMaintenance.getStatus()));
    }
}
