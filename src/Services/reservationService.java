/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;



import Entities.reservation;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class reservationService implements IRESservice<reservation> {

    Connection con;
    Statement stm;

    public reservationService() {
        con = MyDB.getInstance().getCon();
    }
@Override
    public ObservableList<reservation> afficherres() throws SQLException {
        String req = "Select * from `resrevation`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        ObservableList<reservation> reservations =FXCollections.observableArrayList();
        while(rst.next()){
            
           reservation r = new reservation(rst.getInt("id"),rst.getInt("transport"),rst.getInt("nourriture"),rst.getString("infosupp"));
           //r.setId(rst.getInt("id"));
         //  r.setIdevent(rst.getInt("event_id"));
           r.setIduser(rst.getInt("id_User"));
            r.getIdrando(rst.getInt("rando_id"));
           /*r.setInfo_supp(rst.getString("infosupp"));
           r.setNourriture(rst.getBoolean("nourriture"));
           r.setTransport(rst.getBoolean("transport"));*/
            reservations.add(r);
            
        
        }
        return reservations;
        
    }
   @Override 
    public void ajouterRes(reservation t) throws SQLException{
         String req = "INSERT INTO `reservation` (`nourriture`,`transport`,`infosupp`,`id_User`  ,`rando_id`) VALUES ( '" +t.getNourriture()+ "', '" +t.getTransport()+ "', '" +t.getInfo_supp()+ "',  '" +t.getIduser()+ "',  '" +t.getIdrando()+ "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);
    }
     @Override
    public void Supprimerres(int id) throws SQLException {
        String req ="DELETE FROM `reservation` WHERE id="+id+";";
        stm = con.createStatement();
        stm.executeUpdate(req);
        System.out.println("reservation supprimé avec succés!");
    }
     @Override
    public void Modifierres(reservation e , int id) throws SQLException {
        
        String query= "UPDATE `reservation` SET `nourriture`='"+e.getNourriture()+"',`transport`="+e.getTransport()+",`info_supp`="+e.getInfo_supp()+"'  WHERE id="+id; 
        Statement st = con.createStatement();
        st.executeUpdate(query);
        System.out.println(" reservation modifié avec succès!");
    }
        public int nbrNourritureTotal() throws SQLException {
        int nb = 0;

        String req = "SELECT count(nourriture) FROM `reservation`";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(req);
        if (result.next()) {
            nb = result.getInt(1);
        }
        return nb;

    }
           public int nbrTransportTotal() throws SQLException {
        int nb = 0;

        String req = "SELECT count(transport) FROM `reservation`";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(req);
        if (result.next()) {
            nb = result.getInt(1);
        }
        return nb;

    }
               public int nbrreservationTotal() throws SQLException {
        int nb = 0;

        String req = "SELECT count * FROM `reservation `";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(req);
        if (result.next()) {
            nb = result.getInt(1);
        }
        return nb;

    }
    
}

