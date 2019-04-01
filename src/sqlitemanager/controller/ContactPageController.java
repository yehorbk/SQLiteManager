
package sqlitemanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sqlitemanager.model.WindowController;


public class ContactPageController implements Initializable, WindowController {
    
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }  
    
}
