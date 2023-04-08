package ro.tbcl.MaintenanceMode;

import org.bukkit.command.*;

import static org.bukkit.Bukkit.getServer;

public class ToggleMaintenance implements CommandExecutor {
    private static boolean isArmed = false;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        getServer().getConsoleSender().sendMessage("Called on command");
        getServer().getConsoleSender().sendMessage(String.format("Is console %b", sender instanceof ConsoleCommandSender));
        getServer().getConsoleSender().sendMessage(String.format("Is proxied %b", sender instanceof ProxiedCommandSender));
        if (!(sender instanceof ConsoleCommandSender) || !(sender instanceof ProxiedCommandSender)) {
            return false;
        }
        isArmed = !isArmed;

        return true;
    }

    public static boolean getStatus() {
        return isArmed;
    }
}
