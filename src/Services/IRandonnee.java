/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Randonne;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Sarra
 */
public interface IRandonnee {
        public void insert(Randonne r);
    public List<Randonne> showRandonne();
      public ObservableList <Randonne> showRandonnees();
       public Randonne getRand(Integer i) ;
    public void supprimerRandonne(int id);
public void modifierRandonne( Randonne o) ; 

public List<Randonne> findLoc(String l);
 public List<Randonne>finddate(String t);

}
