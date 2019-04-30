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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sqlitemanager.localStorage;
import sqlitemanager.model.Settings;
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
    @FXML
    private ComboBox fontStyleComboBox;
    
    private Double fontSize;
    private String fontStyle;
    private String theme;

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
                fontSize = fontSizeSlider.getValue();
            } 
        }); 
        
        
        fontStyleComboBox.setItems(FXCollections.observableArrayList("Regular", "Bold", "Italic"));
        fontStyleComboBox.getSelectionModel().select("Regular");
        fontStyleComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                switch ((String)newValue) {
                    case "Bold":
                        exampleTextArea.setStyle("-fx-font-weight: bold");
                        fontStyle = "Bold";
                        break;
                    case "Italic":
                        exampleTextArea.setStyle("-fx-font-style: italic");
                        fontStyle = "Italic";
                        break;    
                    default:
                        exampleTextArea.setStyle("-fx-font-weight: regular");
                        fontStyle = "Regular";
                }
            }
        });
        
    }    

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    public void selectDarkThemeAction(ActionEvent actionEvent) {
        this.theme = "Dark";
        System.out.println("Dark");
    }
    
    @FXML
    public void selectLightThemeAction(ActionEvent actionEvent) {
        this.theme = "Light";
        System.out.println("Light");
    }
    
    @FXML
    public void applyChanges(ActionEvent actionEvent) {
        Settings programSettings = localStorage.getProgramSettings();
        programSettings.setFontSize(fontSize);
        programSettings.setFontStyle(fontStyle);
        programSettings.setTheme(theme);
        //localStorage.setProgramSettings(programSettings);
        this.stage.close();
    }
    
    @FXML
    public void cancelChanges(ActionEvent actionEvent) {
        this.stage.close();
    }
    
}