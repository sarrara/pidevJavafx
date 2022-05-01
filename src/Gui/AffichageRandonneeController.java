/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Randonne;
import Services.serviceRandonnee;
import Utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class AffichageRandonneeController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tfloc;
    @FXML
    private TextField tfnbr;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfnom;
    @FXML
    private Button btnres;
     private Randonne rando;
       serviceRandonnee se=new serviceRandonnee();
   // ActivityHolder ah = ActivityHolder.getINSTANCE();
    @FXML
    private Label sarra;
    @FXML
    private Button qr;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println("heere");
       // new ZoomIn(eventPane).play();
       Randonne r=new Randonne();

       rando=se.getRand(r.getId());
       tfnom.setText(rando.getNom());
       tfloc.setText(rando.getLocalisation());
       tfdate.setText(rando.getDate().toString());
               //image.setImage(rando.getImage());
//image.setText(String.valueOf(rando.getImage()));
        tfprix.setText(String.valueOf(rando.getPrix()));
        tfnbr.setText(String.valueOf(rando.getNbplaces()));

        tfloc.setText(rando.getLocalisation());
        
       System.out.println(rando.getId() +"wineeeeeeeeeeeek chbik dho3t :(((((((((");
    }
   
       public void afficher (){
           /* String a = "select * from randonnee";
            int i=0;
            try {
            }*/
            
        }

    @FXML
    private void generateqr(ActionEvent event) {
    }
    }    

