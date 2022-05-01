/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.reservation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IRESservice <T>{
    List<reservation> afficherres() throws SQLException;
    void ajouterRes(T t) throws SQLException;
    
   void Supprimerres(int id) throws SQLException;
   void Modifierres(T m, int id) throws SQLException;
  
    
    
}
