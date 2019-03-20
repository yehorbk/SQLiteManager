
package sqlitemanager.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindowController implements Initializable {
    
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }


    ////////////////////////////// Methods //////////////////////////////
    
    @FXML
    public void newFileOnBtnClick(ActionEvent actionEvent) {
        
        System.out.println("Clicked!");
        System.out.println(actionEvent);
        
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(sqlitemanager.SQLiteManager.class.getResource("ui/NewFileDialog.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setFullScreenExitHint("");

            stage.setTitle("New File");
            stage.setScene(scene);  
            stage.show();
        
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    @FXML
    public void exitOnBtnClick(ActionEvent actionEvent) {
        System.exit(0);
    }
    
    
    
}
