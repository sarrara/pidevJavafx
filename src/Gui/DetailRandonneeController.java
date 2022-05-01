/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Entities.GenerateQRcode;
import Entities.Randonne;
import Services.ActiviteService;
import Services.serviceRandonnee;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class DetailRandonneeController implements Initializable {

    @FXML
    private TableView<Randonne> tablerandonnee;
    @FXML
    private TableColumn<Randonne,Integer> idcol;
    @FXML
    private TableColumn<Randonne, Integer> idActivicol;
    @FXML
    private TableColumn<Randonne, String> nomcol;
    @FXML
    private TableColumn<Randonne, Float> prixcol;
    @FXML
    private TableColumn<Randonne, String> localisationcol;
    @FXML
    private TableColumn<Randonne, Integer> nbrplacecol;
    @FXML
    private TableColumn<Randonne, Date> datecol;
    @FXML
    private TableColumn<Randonne, String> imagecol;
 
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button qrcode;
    private String test;
    @FXML
    private Button afficher;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   loadtable();
    }    
      private void loadtable() {
    serviceRandonnee rs= new serviceRandonnee();
       
        ObservableList<Randonne> rand = rs.showRandonnees();
  tablerandonnee.setItems(rand);


        idcol.setCellValueFactory(new PropertyValueFactory<Randonne, Integer>("id"));
        idActivicol.setCellValueFactory(new PropertyValueFactory<Randonne, Integer>("idActiv"));
        nomcol.setCellValueFactory(new PropertyValueFactory<Randonne, String>("nom"));
        prixcol.setCellValueFactory(new PropertyValueFactory<Randonne, Float>("prix"));
        localisationcol.setCellValueFactory(new PropertyValueFactory<Randonne, String>("localisation"));
        nbrplacecol.setCellValueFactory(new PropertyValueFactory<Randonne, Integer>("nbplaces"));
        datecol.setCellValueFactory(new PropertyValueFactory<Randonne, Date>("date"));
imagecol.setCellValueFactory(new PropertyValueFactory<Randonne, String>("image"));
     tablerandonnee.setItems(rand);
        
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
            Randonne a = tablerandonnee.getSelectionModel().getSelectedItem();
            System.out.println(a.getId());
           serviceRandonnee rs= new serviceRandonnee();
            rs.supprimerRandonne(a.getId());
           System.out.println("supprimer");
            loadtable();
       } else {
           System.out.println("cancel");
        }

    }

 /*public String readQRCode(String filePath, String charset, Map hintMap)throws FileNotFoundException, IOException, NotFoundException {
BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));

Result qrcoderesult = new MultiFormatReader().decode(binaryBitmap,hintMap);
return qrcoderesult.getText();}*/
    @FXML
private void qrcode(ActionEvent event)throws IOException  {

Randonne a = tablerandonnee.getSelectionModel().getSelectedItem();
  QRCodeWriter qrCodeWriter = new QRCodeWriter();
  
        String myWeb = a.toString();
        int width = 300;
        int height = 300;
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
        
        primaryStage.setTitle("QR code de la Randonnée   "+a.getNom());
        primaryStage.setScene(scene);
        primaryStage.show();
}
    /*private void modifier(MouseEvent event) throws IOException  {
  
           /* Randonne a = tablerandonnee.getSelectionModel().getSelectedItem();
            
            System.out.println(a.getId());
           serviceRandonnee rs= new serviceRandonnee();
            rs.modifierRandonne(a);
            System.out.println("moooooooooooo");
            /*((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("modifier.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Modifier randonner--Deal For All");
            primaryStage.show();    
        } catch (IOException ex) {
            Logger.getLogger(DetailRandonneeController.class.getName()).log(Level.SEVERE, null, ex);*/
              
       /* {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("modifier.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Modifier Reclamation--Deal For All");
            primaryStage.show();
            
        
        }*/
      
        
     // controller.InitData(prr);

    
    @FXML
    private void afficherdetaille(ActionEvent event) throws IOException {
              System.out.println(" haz el id met3 el rando  "+tablerandonnee.getSelectionModel().getSelectedItem().getId());
 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("affichageRandonnee.fxml"));
Parent modif = (Parent) fxmlLoader.load();
Stage stage = new Stage();
stage.setScene(new Scene(modif));  
stage.show();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("modifier.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        ModifierController1 controller= loader.getController();
        Randonne r = (Randonne) tablerandonnee.getSelectionModel().getSelectedItem();
        Randonne prr =r;
        System.out.println(" hani l produit prr " + prr) ;
        System.out.println(r);
    }


  
        
      
            }
    


          
    

    

   


             


