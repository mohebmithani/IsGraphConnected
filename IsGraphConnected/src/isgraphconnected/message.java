package isgraphconnected;


import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moheb
 */
public class message {
    public static void display(String title, String message) throws IOException
    {
        AlertBoxController.message = message;
        AlertBoxController.title = title;
        Stage stage = new Stage();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.setTitle("Error!");
        Parent root = FXMLLoader.load(isgraphconnected.AlertBoxController.class.getResource("AlertBox.fxml"));
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    public static void edgePane() throws IOException
    {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Parent root1 = FXMLLoader.load(isgraphconnected.InsertEdgesController.class.getResource("InsertEdges.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
