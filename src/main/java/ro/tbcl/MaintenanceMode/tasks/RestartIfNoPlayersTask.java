package ro.tbcl.MaintenanceMode.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import ro.tbcl.MaintenanceMode.DataStore;
import ro.tbcl.MaintenanceMode.MaintenanceMode;

public class RestartIfNoPlayersTask extends BukkitRunnable {

    private final MaintenanceMode plugin;
    private final DataStore dataStore;
    public RestartIfNoPlayersTask(MaintenanceMode plugin) {
        this.plugin = plugin;
        this.dataStore = DataStore.getInstance();
    }

    @Override
    public void run() {
        if (dataStore.maintenanceActive && plugin.getServer().getOnlinePlayers().isEmpty()) {
            plugin.getServer().getConsoleSender().sendMessage("Server is empty. Restarting ...");
            plugin.getServer().spigot().restart();
        }
    }
}
