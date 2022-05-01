/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Activite;
import Entities.Randonne;
import Services.ActiviteService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class DetailActiviteController implements Initializable {

    @FXML
    private TableColumn<Activite, Integer> idcol;
    @FXML
    private TableColumn<Activite, String> nomcol;
    @FXML
    private TableColumn<Activite, String> descol;
    @FXML
    private TableView<Activite> tableactiv;
    @FXML
    private Button qrcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadtable();
    }    
      private void loadtable() {
    ActiviteService rs= new ActiviteService();
       
        ObservableList<Activite> rand = rs.showActivites();
  tableactiv.setItems(rand);


        idcol.setCellValueFactory(new PropertyValueFactory<Activite, Integer>("id"));
        
        nomcol.setCellValueFactory(new PropertyValueFactory<Activite, String>("nom"));
      
        descol.setCellValueFactory(new PropertyValueFactory<Activite, String>("description"));
   
     tableactiv.setItems(rand);
        
    }
    @FXML
    private void supprimer(ActionEvent event) {
             
        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("DELETE");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Êtes-vous sûr de vouloir supprimer cette Randonnée");
        Optional<ButtonType> answer = dialogC.showAndWait();
        if (answer.get() == ButtonType.OK) {
            System.out.println("OK");
            Activite a = tableactiv.getSelectionModel().getSelectedItem();
            System.out.println(a.getId());
           ActiviteService rs= new ActiviteService();
            rs.delete(a.getId());
           System.out.println("supprimer");
            loadtable();
       } else {
           System.out.println("cancel");
        }

    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
   private void qrcode(ActionEvent event)throws IOException  {

Activite a = tableactiv.getSelectionModel().getSelectedItem();
  QRCodeWriter qrCodeWriter = new QRCodeWriter();
  
        String myWeb = a.toString();
        int width = 400;
        int height = 400;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success (qr code )");
            
        } catch (WriterException ex) {
            Logger.getLogger(DetailRandonneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        Stage primaryStage = new Stage() ;
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("QR code de    "+a.getNom());
        primaryStage.setScene(scene);
        primaryStage.show();
}
    


    
}
