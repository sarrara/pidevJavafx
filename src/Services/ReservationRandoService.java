/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Activite;
import Entities.ReservationRando;
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

/**
 *
 * @author Sarra
 */
public class ReservationRandoService implements IReservation <ReservationRando> {
     private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    
    private Connection conn; 
    
    public ReservationRandoService()
    { conn= MyDB.getInstance().getCon();
    }   

   
    public void insert(ReservationRando r) {
      String req = "insert into reservation values (id=?, event_id=?, rando_id=?, user_id=?, transport=?, nourriture=?)";
   
    try 
    {
        ste=conn.createStatement(); 
        ste.executeUpdate(req); 
    }
    
    catch (SQLException ex)
    {
    Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
    }    }    


    public List<ReservationRando> readAll() {
        String req = "SELECT `id`, `event_id`, `rando_id`, `user_id`, `transport`, `nourriture` FROM `reservation` "; 
        
       List <ReservationRando> list = new ArrayList<>(); 
       try {
       ste = conn.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new ReservationRando(rs.getInt("id"),rs.getInt("event_id"),rs.getInt("rando_id"),rs.getInt("user_id"),rs.getInt("transport"),rs.getInt("nourriture"))); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ReservationRandoService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }    


    public void delete(int id) {
      try {
            Statement stm=conn.createStatement();
            String query="DELETE FROM `reservation` where id = '"+id+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(ReservationRandoService.class.getName()).log(Level.SEVERE, null, ex);
       }
     }    


   
    public void updateResrvRando(int id, int event_id, int rando_id, int user_id, int transport, int nourriture){
         String requete="UPDATE reservation SET id='"+id+"',event_id='"+event_id+"', rando_id='"+rando_id+"', user_id='"+user_id+"', transport='"+transport+"' ,nourriture='"+nourriture+"'  WHERE id='"+id+"'";

         try{
             ste = conn.createStatement();
            ste.executeUpdate(requete);
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
            Logger.getLogger(ActiviteService.class.getName()).log(Level.SEVERE, null, ex);
        }    }

   

}
   

