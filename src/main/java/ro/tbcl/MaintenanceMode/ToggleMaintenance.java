package ro.tbcl.MaintenanceMode;

import org.bukkit.command.*;
import org.bukkit.scheduler.BukkitTask;
import ro.tbcl.MaintenanceMode.tasks.RestartIfNoPlayersTask;
import ro.tbcl.MaintenanceMode.tasks.SendMessageToPlayersTask;

import static org.bukkit.Bukkit.getServer;

public class ToggleMaintenance implements CommandExecutor {

    private final MaintenanceMode plugin;
    DataStore dataStore;

    ToggleMaintenance(MaintenanceMode plugin) {
        this.plugin = plugin;
        this.dataStore = DataStore.getInstance();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        dataStore.toggleMaintenance();

        if (dataStore.maintenanceActive) {
            getServer().getConsoleSender().sendMessage("Activated maintenance mode");
        } else {

            getServer().getConsoleSender().sendMessage("Disabled maintenance mode");
        }

        new RestartIfNoPlayersTask(plugin).runTask(plugin);
        new SendMessageToPlayersTask(plugin).runTaskTimer(plugin, 20L, 20L * 60L * 5L);
        return true;
    }
}
