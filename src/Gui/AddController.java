/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Activite;
import Entities.Randonne;
import Services.ActiviteService;
import Services.serviceRandonnee;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Sarra
 */

public class AddController implements Initializable {
int i =0;
    @FXML
    private TextField tfprix;
    @FXML
    private Button btn_confirmer_ajout_obj;
    @FXML
    private TextField tfloc;
   
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker dpdate;
    @FXML
    private Button btn_AjouterIcone;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField tfnbplace;
    @FXML
    private ComboBox<?> cbactiv;
    @FXML
    private ImageView btn_ajout;
    @FXML
    private Button btn_clear;
    @FXML
    private ImageView btn_clear1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        loadlistActivite();
    } catch (SQLException ex) {
        Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    

    public void loadlistActivite() throws SQLException
{
ActiviteService sa = new  ActiviteService();
     ObservableList <Activite> activit = sa.getActiviteList();
     ObservableList listID = FXCollections.observableArrayList();
     for( int i= 0 ; i<activit.size(); i++)
     {
         listID.add(activit.get(i).getId());
     }
               cbactiv.setItems(listID);

}

    @FXML
    private void AjouterRandonnee(ActionEvent event) {

         if((tfprix.getText().equals("") )|| (tfloc.getText().equals("")) || (tfnom.getText().equals("")) || (tfnbplace.getText().equals("")) || (dpdate.getEditor().getText().equals(""))
                || (tfimage.getText().equals(""))){
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
               serviceRandonnee sc = new serviceRandonnee();
        Randonne r =new Randonne();
        java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(dpdate.getValue());
            r.setDate(gettedDatePickerDate);
      // r.setDate(dpdate.getEditor().getText());
     r.setIdActiv(Integer.parseInt(cbactiv.getSelectionModel().getSelectedItem().toString()));
     //r.setIdActiv(cbactiv.getSelectionModel().getSelectedItem());
     r.setImage(tfimage.getText());
     r.setLocalisation(tfloc.getText());
     r.setNbplaces(Integer.parseInt(tfnbplace.getText()));
     r.setNom(tfnom.getText());
     r.setPrix(Float.parseFloat(tfprix.getText()));
       sc.insert(r);
        
        }}

    /*@FXML
    private void AjouterIcone(ActionEvent event) {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    
    
    }*/
    @FXML
    private void AjouterIcone(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        if (f !=null){
            System.out.println(f.getName());
            tfimage.setText(f.getName());
        }else{
            
        }
    }
    @FXML
    private void clear(ActionEvent event) {
tfprix.clear();
tfloc.clear();
tfnom.clear();
tfimage.clear();
tfnbplace.clear();
dpdate.setValue(null);
 cbactiv.setValue(null);
    }
    
}
