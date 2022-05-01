/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Activite;
import Services.ActiviteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class AddActiviteController implements Initializable {

    @FXML
    private Button btn_ajout;
    @FXML
    private TextField tfnom;
    @FXML
    private TextArea tfdes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterActivite(ActionEvent event) {
      
         if((tfnom.getText().equals("") )|| (tfdes.getText().equals("")) ){
            System.out.println("les champs sont vides ");
   
                 Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champ manquant");
                alert.setHeaderText(null);
                alert.setContentText("IL FAUT REMPLIR TOUS LES CHAMPS");
                alert.showAndWait();
        }
        else
        {System.out.println("les champs sont remplis ");
        ActiviteService sa=new ActiviteService();
              
        Activite a =new Activite();
    
     a.setNom(tfnom.getText());
a.setDescription(tfdes.getText());
       sa.insert(a);
        
        }}  
    }
    

