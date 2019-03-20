
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
    
    
}
