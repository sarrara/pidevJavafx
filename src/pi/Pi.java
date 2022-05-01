/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.awt.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sarra
 */
public class Pi extends Application {
    private double x,y;
    @Override
   
      public void start (Stage stage) throws Exception {
   Parent root = FXMLLoader.load(getClass().getResource("../Gui/home.fxml"));
   Scene scene = new Scene (root);
   stage.setTitle("gestion des randonnées");
            //stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
   //scene.setFill(Paint(Color.TRANSLUCENT));
           
   root.setOnMousePressed (new EventHandler <MouseEvent>(){
      @Override
      public void handle (MouseEvent event) {
         x= event.getSceneX();
         y = event.getSceneY();}});
   root.setOnMouseDragged (new EventHandler<MouseEvent>() {
      @Override
      public void handle (MouseEvent event) {
          stage.setX(event.getSceneX()-x);
          stage.setY(event.getSceneY()-y);}}
  
   );
   stage.setScene(scene);
 // stage.initStyle(StageStyle.TRANSPARENT);
    
   stage.show();}
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}