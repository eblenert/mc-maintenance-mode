package ro.tbcl.MaintenanceMode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import ro.tbcl.MaintenanceMode.tasks.RestartIfNoPlayersTask;

public class AuthListener implements Listener {

    private final MaintenanceMode plugin;

    public AuthListener(MaintenanceMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        new RestartIfNoPlayersTask(plugin).runTask(plugin);
    }
}
