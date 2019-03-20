
package sqlitemanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sqlitemanager.model.WindowController;

public class NewFileDialogController implements Initializable, WindowController {

    @FXML
    TextField dbNameTextField;
    
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void okOnBtnClick(ActionEvent actionEvent) {
        System.out.println(dbNameTextField.getText());
        this.stage.close();
    }
    
    @FXML
    public void cancelOnBtnClick(ActionEvent actionEvent) {
        this.stage.close();
    }
    
    
    
}
