/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Gui.DashboardController.numeroPDF;
import Services.reservationService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class StatsController implements Initializable {

    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    reservationService reservationService;
    @FXML
    private Button BTN;
    @FXML
    private AnchorPane chartNode;
        public static int numeroPDF = 0;
      Document doc = new Document();
       public StatsController() {
        reservationService = new reservationService();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        try {
            pieChartData.add(new PieChart.Data("nourriture", reservationService.nbrNourritureTotal()));
            pieChartData.add(new PieChart.Data("transport", reservationService.nbrTransportTotal()));

        } catch (SQLException ex) {
            Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        pieChart.setData(pieChartData);
    }    

    @FXML
    private void PDF(ActionEvent event) {
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
    private void chartNode(MouseEvent event) {
    }
    
    
    
    
    
    
    
 

}
