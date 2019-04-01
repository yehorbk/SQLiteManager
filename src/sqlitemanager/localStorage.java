
package sqlitemanager;

import java.util.ArrayList;
import java.util.List;
import sqlitemanager.model.Database;

public class localStorage {
    
    private static List<Database> databasesList = new ArrayList<>();
    
    
    public static void putDatabase(Database db) {
        databasesList.add(db);
    }

    public static List<Database> getDatabasesList() {
        return databasesList;
    }
    
    public static void removeDatabase(Database db) {
        databasesList.remove(db);
    }
    
    public static Database getDatabaseByName(String name) {
        for (Database database : databasesList) {
            if (database.getName().equals(name)) {
                return database;
            }
        }
        return null;
    }
    
    
}
