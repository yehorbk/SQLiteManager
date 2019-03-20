
package sqlitemanager.model;

import java.io.File;
import sqlitemanager.DatabaseReference;

public class Database {

    private String name;
    private DatabaseReference databaseReference;
    
    public Database(String name) {
        this.name = name;
        databaseReference = new DatabaseReference(name);
    }
    
    public Database(File file) {
        this.name = file.getName();
        databaseReference = new DatabaseReference(file);
    }

    public String getName() {
        return name;
    }
   
}
