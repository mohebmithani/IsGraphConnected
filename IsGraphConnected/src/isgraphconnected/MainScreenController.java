/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import static com.sun.deploy.util.ReflectionUtil.getClass;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;



/**
 *
 * @author moheb
 */
public class MainScreenController implements Initializable {
    
    @FXML
    public AnchorPane root;
    
   @FXML
    private JFXButton addNode;

    @FXML
    private JFXButton addEdge;

    @FXML
    private JFXButton reset;

    @FXML
    private JFXButton exit;
    
    @FXML
    private JFXButton proceed;

    @FXML
    private JFXButton b1;

    @FXML
    private JFXButton b2;

    @FXML
    private JFXButton b3;

    @FXML
    private JFXButton b4;

    @FXML
    private JFXButton b5;

    @FXML
    private Line l12;

    @FXML
    private Line l15;

    @FXML
    private Line l25;

    @FXML
    private Line l13;

    @FXML
    private Line l14;

    @FXML
    private Line l24;

    @FXML
    private Line l23;

    @FXML
    private Line l45;

    @FXML
    private Line l35;

    @FXML
    private Line l34;

    
    
    String[] c = new String[2];
    
    FSM[] fsm = new FSM[2];
    ArrayList<Transitions>[] tt1 = (ArrayList<Transitions>[])new ArrayList[29]; //transition table for 1st finite state machine. it comprise of 29 states.
    ArrayList<Transitions>[] tt2 = (ArrayList<Transitions>[])new ArrayList[3]; //transition table for 2nd finite state machine. it comprise of 3 states.
    NodeTape nodeTape = new NodeTape();
    EdgeTape edgeTape = new EdgeTape();
    
  
    int n = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
          if (!IsGraphConnected.isSplashLoaded) {
            loadSplashScreen();
        }
        
        
        for (int i = 0; i < 29; i++) 
        {
            tt1[i] = new ArrayList<>();
        }
        
        /*********************************Start of 1st Transition Table***************************************/
        //transitions in 0th state
        tt1[0].add(new Transitions(1, new int[]{-1,1,2}, new int[]{-1,1,2}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,1,3}, new int[]{-1,1,3}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,1,4}, new int[]{-1,1,4}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,1,5}, new int[]{-1,1,5}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,2,3}, new int[]{-1,2,3}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,2,4}, new int[]{-1,2,4}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,2,5}, new int[]{-1,2,5}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,3,4}, new int[]{-1,3,4}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,3,5}, new int[]{-1,3,5}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(1, new int[]{-1,4,5}, new int[]{-1,4,5}, new char[]{'r','n'}));
        tt1[0].add(new Transitions(28, new int[]{-1,-77,-77}, new int[]{-1,-77,-77}, new char[]{'n','n'}));
        
        //transitions in 1st state
        tt1[1].add(new Transitions(1, new int[]{2,1,3}, new int[]{2,1,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{2,1,4}, new int[]{2,1,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{2,1,5}, new int[]{2,1,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{2,3,4}, new int[]{2,3,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{2,3,5}, new int[]{2,3,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{2,4,5}, new int[]{2,4,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{-2,1,2}, new int[]{-2,1,2}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,1,3}, new int[]{-2,1,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,1,4}, new int[]{-2,1,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,1,5}, new int[]{-2,1,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,2,3}, new int[]{-2,2,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,2,4}, new int[]{-2,2,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,2,5}, new int[]{-2,2,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,3,4}, new int[]{-2,3,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,3,5}, new int[]{-2,3,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-2,4,5}, new int[]{-2,4,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{3,1,2}, new int[]{3,1,2}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{3,1,4}, new int[]{3,1,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{3,1,5}, new int[]{3,1,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{3,4,5}, new int[]{3,4,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{-3,1,2}, new int[]{-3,1,2}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,1,3}, new int[]{-3,1,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,1,4}, new int[]{-3,1,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,1,5}, new int[]{-3,1,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,2,3}, new int[]{-3,2,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,3,4}, new int[]{-3,3,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-3,3,5}, new int[]{-3,3,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{4,1,2}, new int[]{4,1,2}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{4,1,3}, new int[]{4,1,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{4,1,5}, new int[]{4,1,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{4,2,3}, new int[]{4,2,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{-4,1,2}, new int[]{-4,1,2}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,1,3}, new int[]{-4,1,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,1,4}, new int[]{-4,1,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,1,5}, new int[]{-4,1,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,2,3}, new int[]{-4,2,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,2,4}, new int[]{-4,2,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,3,4}, new int[]{-4,3,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{5,1,2}, new int[]{5,1,2}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{5,1,3}, new int[]{5,1,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{5,1,4}, new int[]{5,1,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{5,2,3}, new int[]{5,2,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{5,2,4}, new int[]{5,2,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{5,3,4}, new int[]{5,3,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(1, new int[]{-5,1,2}, new int[]{-5,1,2}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,1,3}, new int[]{-5,1,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,1,4}, new int[]{-5,1,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,1,5}, new int[]{-5,1,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,2,3}, new int[]{-5,2,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,2,4}, new int[]{-5,2,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,2,5}, new int[]{-5,2,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,3,4}, new int[]{-5,3,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(1, new int[]{-5,3,5}, new int[]{-5,3,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(2, new int[]{2,2,3}, new int[]{2,2,3}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(2, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'l','n'}));
        tt1[1].add(new Transitions(2, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(2, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'l','n'}));
        tt1[1].add(new Transitions(2, new int[]{4,4,5}, new int[]{4,4,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(2, new int[]{5,4,5}, new int[]{5,4,5}, new char[]{'l','n'}));
        tt1[1].add(new Transitions(3, new int[]{2,2,4}, new int[]{2,2,4}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(3, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(3, new int[]{2,2,5}, new int[]{2,2,5}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(4, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'l','n'}));
        tt1[1].add(new Transitions(4, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'l','n'}));
        tt1[1].add(new Transitions(4, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'l','n'}));
        tt1[1].add(new Transitions(17, new int[]{2,-77,-77}, new int[]{2,-77,-77}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(17, new int[]{3,-77,-77}, new int[]{3,-77,-77}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(17, new int[]{4,-77,-77}, new int[]{4,-77,-77}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(17, new int[]{5,-77,-77}, new int[]{5,-77,-77}, new char[]{'r','n'}));
        tt1[1].add(new Transitions(18, new int[]{2,1,2}, new int[]{2,1,2}, new char[]{'n','n'}));
        tt1[1].add(new Transitions(18, new int[]{3,1,3}, new int[]{3,1,3}, new char[]{'n','n'}));
        tt1[1].add(new Transitions(18, new int[]{4,1,4}, new int[]{4,1,4}, new char[]{'n','n'}));
        tt1[1].add(new Transitions(18, new int[]{5,1,5}, new int[]{5,1,5}, new char[]{'n','n'}));
        tt1[1].add(new Transitions(23, new int[]{-99,1,2}, new int[]{-99,1,2}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,1,3}, new int[]{-99,1,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,1,4}, new int[]{-99,1,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,1,5}, new int[]{-99,1,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,2,3}, new int[]{-99,2,3}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,2,4}, new int[]{-99,2,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,2,5}, new int[]{-99,2,5}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,3,4}, new int[]{-99,3,4}, new char[]{'n','r'}));
        tt1[1].add(new Transitions(23, new int[]{-99,4,5}, new int[]{-99,4,5}, new char[]{'n','r'}));
        
        //transitions in 2nd state
        tt1[2].add(new Transitions(1, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'l','r'}));
        tt1[2].add(new Transitions(1, new int[]{2,2,3}, new int[]{2,2,3}, new char[]{'r','r'}));
        tt1[2].add(new Transitions(1, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'l','r'}));
        tt1[2].add(new Transitions(1, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'r','r'}));
        tt1[2].add(new Transitions(1, new int[]{5,4,5}, new int[]{5,4,5}, new char[]{'l','r'}));
        tt1[2].add(new Transitions(1, new int[]{4,4,5}, new int[]{4,4,5}, new char[]{'r','r'}));
        tt1[2].add(new Transitions(18, new int[]{-2,2,3}, new int[]{-2,2,3}, new char[]{'r','n'}));
        tt1[2].add(new Transitions(18, new int[]{-3,2,3}, new int[]{-3,2,3}, new char[]{'l','n'}));
        tt1[2].add(new Transitions(18, new int[]{-4,3,4}, new int[]{-4,3,4}, new char[]{'l','n'}));
        tt1[2].add(new Transitions(18, new int[]{-3,3,4}, new int[]{-3,3,4}, new char[]{'r','n'}));
        tt1[2].add(new Transitions(18, new int[]{-5,4,5}, new int[]{-5,4,5}, new char[]{'l','n'}));
        tt1[2].add(new Transitions(18, new int[]{-4,4,5}, new int[]{-4,4,5}, new char[]{'r','n'}));
        
        //transitions in 3th state
        tt1[3].add(new Transitions(5, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'r','n'}));
        tt1[3].add(new Transitions(5, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'r','n'}));
        tt1[3].add(new Transitions(5, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'r','n'}));
        tt1[3].add(new Transitions(5, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'r','n'}));
        tt1[3].add(new Transitions(5, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'r','n'}));
        tt1[3].add(new Transitions(5, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'r','n'}));
        
        //transitions in 4th state
        tt1[4].add(new Transitions(6, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'l','n'}));
        tt1[4].add(new Transitions(6, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'l','n'}));
        tt1[4].add(new Transitions(6, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'l','n'}));
        tt1[4].add(new Transitions(6, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'l','n'}));
        tt1[4].add(new Transitions(6, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'l','n'}));
        tt1[4].add(new Transitions(6, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'l','n'}));
        
        //transitions in 5th state
        tt1[5].add(new Transitions(7, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'r','n'}));
        tt1[5].add(new Transitions(7, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'r','n'}));
        tt1[5].add(new Transitions(9, new int[]{-4,2,4}, new int[]{-4,2,4}, new char[]{'l','n'}));
        tt1[5].add(new Transitions(9, new int[]{-5,3,5}, new int[]{-5,3,5}, new char[]{'l','n'}));
        tt1[5].add(new Transitions(15, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'l','n'}));
        tt1[5].add(new Transitions(15, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'l','n'}));
        
        //transitions in 6th state
        tt1[6].add(new Transitions(8, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'l','n'}));
        tt1[6].add(new Transitions(8, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'l','n'}));
        tt1[6].add(new Transitions(10, new int[]{-2,2,4}, new int[]{-2,2,4}, new char[]{'r','n'}));
        tt1[6].add(new Transitions(10, new int[]{-3,3,5}, new int[]{-3,3,5}, new char[]{'r','n'}));
        tt1[6].add(new Transitions(16, new int[]{2,2,4}, new int[]{2,2,4}, new char[]{'r','n'}));
        tt1[6].add(new Transitions(16, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'r','n'}));
        
        //transitions in 7th state
        tt1[7].add(new Transitions(11, new int[]{-5,2,5}, new int[]{-5,2,5}, new char[]{'l','n'}));
        tt1[7].add(new Transitions(13, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'l','n'}));
        
        //transitions in 8th state
        tt1[8].add(new Transitions(12, new int[]{-2,2,5}, new int[]{-2,2,5}, new char[]{'r','n'}));
        tt1[8].add(new Transitions(14, new int[]{2,2,5}, new int[]{2,2,5}, new char[]{'r','n'}));
        
        //transitions in 9th state
        tt1[9].add(new Transitions(18, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'l','n'}));
        tt1[9].add(new Transitions(18, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'l','n'}));
        tt1[9].add(new Transitions(18, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'l','n'}));
        tt1[9].add(new Transitions(18, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'l','n'}));
        tt1[9].add(new Transitions(18, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'l','n'}));
        tt1[9].add(new Transitions(18, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'l','n'}));
        
        //transitions in 10th state
        tt1[10].add(new Transitions(18, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'r','n'}));
        tt1[10].add(new Transitions(18, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'r','n'}));
        tt1[10].add(new Transitions(18, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'r','n'}));
        tt1[10].add(new Transitions(18, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'r','n'}));
        tt1[10].add(new Transitions(18, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'r','n'}));
        tt1[10].add(new Transitions(18, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'r','n'}));
        
        //transitions in 11th state
        tt1[11].add(new Transitions(9, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'l','n'}));
        tt1[11].add(new Transitions(9, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'l','n'}));
        
        //transitions in 12th state
        tt1[12].add(new Transitions(10, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'r','n'}));
        tt1[12].add(new Transitions(10, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'r','n'}));
        
        //transitions in 13th state
        tt1[13].add(new Transitions(15, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'l','n'}));
        tt1[13].add(new Transitions(15, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'l','n'}));
        
        //transitions in 14th state
        tt1[14].add(new Transitions(16, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'r','n'}));
        tt1[14].add(new Transitions(16, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'r','n'}));
        
        //transitions in 15th state
        tt1[15].add(new Transitions(1, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'l','r'}));
        tt1[15].add(new Transitions(1, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'l','r'}));
        tt1[15].add(new Transitions(1, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'l','r'}));
        tt1[15].add(new Transitions(1, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'l','r'}));
        tt1[15].add(new Transitions(1, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'l','r'}));
        tt1[15].add(new Transitions(1, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'l','r'}));
        
        //transitions in 16th state
        tt1[16].add(new Transitions(1, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'r','r'}));
        tt1[16].add(new Transitions(1, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'r','r'}));
        tt1[16].add(new Transitions(1, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'r','r'}));
        tt1[16].add(new Transitions(1, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'r','r'}));
        tt1[16].add(new Transitions(1, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'r','r'}));
        tt1[16].add(new Transitions(1, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'r','r'}));
        
        //transitions in 17th state
        tt1[17].add(new Transitions(17, new int[]{3,1,2}, new int[]{3,1,2}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,1,3}, new int[]{3,1,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,1,4}, new int[]{3,1,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,1,5}, new int[]{3,1,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,4,5}, new int[]{3,4,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{3,-77,-77}, new int[]{3,-77,-77}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,1,2}, new int[]{-3,1,2}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,1,3}, new int[]{-3,1,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,1,4}, new int[]{-3,1,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,1,5}, new int[]{-3,1,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,2,3}, new int[]{-3,2,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,3,4}, new int[]{-3,3,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,3,5}, new int[]{-3,3,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,4,5}, new int[]{-3,4,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-3,-77,-77}, new int[]{-3,-77,-77}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,1,2}, new int[]{4,1,2}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,1,3}, new int[]{4,1,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,1,4}, new int[]{4,1,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,1,5}, new int[]{4,1,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,2,3}, new int[]{4,2,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,4,5}, new int[]{4,4,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{4,-77,-77}, new int[]{4,-77,-77}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,1,2}, new int[]{-4,1,2}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,1,3}, new int[]{-4,1,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,1,4}, new int[]{-4,1,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,1,5}, new int[]{-4,1,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,2,3}, new int[]{-4,2,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,2,4}, new int[]{-4,2,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,3,4}, new int[]{-4,3,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,4,5}, new int[]{-4,4,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-4,-77,-77}, new int[]{-4,-77,-77}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,1,2}, new int[]{5,1,2}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,1,3}, new int[]{5,1,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,1,4}, new int[]{5,1,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,1,5}, new int[]{5,1,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,2,3}, new int[]{5,2,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,2,4}, new int[]{5,2,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,3,4}, new int[]{5,3,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,4,5}, new int[]{5,4,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{5,-77,-77}, new int[]{5,-77,-77}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,1,2}, new int[]{-5,1,2}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,1,3}, new int[]{-5,1,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,1,4}, new int[]{-5,1,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,1,5}, new int[]{-5,1,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,2,3}, new int[]{-5,2,3}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,2,4}, new int[]{-5,2,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,2,5}, new int[]{-5,2,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,3,4}, new int[]{-5,3,4}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,3,5}, new int[]{-5,3,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,4,5}, new int[]{-5,4,5}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(17, new int[]{-5,-77,-77}, new int[]{-5,-77,-77}, new char[]{'n','l'}));
        tt1[17].add(new Transitions(24, new int[]{-99,-77,-77}, new int[]{-99,-77,-77}, new char[]{'n','r'}));
        tt1[17].add(new Transitions(1, new int[]{3,-88,-88}, new int[]{3,-88,-88}, new char[]{'n','r'}));
        tt1[17].add(new Transitions(1, new int[]{-3,-88,-88}, new int[]{-3,-88,-88}, new char[]{'n','r'}));
        tt1[17].add(new Transitions(1, new int[]{4,-88,-88}, new int[]{4,-88,-88}, new char[]{'n','r'}));
        tt1[17].add(new Transitions(1, new int[]{-4,-88,-88}, new int[]{-4,-88,-88}, new char[]{'n','r'}));
        tt1[17].add(new Transitions(1, new int[]{5,-88,-88}, new int[]{5,-88,-88}, new char[]{'n','r'}));
        tt1[17].add(new Transitions(1, new int[]{-5,-88,-88}, new int[]{-5,-88,-88}, new char[]{'n','r'}));
        
        //transitions in 18th state
        tt1[18].add(new Transitions(19, new int[]{2,1,2}, new int[]{-2,1,2}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{2,2,3}, new int[]{-2,2,3}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{2,2,4}, new int[]{-2,2,4}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{2,2,5}, new int[]{-2,2,5}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{3,1,3}, new int[]{-3,1,3}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{3,2,3}, new int[]{-3,2,3}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{3,3,4}, new int[]{-3,3,4}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{3,3,5}, new int[]{-3,3,5}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{4,1,4}, new int[]{-4,1,4}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{4,2,4}, new int[]{-4,2,4}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{4,3,4}, new int[]{-4,3,4}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{4,4,5}, new int[]{-4,4,5}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{5,1,5}, new int[]{-5,4,5}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{5,2,5}, new int[]{-5,4,5}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{5,3,5}, new int[]{-5,4,5}, new char[]{'r','r'}));
        tt1[18].add(new Transitions(19, new int[]{5,4,5}, new int[]{-5,4,5}, new char[]{'r','r'}));
        
        //transitions in 19th state
        tt1[19].add(new Transitions(19, new int[]{3,1,2}, new int[]{3,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,1,3}, new int[]{3,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,1,4}, new int[]{3,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,1,5}, new int[]{3,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{3,4,5}, new int[]{3,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,1,2}, new int[]{-3,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,1,3}, new int[]{-3,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,1,4}, new int[]{-3,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,1,5}, new int[]{-3,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,2,3}, new int[]{-3,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,3,4}, new int[]{-3,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,3,5}, new int[]{-3,3,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-3,4,5}, new int[]{-3,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,1,2}, new int[]{4,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,1,3}, new int[]{4,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,1,4}, new int[]{4,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,1,5}, new int[]{4,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,2,3}, new int[]{4,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{4,4,5}, new int[]{4,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,1,2}, new int[]{-4,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,1,3}, new int[]{-4,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,1,4}, new int[]{-4,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,1,5}, new int[]{-4,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,2,3}, new int[]{-4,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,2,4}, new int[]{-4,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,3,4}, new int[]{-4,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,4,5}, new int[]{-4,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,5,5}, new int[]{-4,5,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,1,2}, new int[]{5,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,1,3}, new int[]{5,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,1,4}, new int[]{5,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,1,5}, new int[]{5,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,2,3}, new int[]{5,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,2,4}, new int[]{5,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,3,4}, new int[]{5,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{5,4,5}, new int[]{5,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,1,2}, new int[]{-5,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,1,3}, new int[]{-5,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,1,4}, new int[]{-5,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,1,5}, new int[]{-5,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,2,3}, new int[]{-5,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,2,4}, new int[]{-5,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,2,5}, new int[]{-5,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,3,4}, new int[]{-5,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-5,4,5}, new int[]{-5,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-4,5,5}, new int[]{-4,5,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,1,2}, new int[]{-99,1,2}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,1,3}, new int[]{-99,1,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,1,4}, new int[]{-99,1,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,1,5}, new int[]{-99,1,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,2,3}, new int[]{-99,2,3}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,2,4}, new int[]{-99,2,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,2,5}, new int[]{-99,2,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,3,4}, new int[]{-99,3,4}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,3,5}, new int[]{-99,3,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(19, new int[]{-99,4,5}, new int[]{-99,4,5}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{3,-77,-77}, new int[]{3,-77,-77}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{-3,-77,-77}, new int[]{-3,-77,-77}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{4,-77,-77}, new int[]{4,-77,-77}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{-4,-77,-77}, new int[]{-4,-77,-77}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{5,-77,-77}, new int[]{5,-77,-77}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{-5,-77,-77}, new int[]{-5,-77,-77}, new char[]{'n','r'}));
        tt1[19].add(new Transitions(20, new int[]{-99,-77,-77}, new int[]{-99,-77,-77}, new char[]{'n','r'}));
        
        //transitions in 20th state
        tt1[20].add(new Transitions(21, new int[]{3,0,0}, new int[]{3,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-3,0,0}, new int[]{-3,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{3,1,1}, new int[]{3,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-3,1,1}, new int[]{-3,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{4,0,0}, new int[]{4,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-4,0,0}, new int[]{-4,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{4,1,1}, new int[]{4,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-4,1,1}, new int[]{-4,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{5,0,0}, new int[]{5,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-5,0,0}, new int[]{-5,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{5,1,1}, new int[]{5,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-5,1,1}, new int[]{-5,1,1}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-99,0,0}, new int[]{-99,0,0}, new char[]{'n','l'}));
        tt1[20].add(new Transitions(21, new int[]{-99,1,1}, new int[]{-99,0,0}, new char[]{'n','l'}));
        
        //transitions in 21st state
        tt1[21].add(new Transitions(1, new int[]{3,-88,-88}, new int[]{3,-88,-88}, new char[]{'n','r'}));
        tt1[21].add(new Transitions(1, new int[]{-3,-88,-88}, new int[]{-3,-88,-88}, new char[]{'n','r'}));
        tt1[21].add(new Transitions(1, new int[]{4,-88,-88}, new int[]{4,-88,-88}, new char[]{'n','r'}));
        tt1[21].add(new Transitions(1, new int[]{-4,-88,-88}, new int[]{-4,-88,-88}, new char[]{'n','r'}));
        tt1[21].add(new Transitions(1, new int[]{5,-88,-88}, new int[]{5,-88,-88}, new char[]{'n','r'}));
        tt1[21].add(new Transitions(1, new int[]{-5,-88,-88}, new int[]{-4,-88,-88}, new char[]{'n','r'}));
        tt1[21].add(new Transitions(21, new int[]{3,1,2}, new int[]{3,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,1,3}, new int[]{3,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,1,4}, new int[]{3,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,1,5}, new int[]{3,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,4,5}, new int[]{3,4,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{3,-77,-77}, new int[]{3,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,1,2}, new int[]{-3,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,1,3}, new int[]{-3,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,1,4}, new int[]{-3,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,1,5}, new int[]{-3,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,2,3}, new int[]{-3,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,3,4}, new int[]{-3,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,3,5}, new int[]{-3,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-3,-77,-77}, new int[]{-3,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,1,2}, new int[]{4,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,1,3}, new int[]{4,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,1,4}, new int[]{4,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,1,5}, new int[]{4,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,2,3}, new int[]{4,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{4,-77,-77}, new int[]{4,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,1,2}, new int[]{-4,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,1,3}, new int[]{-4,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,1,4}, new int[]{-4,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,1,5}, new int[]{-4,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,2,3}, new int[]{-4,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,2,4}, new int[]{-4,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,3,4}, new int[]{-4,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,4,5}, new int[]{-4,4,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-4,-77,-77}, new int[]{-4,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,1,2}, new int[]{5,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,1,3}, new int[]{5,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,1,4}, new int[]{5,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,1,5}, new int[]{5,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,2,3}, new int[]{5,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,2,4}, new int[]{5,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,3,4}, new int[]{5,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{5,-77,-77}, new int[]{5,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,1,2}, new int[]{-5,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,1,3}, new int[]{-5,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,1,4}, new int[]{-5,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,1,5}, new int[]{-5,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,2,3}, new int[]{-5,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,2,4}, new int[]{-5,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,2,5}, new int[]{-5,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,3,4}, new int[]{-5,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,3,5}, new int[]{-5,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,4,5}, new int[]{-5,4,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-5,-77,-77}, new int[]{-5,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,1,2}, new int[]{-99,1,2}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,1,3}, new int[]{-99,1,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,1,4}, new int[]{-99,1,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,1,5}, new int[]{-99,1,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,2,3}, new int[]{-99,2,3}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,2,4}, new int[]{-99,2,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,2,5}, new int[]{-99,2,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,3,4}, new int[]{-99,3,4}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,3,5}, new int[]{-99,3,5}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(21, new int[]{-99,-77,-77}, new int[]{-99,-77,-77}, new char[]{'n','l'}));
        tt1[21].add(new Transitions(22, new int[]{-99,-88,-88}, new int[]{-99,-88,-88}, new char[]{'l','r'}));
        
        //transitions in 22nd state
        tt1[22].add(new Transitions(0, new int[]{-88,1,2}, new int[]{-88,1,2}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,1,3}, new int[]{-88,1,3}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,1,4}, new int[]{-88,1,4}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,1,5}, new int[]{-88,1,5}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,2,3}, new int[]{-88,2,3}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,2,4}, new int[]{-88,2,4}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,2,5}, new int[]{-88,2,5}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,3,4}, new int[]{-88,3,4}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,3,5}, new int[]{-88,3,5}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(0, new int[]{-88,4,5}, new int[]{-88,4,5}, new char[]{'r','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,1,2}, new int[]{-1,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,1,3}, new int[]{-1,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,1,4}, new int[]{-1,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,1,5}, new int[]{-1,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,2,3}, new int[]{-1,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,2,4}, new int[]{-1,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,2,5}, new int[]{-1,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,3,4}, new int[]{-1,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,3,5}, new int[]{-1,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-1,4,5}, new int[]{-1,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,1,2}, new int[]{2,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,1,3}, new int[]{2,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,1,4}, new int[]{2,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,1,5}, new int[]{2,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,2,3}, new int[]{2,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,2,4}, new int[]{2,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,2,5}, new int[]{2,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,3,4}, new int[]{2,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,3,5}, new int[]{2,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{2,4,5}, new int[]{2,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,1,2}, new int[]{-2,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,1,3}, new int[]{-2,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,1,4}, new int[]{-2,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,1,5}, new int[]{-2,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,2,3}, new int[]{-2,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,2,4}, new int[]{-2,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,2,5}, new int[]{-2,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,3,4}, new int[]{-2,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,3,5}, new int[]{-2,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-2,4,5}, new int[]{-2,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,1,2}, new int[]{3,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,1,3}, new int[]{3,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,1,4}, new int[]{3,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,1,5}, new int[]{3,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{3,4,5}, new int[]{3,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,1,2}, new int[]{-3,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,1,3}, new int[]{-3,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,1,4}, new int[]{-3,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,1,5}, new int[]{-3,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,2,3}, new int[]{-3,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,2,4}, new int[]{-3,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,2,5}, new int[]{-3,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,3,4}, new int[]{-3,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,3,5}, new int[]{-3,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-3,4,5}, new int[]{-3,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,1,2}, new int[]{4,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,1,3}, new int[]{4,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,1,4}, new int[]{4,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,1,5}, new int[]{4,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,2,3}, new int[]{4,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{4,4,5}, new int[]{4,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,1,2}, new int[]{-4,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,1,3}, new int[]{-4,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,1,4}, new int[]{-4,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,1,5}, new int[]{-4,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,2,3}, new int[]{-4,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,2,4}, new int[]{-4,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,2,5}, new int[]{-4,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,3,4}, new int[]{-4,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,3,5}, new int[]{-4,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-4,4,5}, new int[]{-4,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,1,2}, new int[]{5,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,1,3}, new int[]{5,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,1,4}, new int[]{5,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,1,5}, new int[]{5,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,2,3}, new int[]{5,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,2,4}, new int[]{5,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,3,4}, new int[]{5,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{5,4,5}, new int[]{5,4,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,1,2}, new int[]{-5,1,2}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,1,3}, new int[]{-5,1,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,1,4}, new int[]{-5,1,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,1,5}, new int[]{-5,1,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,2,3}, new int[]{-5,2,3}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,2,4}, new int[]{-5,2,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,2,5}, new int[]{-5,2,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,3,4}, new int[]{-5,3,4}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,3,5}, new int[]{-5,3,5}, new char[]{'l','n'}));
        tt1[22].add(new Transitions(22, new int[]{-5,4,5}, new int[]{-5,4,5}, new char[]{'l','n'}));
        
        //transitions in 23th state
        tt1[23].add(new Transitions(23, new int[]{-99,1,2}, new int[]{-99,1,2}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,1,3}, new int[]{-99,1,3}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,1,4}, new int[]{-99,1,4}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,1,5}, new int[]{-99,1,5}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,2,3}, new int[]{-99,2,3}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,2,4}, new int[]{-99,2,4}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,2,5}, new int[]{-99,2,5}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,3,4}, new int[]{-99,3,4}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,3,5}, new int[]{-99,3,5}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(23, new int[]{-99,4,5}, new int[]{-99,4,5}, new char[]{'n','r'}));
        tt1[23].add(new Transitions(24, new int[]{-99,-77,-77}, new int[]{-99,-77,-77}, new char[]{'n','r'}));
        
        //transitions in 24th state
        tt1[24].add(new Transitions(25, new int[]{-99,0,0}, new int[]{-99,0,0}, new char[]{'l','n'}));
        tt1[24].add(new Transitions(21, new int[]{-99,1,1}, new int[]{-99,0,0}, new char[]{'n','l'}));
        
        //transitions in 25th state
        tt1[25].add(new Transitions(25, new int[]{-1,0,0}, new int[]{-1,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{2,0,0}, new int[]{2,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{-2,0,0}, new int[]{-2,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{3,0,0}, new int[]{3,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{-3,0,0}, new int[]{-3,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{4,0,0}, new int[]{4,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{-4,0,0}, new int[]{-4,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{5,0,0}, new int[]{5,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(25, new int[]{-5,0,0}, new int[]{-5,0,0}, new char[]{'l','n'}));
        tt1[25].add(new Transitions(26, new int[]{-88,0,0}, new int[]{-88,0,0}, new char[]{'r','l'}));
        
        //transitions in 26th state
        tt1[26].add(new Transitions(26, new int[]{-1,1,2}, new int[]{-1,1,2}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,1,3}, new int[]{-1,1,3}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,1,4}, new int[]{-1,1,4}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,1,5}, new int[]{-1,1,5}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,2,3}, new int[]{-1,2,3}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,2,4}, new int[]{-1,2,4}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,2,5}, new int[]{-1,2,5}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,3,4}, new int[]{-1,3,4}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,3,5}, new int[]{-1,3,5}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,4,5}, new int[]{-1,4,5}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(26, new int[]{-1,-77,-77}, new int[]{-1,-77,-77}, new char[]{'n','l'}));
        tt1[26].add(new Transitions(27, new int[]{-1,-88,-88}, new int[]{-1,-88,-88}, new char[]{'n','r'}));
        /***********************************End of 1st Transition Table***************************************/
        
        
        for (int i = 0; i < 3; i++) 
        {
            tt2[i] = new ArrayList<>();
        }
        
        /*********************************Start of 2nd Transition Table***************************************/
        //transitions in 0th state
        tt2[0].add(new Transitions(0, new int[]{-1,1,2}, new int[]{1,1,2}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,1,3}, new int[]{1,1,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,1,4}, new int[]{1,1,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,1,5}, new int[]{1,1,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,2,3}, new int[]{1,2,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,2,4}, new int[]{1,2,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,2,5}, new int[]{1,2,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,3,4}, new int[]{1,3,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,3,5}, new int[]{1,3,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,4,5}, new int[]{1,4,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-1,-77,-77}, new int[]{1,-77,-77}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,1,2}, new int[]{2,1,2}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,1,3}, new int[]{2,1,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,1,4}, new int[]{2,1,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,1,5}, new int[]{2,1,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,2,3}, new int[]{2,2,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,2,4}, new int[]{2,2,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,2,5}, new int[]{2,2,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,3,4}, new int[]{2,3,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,3,5}, new int[]{2,3,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,4,5}, new int[]{2,4,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-2,-77,-77}, new int[]{2,-77,-77}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,1,2}, new int[]{3,1,2}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,1,3}, new int[]{3,1,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,1,4}, new int[]{3,1,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,1,5}, new int[]{3,1,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,2,3}, new int[]{3,2,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,2,4}, new int[]{3,2,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,2,5}, new int[]{3,2,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,3,4}, new int[]{3,3,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,3,5}, new int[]{3,3,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,4,5}, new int[]{3,4,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-3,-77,-77}, new int[]{3,-77,-77}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,1,2}, new int[]{4,1,2}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,1,3}, new int[]{4,1,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,1,4}, new int[]{4,1,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,1,5}, new int[]{4,1,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,2,3}, new int[]{4,2,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,2,4}, new int[]{4,2,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,2,5}, new int[]{4,2,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,3,4}, new int[]{4,3,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,3,5}, new int[]{4,3,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-4,-77,-77}, new int[]{4,-77,-77}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,1,2}, new int[]{5,1,2}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,1,3}, new int[]{5,1,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,1,4}, new int[]{5,1,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,1,5}, new int[]{5,1,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,2,3}, new int[]{5,2,3}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,2,4}, new int[]{5,2,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,2,5}, new int[]{5,2,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,3,4}, new int[]{5,3,4}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,3,5}, new int[]{5,3,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,4,5}, new int[]{5,4,5}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(0, new int[]{-5,-77,-77}, new int[]{5,-77,-77}, new char[]{'r','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,1,2}, new int[]{-99,1,2}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,1,3}, new int[]{-99,1,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,1,4}, new int[]{-99,1,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,1,5}, new int[]{-99,1,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,2,3}, new int[]{-99,2,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,2,4}, new int[]{-99,2,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,2,5}, new int[]{-99,2,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,3,4}, new int[]{-99,3,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,3,5}, new int[]{-99,3,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,4,5}, new int[]{-99,4,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(1, new int[]{-99,-77,-77}, new int[]{-99,-77,-77}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,1,2}, new int[]{2,1,2}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,1,3}, new int[]{2,1,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,1,4}, new int[]{2,1,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,1,5}, new int[]{2,1,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,2,3}, new int[]{2,2,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,2,4}, new int[]{2,2,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,2,5}, new int[]{2,2,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,3,4}, new int[]{2,3,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,3,5}, new int[]{2,3,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,4,5}, new int[]{2,4,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{2,-77,-77}, new int[]{2,-77,-77}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,1,2}, new int[]{3,1,2}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,1,3}, new int[]{3,1,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,1,4}, new int[]{3,1,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,1,5}, new int[]{3,1,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,2,3}, new int[]{3,2,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,2,4}, new int[]{3,2,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,2,5}, new int[]{3,2,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,3,4}, new int[]{3,3,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,3,5}, new int[]{3,3,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,4,5}, new int[]{3,4,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{3,-77,-77}, new int[]{3,-77,-77}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,1,2}, new int[]{4,1,2}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,1,3}, new int[]{4,1,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,1,4}, new int[]{4,1,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,1,5}, new int[]{4,1,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,2,3}, new int[]{4,2,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,2,4}, new int[]{4,2,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,2,5}, new int[]{4,2,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,3,4}, new int[]{4,3,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,3,5}, new int[]{4,3,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,4,5}, new int[]{4,4,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{4,-77,-77}, new int[]{4,-77,-77}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,1,2}, new int[]{5,1,2}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,1,3}, new int[]{5,1,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,1,4}, new int[]{5,1,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,1,5}, new int[]{5,1,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,2,3}, new int[]{5,2,3}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,2,4}, new int[]{5,2,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,2,5}, new int[]{5,2,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,3,4}, new int[]{5,3,4}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,3,5}, new int[]{5,3,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,4,5}, new int[]{5,4,5}, new char[]{'n','n'}));
        tt2[0].add(new Transitions(2, new int[]{5,-77,-77}, new int[]{5,-77,-77}, new char[]{'n','n'}));
        
        
        fsm[0] = new FSM(29, tt1, 0, 27, 28);
        fsm[1] = new FSM(3, tt2, 0, 1, 2);
        
        
        
    }   
    
    private void loadSplashScreen() {
        try {
            
            IsGraphConnected.isSplashLoaded = true;
            
            StackPane pane = FXMLLoader.load(getClass().getResource(("SplashScreen.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });
//
            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("MainScreen.fxml")));
                    root.getChildren().setAll(parentContent);

                } catch (IOException ex) {
                    Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    @FXML
    private void insertNode(javafx.event.ActionEvent event) throws IOException {        
        switch (n) {
            case 0:
                nodeTape.insert(-1);
                b1.setVisible(true);
                break;
            case 1:
                nodeTape.insert(2);
                b2.setVisible(true);
                break;
            case 2:
                nodeTape.insert(3);
                b3.setVisible(true);
                break;
            case 3:
                nodeTape.insert(4);
                b4.setVisible(true);
                break;
            case 4:
                nodeTape.insert(5);
                b5.setVisible(true);
                break;
            default:
                message.display("Unexcepted Node", "You can not add more than 5 nodes");
                break;
        }
        n++;
    }

    @FXML
    private void insertEdge(javafx.event.ActionEvent event) throws IOException {
        if(n < 2)
        {
            message.display("No Nodes", "Please put atleast 2 nodes to add an edge");
            return;
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InsertEdges.fxml"));  
        Stage stage = new Stage();
        stage.setTitle("Add Vertices");
        stage.setScene(new Scene((Parent) loader.load()));

        // showAndWait will block execution until the window closes...
        stage.showAndWait();


        c = InsertEdgesController.vertex;
        if((c[0].equals("1") && c[1].equals("2")) || (c[0].equals("2") && c[1].equals("1")))
        {
            if(!b1.isVisible() || !b2.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 1 or Node 2 or both are missing");
                return;
            }
            l12.setVisible(true);
            edgeTape.insert(1, 2);
        }
        else if(c[0].equals("1") && c[1].equals("3") || (c[0].equals("3") && c[1].equals("1")))
        {
            if(!b1.isVisible() || !b3.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 1 or Node 3 or both are missing");
                return;
            }
            l13.setVisible(true);
            edgeTape.insert(1, 3);
        }
        else if(c[0].equals("1") && c[1].equals("4") || (c[0].equals("4") && c[1].equals("1")))
        {
            if(!b1.isVisible() || !b4.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 1 or Node 4 or both are missing");
                return;
            }
            l14.setVisible(true);
            edgeTape.insert(1, 4);
        }
        else if(c[0].equals("1") && c[1].equals("5") || (c[0].equals("5") && c[1].equals("1")))
        {
            if(!b1.isVisible() || !b5.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 1 or Node 5 or both are missing");
                return;
            }
            l15.setVisible(true);
            edgeTape.insert(1, 5);
        }
        else if(c[0].equals("2") && c[1].equals("3") || (c[0].equals("3") && c[1].equals("2")))
        {
            if(!b2.isVisible() || !b3.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 2 or Node 3 or both are missing");
                return;
            }
            l23.setVisible(true);
            edgeTape.insert(2, 3);
        }
        else if(c[0].equals("2") && c[1].equals("4") || (c[0].equals("4") && c[1].equals("2")))
        {
            if(!b2.isVisible() || !b4.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 2 or Node 4 or both are missing");
                return;
            }
            l24.setVisible(true);
            edgeTape.insert(2, 4);
        }
        else if(c[0].equals("2") && c[1].equals("5") || (c[0].equals("5") && c[1].equals("2")))
        {
            if(!b2.isVisible() || !b5.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 2 or Node 5 or both are missing");
                return;
            }
            l25.setVisible(true);
            edgeTape.insert(2, 5);
        }
        else if(c[0].equals("3") && c[1].equals("4") || (c[0].equals("4") && c[1].equals("3")))
        {
            if(!b3.isVisible() || !b4.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 3 or Node 4 or both are missing");
                return;
            }
            l34.setVisible(true);
            edgeTape.insert(3, 4);
        }
        else if(c[0].equals("3") && c[1].equals("5") || (c[0].equals("5") && c[1].equals("3")))
        {
            if(!b3.isVisible() || !b5.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 3 or Node 5 or both are missing");
                return;
            }
            l35.setVisible(true);
            edgeTape.insert(3, 5);
        }
        else if(c[0].equals("4") && c[1].equals("5") || (c[0].equals("5") && c[1].equals("4")))
        {
            if(!b4.isVisible() || !b5.isVisible())
            {
                message.display("Incorrect Node(s)", "Either Node 4 or Node 5 or both are missing");
                return;
            }
            l45.setVisible(true);
            edgeTape.insert(4, 5);
        }
        else
            message.display("Unexpected Vertice", "Please write correct vertices.");
         
    }
    
    
    

    @FXML
    private void process(javafx.event.ActionEvent event) {
        edgeTape.insert(-77, -77);
        edgeTape.insert(0, 0);
        
        TuringMachine tm = new TuringMachine(nodeTape, edgeTape, fsm);
        if(tm.execute())
        {
            try { 
                AnchorPane pane = FXMLLoader.load(getClass().getResource(("IsConnected.fxml")));
                root.getChildren().setAll(pane);

                FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), pane);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);

                FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setCycleCount(1);

                fadeIn.play();

                fadeIn.setOnFinished((e) -> {
                    fadeOut.play();
                });
    //
                fadeOut.setOnFinished((e) -> {
                    try {
                        AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("MainScreen.fxml")));
                        root.getChildren().setAll(parentContent);

                    } catch (IOException ex) {
                        Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        else
        {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource(("IsNotConnected.fxml")));
                root.getChildren().setAll(pane);

                FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), pane);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);

                FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setCycleCount(1);

                fadeIn.play();

                fadeIn.setOnFinished((e) -> {
                    fadeOut.play();
                });
    //
                fadeOut.setOnFinished((e) -> {
                    try {
                        AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("MainScreen.fxml")));
                        root.getChildren().setAll(parentContent);

                    } catch (IOException ex) {
                        Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

            } catch (IOException ex) {
                Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void doReset(javafx.event.ActionEvent event) 
    {
        Stage stage = new Stage();
        Parent root = null;
        this.root.getScene().getWindow().hide();
        try {
            root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void doExit(javafx.event.ActionEvent event) 
    {
        root.getScene().getWindow().hide();
    }
    

    
    
}
