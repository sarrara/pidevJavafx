/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import Entities.Randonne;
import Services.ActiviteService;
import Services.serviceRandonnee;
import java.awt.Desktop;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class DashboardController implements Initializable {
 private Statement ste; 
    private Label lando;
serviceRandonnee sr = new serviceRandonnee();
ActiviteService as = new ActiviteService();
    private Label lactv;
    @FXML
    private BarChart<String, Integer> bc;
    @FXML
    private NumberAxis na;
    @FXML
    private CategoryAxis ca;
    @FXML
    private Button btnPDF;
    @FXML
    private ComboBox<Integer> cbYear;
     public static int numeroPDF = 0;
      Document doc = new Document();
    /**
     * Initializes the controller class.
     */
     private ObservableList<String> monthNames = FXCollections.observableArrayList();
     serviceRandonnee rs= new serviceRandonnee();
     ObservableList<String> rand = FXCollections.observableArrayList();
    private List<Randonne> listRec = new ArrayList<>();
    
    @FXML
    private AnchorPane chartNode;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
          String[]rando;
        monthNames.addAll(Arrays.asList(months));
   na.getScaleX();
        ca.setCategories(monthNames);
        
        serviceRandonnee sR = new serviceRandonnee();
        listRec = sR.showRandonnees();
        
        for(int i=2025; i > 2020; i--) {
            cbYear.getItems().add(i);
        }
    }
    
    public void show() throws SQLException{
           int i ,j ;
   
            i=sr.nbrRandonneeTotal();
            j=as.nbrActiviteTotal();
             lando.setText(Integer.toString(i));
             lactv.setText(Integer.toString(j));
       
        
    }

    @FXML
    private void btnPDFClicked(MouseEvent event) throws FileNotFoundException, DocumentException, BadElementException, IOException {
     numeroPDF = numeroPDF + 1;
        String nom = "Graph statistique " + numeroPDF + ".pdf";
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat Heure = new SimpleDateFormat("hh:mm:ss");
            //Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);

            WritableImage wimg = chartNode.snapshot(new SnapshotParameters(), null);
            File file = new File("ChartSnapshot.png");
            ImageIO.write(SwingFXUtils.fromFXImage(wimg, null), "png", file);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(System.getProperty("user.home") + "\\Desktop\\" + nom));
            doc.open();
//            Image img = Image.getInstance("C:\\xampp\\htdocs\\TunisiaBonPlan2-Integration\\web\\uploads\\images\\Sanstitre.png");
            Image img = Image.getInstance("ChartSnapshot.png");
            doc.add(img);

//                doc.add(new Paragraph("                                                           "
//                        + "                                                                                           "
//                        + "    " + date.format(new java.util.Date()), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//                        taille12NORMALRed));
//
//                doc.add(new Paragraph("                                                           "
//                        + "                                                                                                 "
//                        + "  " + Heure.format(new java.util.Date()), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//                        taille12NORMALRed));
//                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
//                doc.add(new Paragraph("                                    Bon de demande N°" + numeroCommande + " Ajouter un cadeaux dans le stock                                                         "));
//                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
//                doc.add(new Paragraph("Bon Plan",taille12NORMA));
//                
//
//         
//         
//  /*********************************Tableaux**********************************************/
//              
//                PdfPTable table = new PdfPTable(2);
//                table.setWidthPercentage(60);
//                table.setSpacingBefore(11f);
//          
//                Font f = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
//     
//                PdfPCell c1 = new PdfPCell(new Paragraph("Libelle", taille15B));
//                 c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                  PdfPCell c2 = new PdfPCell(new Paragraph("Quantité", taille15B));
//                  c2.setHorizontalAlignment(Element.ALIGN_CENTER);
//                PdfPCell c3 = new PdfPCell(new Paragraph(boncadeaux.getCadeaux().getLibelle(), taille12NORMA));
//              c3.setHorizontalAlignment(Element.ALIGN_CENTER);
//                PdfPCell c4 = new PdfPCell(new Paragraph(TXQuantite.getText(), taille12NORMA));
//          c4.setHorizontalAlignment(Element.ALIGN_CENTER);
//    
//                table.addCell(c1);
//                table.addCell(c3);
//                table.addCell(c2);
//                table.addCell(c4);
// 
//  /*********************************Tableaux Admin**********************************************/
//     
//                 User loggedUser = pidev.bonplan.Controller.LoginController.getInstance().getLoggedUser();
//                 
//        
//  
// User UserConneter=myServices.chercherUtilisateurByid(loggedUser.getId());            
//  
//  
//                PdfPTable tableAdmin = new PdfPTable(2);
//                tableAdmin.setWidthPercentage(60);
//                tableAdmin.setSpacingBefore(11f);
//               
//        
// 
//                PdfPCell cAdmin1 = new PdfPCell(new Paragraph("Admin"));
//                 cAdmin1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                  PdfPCell cAdmin2 = new PdfPCell(new Paragraph(UserConneter.getUsername()));
//                  cAdmin2.setHorizontalAlignment(Element.ALIGN_CENTER);
//           
//    
//                tableAdmin.addCell(cAdmin1);
//                tableAdmin.addCell(cAdmin2);
// 
//  
//   /*********************************Tableaux User**********************************************/
//                
//   
//   
//                          PdfPTable tableUser= new PdfPTable(2);
//                tableUser.setWidthPercentage(60);
//                tableUser.setSpacingBefore(11f);
//       
//               
// 
//                PdfPCell cUser1 = new PdfPCell(new Paragraph("Partenaire"));
//                 cUser1.setHorizontalAlignment(Element.ALIGN_CENTER);
//            
//                  PdfPCell cUser2 = new PdfPCell(new Paragraph(comboBoxSelectionnerPartenaire.getSelectionModel().getSelectedItem()));
//                  cUser2.setHorizontalAlignment(Element.ALIGN_CENTER);
//           
//    
//                tableUser.addCell(cUser1);
//                tableUser.addCell(cUser2);
//                
//                
//                  
//                doc.add(table);
//                doc.add(tableAdmin);
//              doc.add(tableUser);
            doc.close();
            Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\Desktop\\" + nom));
            writer.close();

        } catch (Exception e) {

            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());

        }

    }


    @FXML
    private void cbYearAction(ActionEvent event) {
          System.out.println(""+cbYear.getValue());
        System.out.println(""+listRec);
        int[] monthCounter = new int[12];
        for (Randonne p : listRec) {
            System.out.println(""+p.getDate());
            int month = p.getDate().getMonth();
            int year = p.getDate().getYear();
            if ( year == cbYear.getValue()) {
                monthCounter[month]++;
            
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
        bc.getData().clear();
        bc.getData().add(series);
    }
    
    }
}
    
    

