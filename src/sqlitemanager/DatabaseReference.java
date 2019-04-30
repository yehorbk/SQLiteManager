
package sqlitemanager;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseReference {
    
    private StringBuilder url = new StringBuilder("jdbc:sqlite:");
    private Connection connection;
    
    
    public DatabaseReference(String name) {
        this.url.append(name + ".db");
        
        try {   
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url.toString());
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
            connection = DriverManager.getConnection(url.toString());
            System.out.println("Connected!");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e ){
            System.out.println(e);
        }
    }
    
    public void execute(String command) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(command);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ArrayList<String> getTableData(String tableName) {
        
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM " + tableName);
            ArrayList<String> list = new ArrayList<>();
            while (result.next()) {
                list.add("" + result.getString(2) + " " + result.getInt(3));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
    }
    
    public ArrayList<String> getTables() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
            ArrayList<String> list = new ArrayList<>();
            while (result.next()) {
                list.add("" + result.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
