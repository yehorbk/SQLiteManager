/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitemanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
import sqlitemanager.model.WindowController;

public class SettingsPageController implements Initializable, WindowController {
    
    private Stage stage;
    
    @FXML
    private RadioButton selectDarkTheme;
    @FXML
    private RadioButton selectLightTheme;
    @FXML
    private TextArea exampleTextArea;
    @FXML
    private Slider fontSizeSlider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup toggleGroup = new ToggleGroup();
        selectDarkTheme.setToggleGroup(toggleGroup);
        selectLightTheme.setToggleGroup(toggleGroup);
        selectLightTheme.selectedProperty().set(true);
        
        
        fontSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue <?extends Number> observable, Number oldValue, Number newValue) 
            {
                exampleTextArea.setStyle("-fx-font-size: " + fontSizeSlider.getValue());
                System.out.println(fontSizeSlider.getValue());
            } 
        }); 
        
    }    

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /*@FXML
    public void newFileOnBtnClick(ActionEvent actionEvent) {
        
    }*/
    
}