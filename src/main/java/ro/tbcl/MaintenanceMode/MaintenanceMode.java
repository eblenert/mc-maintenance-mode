package ro.tbcl.MaintenanceMode;

import org.bukkit.plugin.java.JavaPlugin;

public class MaintenanceMode extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new LoginListener(), this);
        this.getCommand("maintenance").setExecutor(new ToggleMaintenance());
    }

    @Override
    public void onDisable() {
        getLogger().info("Maintenance Mode plugin disabled");
    }
}
