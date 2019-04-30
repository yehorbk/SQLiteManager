
package sqlitemanager.model;

import java.io.File;
import java.util.ArrayList;
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
    
    public void executeCommand(String command) {
        this.databaseReference.execute(command);
    }
    
    public String getTablesData() {
        ArrayList<String> tables = databaseReference.getTables();
        StringBuilder data = new StringBuilder("");
        System.out.println(tables.size());
        for (String table : tables) {
            System.out.println(table);
            data.append(table + ": ");
            data.append(getDataByTableName(table));
            data.append("; \n");
        }
        return data.toString();
    }
    
    private String getDataByTableName(String tableName) {
        return databaseReference.getTableData(tableName).toString();
    }
}
