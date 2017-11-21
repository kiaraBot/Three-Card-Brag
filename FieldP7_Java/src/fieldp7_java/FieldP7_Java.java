/**************************************************************************
 * Alix Field           afield@cnm.edu              FieldP7_Java
 * Enigma Program
 * 
 * Program Objective: Encoding & Decoding Strings
 **************************************************************************/
package fieldp7_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FieldP7_Java extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
