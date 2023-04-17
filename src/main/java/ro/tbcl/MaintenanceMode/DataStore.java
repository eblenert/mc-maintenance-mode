package ro.tbcl.MaintenanceMode;

public class DataStore {
    private static DataStore dataStore = null;
    public boolean maintenanceActive;


    private DataStore()
    {
        maintenanceActive = false;
    }
    public static DataStore getInstance()
    {
        if (dataStore == null) {
            dataStore = new DataStore();
        }
        return dataStore;
    }

    public void toggleMaintenance() {
        maintenanceActive = !maintenanceActive;
    }
}
