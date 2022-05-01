/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Entities.reservation;

import Services.reservationService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Khadija
 */
public class NewReservationController implements Initializable {
ToggleGroup group = new ToggleGroup();
    @FXML
    private RadioButton nourriture;
   
    @FXML
    private RadioButton transport;
    @FXML
    private TextArea infosupp;
    @FXML
    private Button btnres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private void newreser(ActionEvent event) {
         nourriture.setToggleGroup(group);
         transport.setToggleGroup(group);
       Boolean nourritureevent=nourriture.isSelected();
       Boolean transportevent=transport.isSelected();
       String infosuppevent =infosupp.getText();
        
         reservationService rs=new reservationService();
           reservation r = new reservation(infosuppevent);
           if(nourriture.isSelected())
           {
               r.setNourriture(1);
           }
           
           if(transport.isSelected())
           {
               r.setTransport(1);
           }
          
           r.setIdrando(1);
           r.setIduser(1);
            try {
            rs.ajouterRes(r);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("reservation ajoutée");
            alert.setContentText("reservation ajoutée aves success");
            alert.show();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       
    }
    
}
