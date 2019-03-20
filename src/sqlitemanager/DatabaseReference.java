
package sqlitemanager;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseReference {
    
    private StringBuilder url = new StringBuilder("jdbc:sqlite:");

    public DatabaseReference(String name) {
        this.url.append(name + ".db");
        
        try {   
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url.toString());
            System.out.println("Connected!");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e ){
            System.out.println(e);
        }
    }
    
    public DatabaseReference(File file) {
        this.url.append(file.getName());
        try {   
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url.toString());
            System.out.println("Connected!");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e ){
            System.out.println(e);
        }
    }
    
    
}
