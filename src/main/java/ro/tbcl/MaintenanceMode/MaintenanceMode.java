package ro.tbcl.MaintenanceMode;

import org.bukkit.plugin.java.JavaPlugin;

public class MaintenanceMode extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AuthListener(this), this);
        this.getCommand("maintenance").setExecutor(new ToggleMaintenance(this));
    }

    @Override
    public void onDisable() {
    }
}
