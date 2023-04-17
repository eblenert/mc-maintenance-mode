package ro.tbcl.MaintenanceMode.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import ro.tbcl.MaintenanceMode.MaintenanceMode;

public class SendMessageToPlayersTask extends BukkitRunnable {
    private final MaintenanceMode plugin;

    public SendMessageToPlayersTask(MaintenanceMode plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        plugin.getServer().broadcastMessage("Server is under maintenance. Please leave at your earliest convenience. When server is empty it will restart.");
    }
}
