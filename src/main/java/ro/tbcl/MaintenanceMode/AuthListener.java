package ro.tbcl.MaintenanceMode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ro.tbcl.MaintenanceMode.tasks.RestartIfNoPlayersTask;

public class AuthListener implements Listener {

    private MaintenanceMode plugin;
    private DataStore dataStore;

    public AuthListener(MaintenanceMode plugin) {
        this.plugin = plugin;
        this.dataStore = DataStore.getInstance();
    }
    @EventHandler
    public void onPlayerLogin(AsyncPlayerPreLoginEvent event) {
        if (dataStore.maintenanceActive) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,"Server is on maintenance mode");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        new RestartIfNoPlayersTask(plugin).runTask(plugin);
    }
}
