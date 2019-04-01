/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitemanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import sqlitemanager.model.WindowController;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DonatePageController implements Initializable, WindowController {
    
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }  
    
    @FXML
    public void copyToBuffer(ActionEvent actionEvent) {
        String cardNumber = "1234567891234567";
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(cardNumber);
        clipboard.setContent(content);
    }
    
}
