
package sqlitemanager.controller;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sqlitemanager.model.WindowController;

public class MainWindowController implements Initializable, WindowController {
    
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    private void openDialogWindow(String url, String title) {
        try {
            
            FXMLLoader loader = new FXMLLoader(sqlitemanager.SQLiteManager.class.getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            WindowController controller = loader.getController();
            controller.setStage(stage);

            stage.setFullScreenExitHint("");
            stage.setTitle(title);
            stage.setScene(scene);  
            stage.show();
        
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    private boolean openFileChooser(String title, ExtensionFilter ...filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(filters);
        fileChooser.getExtensionFilters().add(
            new ExtensionFilter("All Files", "*.*"));
        
        File selectedFile = fileChooser.showOpenDialog(this.stage);
        return selectedFile != null ? true : false;
    }


    ////////////////////////////// FXML METHODS //////////////////////////////
    
    @FXML
    public void newFileOnBtnClick(ActionEvent actionEvent) {
        String url = "ui/NewFileDialog.fxml";
        String title = "New File";
        openDialogWindow(url, title);
    }
    
    @FXML
    public void openFileOnBtnClick(ActionEvent actionEvent) {
        String title = "Open Database";
        ExtensionFilter filter = new ExtensionFilter("Database files", "*.db");
        if (openFileChooser(title, filter)) {
            // TODO
        }
    }
    
    @FXML
    public void importDbOnBtnClick(ActionEvent actionEvent) {
        String title = "Import Database";
        ExtensionFilter filter = new ExtensionFilter("SQL files", "*.sql");
        if (openFileChooser(title, filter)) {
            // TODO
        }
    }
    
    @FXML
    public void exitOnBtnClick(ActionEvent actionEvent) {
        System.exit(0);
    }
    
    @FXML
    public void openCommandLine(ActionEvent actionEvent) {
        try {
            Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void importSettings(ActionEvent actionEvent) {
        String title = "Import Settings";
        ExtensionFilter filter = new ExtensionFilter("JSON files", "*.json");
        if (openFileChooser(title, filter)) {
            // TODO
        }
    }
}
