/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class DetailReservationController implements Initializable {

    @FXML
    private TableView<?> tableactiv;
    @FXML
    private TableColumn<?, ?> idcol;
    @FXML
    private TableColumn<?, ?> iduser;
    @FXML
    private TableColumn<?, ?> idran;
    @FXML
    private TableColumn<?, ?> ideven;
    @FXML
    private TableColumn<?, ?> coltrans;
    @FXML
    private TableColumn<?, ?> colnour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
