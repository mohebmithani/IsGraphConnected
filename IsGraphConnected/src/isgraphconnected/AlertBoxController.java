package isgraphconnected;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moheb
 */
public class AlertBoxController implements Initializable {

    static String message;
    static String title;
    
    @FXML
    private Label heading;

    @FXML
    private Label body;

    @FXML
    private JFXButton button;
    
    @FXML
    private VBox root;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heading.setText(title);
        body.setText(message);
    }   
    
    

    @FXML
    private void close(ActionEvent event) 
    {
        root.getScene().getWindow().hide();
    } 
}
