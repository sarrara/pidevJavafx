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
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class ModifierController1 implements Initializable {

    @FXML
    private TextField tfprix;
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
    private ComboBox<Activite> cbactiv;
    @FXML
    private Button btn_confirmer_ajout_obj;
    @FXML
    private ImageView btn_modifer;
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
            Logger.getLogger(ModifierController1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    public void loadlistActivite() throws SQLException
{
ActiviteService sa = new  ActiviteService();
     ObservableList <Activite> activit = sa.getActiviteList();
               cbactiv.setItems(activit);

}
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
    private void AjouterRandonnee(ActionEvent event) {
      serviceRandonnee sc = new serviceRandonnee();
        Randonne r =new Randonne();
        java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(dpdate.getValue());
            r.setDate(gettedDatePickerDate);
      // r.setDate(dpdate.getEditor().getText());
     r.setIdActiv(cbactiv.getSelectionModel().getSelectedIndex());
     //r.setIdActiv(cbactiv.getSelectionModel().getSelectedItem());
     r.setImage(tfimage.getText());
     r.setLocalisation(tfloc.getText());
     r.setNbplaces(Integer.parseInt(tfnbplace.getText()));
     r.setNom(tfnom.getText());
     r.setPrix(Float.parseFloat(tfprix.getText()));
      sc.modifierRandonne(r);
      Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Information");
                alert2.setHeaderText("Modification avec succès");
                alert2.showAndWait();
            
                //System.out.println("Cancel");
            }
 
    }
    

   

/*public void InitData (Randonne p)throws MalformedURLException, IOException{ 
    pr=p;
    System.out.println("hani dkhalt l get produit "); }
    }*/
    

