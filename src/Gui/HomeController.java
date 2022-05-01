/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class HomeController implements Initializable {

    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Acceuil(MouseEvent event) {
        borderpane.setCenter(null);
    }

    @FXML
    private void add(MouseEvent event) {
         load("add");
    }


    private void exit(MouseEvent event) {
        Stage stage = (Stage)borderpane.getScene().getWindow();
        stage.close();
    }



    @FXML
    private void activite(MouseEvent event) {
        load("addActivite");
    }
 private void load(String a) {
     Parent root = null;
     
        try {
            root = FXMLLoader.load(getClass().getResource(a+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    borderpane.setCenter(root);
    
}

    @FXML
    private void modifier(MouseEvent event) {
          load("detailRandonnee");
    }

    @FXML
    private void DetailActivite(MouseEvent event) {
          load("detailActivite");
    }

  

    @FXML
    private void dashboard(MouseEvent event) {
           load("dashboard");
    }

    private void detailreser(MouseEvent event) {
        load("detailReservation");
    }

    @FXML
    private void stat(MouseEvent event) {
        load ("stat");
    }
    
}
