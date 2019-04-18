/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author moheb
 */

public class InsertEdgesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane root;
    
    @FXML
    private JFXTextField v2;

    @FXML
    private JFXTextField v1;
    
   public static  String[] vertex;
    @FXML
    private JFXButton button;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vertex = new String[2];
    }    
    
    @FXML
    void insert(ActionEvent event) throws IOException {
        vertex[0] = v1.getText();
        vertex[1] = v2.getText();
        root.getScene().getWindow().hide();
    }
    
    public String[] getVertices(){
        return vertex;
    }
}
