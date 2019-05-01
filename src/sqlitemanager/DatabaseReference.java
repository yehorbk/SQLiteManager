package sqlitemanager;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            int count = columnsCount(tableName);
            ResultSet result = statement.executeQuery("SELECT * FROM " + tableName);
            ArrayList<String> list = new ArrayList<>();
            while (result.next()) {
                String item = "";
                for (int i = 2; i <= count; i++) {
                    item += " " + result.getString(i);
                }
                list.add(item);
            }
            
            // Question
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
    
    private int columnsCount(String tableName) {
        try {
            
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("PRAGMA table_info(" + tableName + ")");
            ArrayList<String> list = new ArrayList<>();
            while (result.next()) {
                list.add("" + result.getString(1));
            }
            return list.size();
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
        }
    }
}
