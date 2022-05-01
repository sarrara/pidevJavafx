/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Randonne;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.scene.control.Alert;
import Entities.Activite;
import Services.IServiceActivite;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author Sarra
 */
public class serviceRandonnee implements IRandonnee{
  
    private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    private Connection conn; 
    
    public serviceRandonnee()
    { conn= MyDB.getInstance().getCon();
    }
     public void insert(Randonne r) {
  
  try{
                 String req = "insert into randonnee (id,Id_Activ,nom,localisation,prix,Nbr_Place,date_deb,image) values  ('"+  r.getId()+"','" +  r.getIdActiv()+"','" +  r.getNom()+"','" + r.getLocalisation()+"','" + r.getPrix() +"','" + r.getNbplaces()+  "','" + r.getDate()+  "','" + r.getImage() + "')"; 
          ste=conn.createStatement();
            
            ste.executeUpdate(req);
            System.out.println("randonnée ajouté avec succes");
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("randonnee");
                alert.setHeaderText(null);
                alert.setContentText("randonnee ajouté");
                alert.showAndWait();
                
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
        } 

    public ObservableList<Randonne> showRandonnees() {
    ObservableList<Randonne> myList = FXCollections.observableArrayList();
    
        try {

            String req = "SELECT * FROM randonnee";
            ste=conn.createStatement();
            ste.executeQuery(req);
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                Randonne r= new Randonne();
                r.setId(rs.getInt(1));
                  r.setIdActiv(rs.getInt(2));
               // r.setIdActiv(as.load_data_modify(rs.getString(2)));
                r.setNom(rs.getString(3));
                r.setPrix(rs.getFloat(4));
                r.setLocalisation(rs.getString(5));
                r.setNbplaces(rs.getInt(6));
                r.setDate(rs.getDate(7));
                r.setImage(rs.getString(8));
             
                myList.add(r);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;    }

    @Override
    public List<Randonne> showRandonne() {
    ObservableList<Randonne> myList = FXCollections.observableArrayList();
      ActiviteService as = new ActiviteService();
        try {

            String req = "SELECT * FROM randonnee";
            ste=conn.createStatement();
        ste.executeQuery(req);
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                Randonne r= new Randonne();
                r.setId(rs.getInt(1));
            r.setIdActiv(rs.getInt(2));
//                r.setIdActiv(as.load_data_modify(rs.getString(2)));
       //  r.setIdActiv(rs.getString(2));
                r.setNom(rs.getString(3));
                r.setPrix(rs.getFloat(4));
                r.setLocalisation(rs.getString(5));
                r.setNbplaces(rs.getInt(6));
                r.setDate(rs.getDate(7));
                r.setImage(rs.getString(8));
             
                myList.add(r);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;    }


        public void supprimerRandonne(int id) {
        try {
            String requete = "DELETE FROM randonnee WHERE id = " + id +"";
           ste=conn.createStatement();
            
            ste.executeUpdate(requete);
            System.out.println("Randonne supprimer");
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Randonne");
                alert.setHeaderText(null);
                alert.setContentText("Randonne suppri");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void modifierRandonne(Randonne o) {
        try {
             ste=conn.createStatement();
            //nb: on ne peut pas modifier la date
         String requete=  "UPDATE randonnee SET id_activ=?,nom=?,prix=?,localisation=?,nbr_place=?,date_deb=?,image=? WHERE id=?" ;
            ste.executeUpdate(requete);
            System.out.println("modification avec succes");
        } catch (SQLException ex) {
            System.out.println("erreur modifier objectif");
            System.out.println(ex);
        }
    }
/*public void modifierRandonne( int IdActiv, String nom, String localisation, float prix, int nbplaces, Date date, String image)  
{        try {
            ste=conn.createStatement();
          

         String requete=  "UPDATE randonnee SET id_activ=?,nom=?,prix=?,localisation=?,nbr_place=?,date_deb=?,image=? WHERE id=?" ;
                    
                    
            ste.executeUpdate(requete);
            System.out.println("modification avec succes");
        } catch (SQLException ex) {
            System.out.println("erreur modifier");
            System.out.println(ex);
        }*/
        
    
  /*  
    try{
    
         String requete=  "UPDATE randonnee SET id_activ=?,nom=?,prix=?,localisation=?,nbr_place=?,date_deb=?,image=? WHERE id=?" ;
             PreparedStatement pt=MyDB.getInstance().getCon().prepareStatement(requete);
          //  pt.setString(1, a.getIdActiv());
    pt.setInt(1,a.getIdActiv());
//pt.setIdActiv(rs.getInt(2));
            pt.setString(2,a.getNom());
            pt.setFloat(3,a.getPrix());
            pt.setString(4,a.getLocalisation());
            pt.setInt(5, a.getNbplaces());
            pt.setDate(6, (java.sql.Date) a.getDate());
            pt.setString(7,  a.getImage());
      
            pst.executeUpdate();
            System.out.println("randonnee modifié!");
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("randonnee");
                alert.setHeaderText(null);
                alert.setContentText("randonnee modifié");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/


    @Override
    public List<Randonne> findLoc(String l) {
ObservableList<Randonne> myList = FXCollections.observableArrayList();
     ActiviteService as = new ActiviteService();
        try {

            String req = "SELECT * FROM randonnee WHERE localisation='"+l+"' ORDER BY date  ";
ste=conn.createStatement();
            
            ste.executeUpdate(req);
           
            while (rs.next()) {
                Randonne r= new Randonne();
                r.setId(rs.getInt(1));
                r.setIdActiv(rs.getInt(2));
//              r.setIdActiv(as.load_data_modify(rs.getString(2)));
               // r.setIdActiv(rs.getString(2));
                r.setNom(rs.getString(3));
                r.setPrix(rs.getFloat(4));
                r.setLocalisation(rs.getString(5));
                r.setNbplaces(rs.getInt(6));
                r.setDate(rs.getDate(7));
                r.setImage(rs.getString(8));
                    myList.add(r);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;   }

@Override
            public List<Randonne> finddate(String t) {
                ObservableList<Randonne> myList = FXCollections.observableArrayList();
     ActiviteService as = new ActiviteService();
        try {

            String req = "SELECT * FROM randonnee WHERE date_deb ='"+t+"' ORDER BY date  ";
ste=conn.createStatement();
            
            ste.executeUpdate(req);
           
            while (rs.next()) {
                Randonne r= new Randonne();
                r.setId(rs.getInt(1));
                   // r.setIdActiv(rs.getString(2));
//r.setIdActiv(as.load_data_modify(rs.getString(2)));
r.setIdActiv(rs.getInt(2));
                r.setNom(rs.getString(3));
                r.setPrix(rs.getFloat(4));
                r.setLocalisation(rs.getString(5));
                r.setNbplaces(rs.getInt(6));
                r.setDate(rs.getDate(7));
                r.setImage(rs.getString(8));
                    myList.add(r);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;   }
            
 public Randonne getRand(Integer i) {
     Randonne Ac=null;
      ActiviteService sc = new ActiviteService();
          try {

            String req = "SELECT * FROM randonnee  WHERE id='"+i+"'";
            ste=conn.createStatement();
        ste.executeQuery(req);
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {

                Randonne r= new Randonne();
                r.setId(rs.getInt(1));
            r.setIdActiv(rs.getInt(2));
//                r.setIdActiv(as.load_data_modify(rs.getString(2)));
       //  r.setIdActiv(rs.getString(2));
                r.setNom(rs.getString(3));
                r.setPrix(rs.getFloat(4));
                r.setLocalisation(rs.getString(5));
                r.setNbplaces(rs.getInt(6));
                r.setDate(rs.getDate(7));
                r.setImage(rs.getString(8));
              Ac=r;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Ac;
    }
     public int nbrRandonneeTotal() throws SQLException {
        int nb = 0;

        String req = "SELECT count(*) FROM `randonnee`";
        ResultSet result = ste.executeQuery(req);
        if (result.next()) {
            nb = result.getInt(1);
        }
        return nb;

    }
}
