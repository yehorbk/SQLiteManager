
package sqlitemanager;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sqlitemanager.controller.MainWindowController;


public class SQLiteManager extends Application {
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            
        this.primaryStage = primaryStage;
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("ui/MainWindow.fxml"));
        Parent root = loader.load();
        MainWindowController controller = loader.getController();
        
        controller.setStage(primaryStage);
        Scene scene = new Scene(root);
        
        scene.getStylesheets().clear();
        scene.getStylesheets().add(this.getClass().getResource("style/mainwindow.css").toExternalForm());
        
        primaryStage.setTitle("SQLite Manager");
        primaryStage.setScene(scene);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
        
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
