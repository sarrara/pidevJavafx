/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Activite;

import Utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import java.util.List;
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
public class ActiviteService implements IServiceActivite<Activite>{
   
    private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    
    private Connection conn; 
    
    public ActiviteService()
    { conn= MyDB.getInstance().getCon();
    }
    
 
   /* public List <Activite> tri() throws SQLException
    {
        Statement stm = conn.createStatement(); 
        String query= "SELECT * from activitie ORDER BY NOM";
        
               List <Activite> list = new ArrayList<>(); 

        
        Activite a = new Activite();
        try {
            rs = stm.executeQuery(query);
           // while(rs.next()){
            rs.next();
              a.setId(rs.getInt("id"));
                a.setNom(rs.getString("nom"));
                a.setDescription("description");
               
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;


    }
           
    
   /* public void rechercheActivite(int id) throws SQLException
    {
        Statement stm= conn.createStatement();
        String req = "select * from activitie where id = '"+id+"'";
        
        Activite a = new Activite();
        try {
            rs = stm.executeQuery(req);
           // while(rs.next()){
            rs.next();
                  a.setId(rs.getInt("id"));
                a.setNom(rs.getString("nom"));
                a.setDescription("description");
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }*/

    public void delete(int id) {
   try {
            String requete = "DELETE FROM activitie WHERE id = " + id +"";
           ste=conn.createStatement();
            
            ste.executeUpdate(requete);
            System.out.println("Activité supprimer");
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Activité");
                alert.setHeaderText(null);
                alert.setContentText("Activité suppri");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
   public void update(Activite a)  
{ try{
    
         String requete="UPDATE activitie SET nom=?, description=? WHERE id=?";
             PreparedStatement pt=MyDB.getInstance().getCon().prepareStatement(requete);
        
  
            pt.setString(2,a.getNom());
            pt.setString(3,a.getDescription());

            pst.executeUpdate();
            System.out.println("Activite modifié!");
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Activite");
                alert.setHeaderText(null);
                alert.setContentText("Activite modifié");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
     
     public ObservableList<Activite> getActiviteList() throws SQLException {
           
        ObservableList<Activite> Activitelist = FXCollections.observableArrayList();
        
         List <Activite> id = new ArrayList<>(); 
        Statement stm = conn.createStatement();
        String query = "select  id,  nom, description from activitie";

        //ResultSet rs;
        rs = stm.executeQuery(query);
        Activite Activite;
        while (rs.next()) {
           Activite= new Activite(rs.getInt("id"),rs.getString("nom"), rs.getString("description")); 
            //System.out.println(events);
            Activitelist.add(Activite);

        }
        return Activitelist;

    }
 
    public ObservableList<Activite> getActivitelistnew() throws SQLException {
        String req = "select id , nom ,description from activitie";
        ObservableList<Activite> list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Activite a = new Activite();
              
                 a.setId(rs.getInt("id"));
                a.setNom(rs.getString("nom"));
                a.setDescription("description");
                list.add(a);

            }

        } catch (SQLException ex) {
                Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public void insert(Activite a) {
      try {
        String req = "insert into activitie ( nom ,description) values  ('" + a.getNom()+"','" + a.getDescription() + "')"; 
   

    
        ste=conn.createStatement(); 
        ste.executeUpdate(req); 
     System.out.println("Activité ajouté avec succes");
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Activité");
                alert.setHeaderText(null);
                alert.setContentText("Activité ajouté");
                alert.showAndWait();
                
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
    
    }
    public ObservableList<Activite> showActivites() {
    ObservableList<Activite> myList = FXCollections.observableArrayList();
    
        try {

            String req = "SELECT * FROM activitie";
            ste=conn.createStatement();
            ste.executeQuery(req);
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                Activite r= new Activite();
                r.setId(rs.getInt(1));
                
               // r.setIdActiv(as.load_data_modify(rs.getString(2)));
                r.setNom(rs.getString(2));
                r.setDescription(rs.getString(3));
             
                myList.add(r);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;    }
    @Override
    public List<Activite> readAll()   {
        String req = "select id,nom,description from activitie"; 
        
       List <Activite> list = new ArrayList<>(); 
       try {
       ste = conn.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Activite(rs.getInt("id"),rs.getString("nom"), rs.getString("description"))); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }



    @Override
    public void rechercheActivite(int id) {
        try {
            Statement stm= conn.createStatement();
            String req = "select * from activitie where id = '"+id+"'";
            
            Activite a = new Activite();
            try {
                rs = stm.executeQuery(req);
                // while(rs.next()){
                rs.next();
                a.setId(rs.getInt("id"));
                a.setNom(rs.getString("nom"));
                a.setDescription("description");
                //}
            } catch (SQLException ex) {
                Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
            }    } catch (SQLException ex) {
            Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

   


  public  Activite load_data_modify(String id) {

        Statement stm = null;
        Activite c = new Activite();

        try {
            stm = conn.createStatement();
            String query = "select * from activitie where id = '"+id+"'";
            ResultSet rst = stm.executeQuery(query);

            while (rst.next()) {
                c.setId(rst.getInt("id"));
                c.setNom(rst.getString("nom"));
               c.setDescription(rst.getString("description"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return c;

    }

    @Override
    public void updateActivite(int id, String nom, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      public int nbrActiviteTotal() throws SQLException {
        int nb = 0;

        String req = "SELECT count(*) FROM `activitie`";
        ResultSet result = ste.executeQuery(req);
        if (result.first()) {
            nb = result.getInt(1);
        }
        return nb;

    }
 }


