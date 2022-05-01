/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.reservationService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
 
public class StatController implements Initializable {
reservationService reservationService;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        try {
            pieChartData.add(new PieChart.Data("nourriture", reservationService.nbrNourritureTotal()));
            pieChartData.add(new PieChart.Data("transport", reservationService.nbrTransportTotal()));
           
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
        }

        pieChart.setData(pieChartData);

        ObservableList<PieChart.Data> pieChartDataEtats = FXCollections.observableArrayList();

      /**  for (nourriture r : nourriture.values()) {
            try {
                pieChartDataEtats.add(new PieChart.Data(r.name(),
                        reservationService.nbReclamationParType(r)));
            } catch (SQLException ex) {
                Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        pieChartEtat.setData(pieChartDataEtats);
    }
    


    public StatController() {
        reservationService = new reservationService();
    }

  
  

      

    @FXML
    private PieChart pieChart;

    @FXML
    private PieChart pieChartEtat;

}

    
  

