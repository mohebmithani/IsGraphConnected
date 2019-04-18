/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author moheb
 */
public class IsGraphConnected extends Application {
    
    public static Boolean isSplashLoaded = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Is Graph Connected? - Moheb");
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
