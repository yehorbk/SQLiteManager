
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
    
    private Settings settings;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ToggleGroup toggleGroup = new ToggleGroup();
        selectDarkTheme.setToggleGroup(toggleGroup);
        selectLightTheme.setToggleGroup(toggleGroup);
        selectLightTheme.selectedProperty().set(true);
        
        settings = new Settings();
        settings.setFontSize(localStorage.getProgramSettings().getFontSize());
        settings.setFontStyle(localStorage.getProgramSettings().getFontStyle());
        settings.setTheme(localStorage.getProgramSettings().getTheme());
        
        System.out.println(settings.getTheme());
        System.out.println(settings.getFontStyle());
        
        setStyle();
        
        
        fontSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue <?extends Number> observable, Number oldValue, Number newValue) 
            {
                settings.setFontSize(fontSizeSlider.getValue());
                setStyle();
            } 
        }); 
        
        
        fontStyleComboBox.setItems(FXCollections.observableArrayList("Regular", "Bold"));
        fontStyleComboBox.getSelectionModel().select("Regular");
        fontStyleComboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                switch ((String)newValue) {
                    case "Bold":
                        settings.setFontStyle("bold");
                        setStyle();
                        break;
                    default:
                        settings.setFontStyle("regular");
                        setStyle();
                }
            }
        });
        
        switch(settings.getTheme()) {
            case "Dark":
                selectDarkTheme.selectedProperty().set(true);
                break;
            case "Light":
                selectLightTheme.selectedProperty().set(true);
                break;
        }
        
        switch(settings.getFontStyle()) {
            case "regular": 
               fontStyleComboBox.getSelectionModel().select("Regular");
               break;
            case "bold":
               fontStyleComboBox.getSelectionModel().select("Bold");
               break;
        }
        
        fontSizeSlider.setValue(settings.getFontSize());
        
    }

    private void setStyle() {
        exampleTextArea.setStyle("-fx-font-size: " + settings.getFontSize() + "; " +
                "-fx-font-weight: " + settings.getFontStyle() + "; ");
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    public void selectDarkThemeAction(ActionEvent actionEvent) {
        settings.setTheme("Dark");
    }
    
    @FXML
    public void selectLightThemeAction(ActionEvent actionEvent) {
        settings.setTheme("Light");
    }
    
    @FXML
    public void applyChanges(ActionEvent actionEvent) {
        localStorage.setProgramSettings(settings);
        localStorage.exportSettings();
        this.stage.close();
    }
    
    @FXML
    public void cancelChanges(ActionEvent actionEvent) {
        this.stage.close();
    }
    
}