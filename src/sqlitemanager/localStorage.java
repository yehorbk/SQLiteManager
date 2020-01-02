
package sqlitemanager;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sqlitemanager.model.Database;
import sqlitemanager.model.Settings;

public class localStorage {
    
    private static List<Database> databasesList = new ArrayList<>();
    private static Settings programSettings = new Settings();
    
    public static void putDatabase(Database db) {
        databasesList.add(db);
    }

    public static Settings getProgramSettings() {
        return programSettings;
    }

    public static void setProgramSettings(Settings programSettings) {
        localStorage.programSettings = programSettings;
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
    
    private static void setDefaultSettings() {
        Settings settings = new Settings();
        settings.setFontSize(18.0);
        settings.setFontStyle("regular");
        settings.setTheme("Light");
        localStorage.setProgramSettings(settings);
    }
    
    public static void exportSettings() {
        File settingsFile = new File("settings.json");
        Gson gson = new Gson();
        String jsonObject = gson.toJson(programSettings);
        System.out.println(jsonObject);
        FileWriter fw;
        try {
            fw = new FileWriter(settingsFile);
            fw.write(jsonObject);
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void exportSettings(File file) {
        File settingsFile = file;
        Gson gson = new Gson();
        String jsonObject = gson.toJson(programSettings);
        System.out.println(jsonObject);
        FileWriter fw;
        try {
            fw = new FileWriter(settingsFile);
            fw.write(jsonObject);
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void importSettings() {
        File settingsFile = new File("settings.json");
        String jsonString = "";
        try {
            FileReader fr = new FileReader(settingsFile);
            int line;
            while ((line = fr.read()) != -1) {
                jsonString += (char)line;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            localStorage.setDefaultSettings();
            localStorage.exportSettings();
        }
        Gson gson = new Gson();
        Settings settings = gson.fromJson(jsonString, Settings.class);
        programSettings = settings;
    }
    
    public static void importSettings(File file) {
        File settingsFile = file;
        String jsonString = "";
        try {
            FileReader fr = new FileReader(settingsFile);
            int line;
            while ((line = fr.read()) != -1) {
                jsonString += (char)line;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        Gson gson = new Gson();
        Settings settings = gson.fromJson(jsonString, Settings.class);
        programSettings = settings;
    }
    
}
