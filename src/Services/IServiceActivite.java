/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Activite;

import java.util.List;


/**
 *
 * @author Sarra
 */
public interface IServiceActivite<T> {
    
     void insert(T a);
    List<T>readAll();
   
    void delete(int id);
    void update(Activite a);
//void updaterandonnee (int id, String nom, int nb_places, String localisation, Date date, float prix, int IdActiv, String image);
    void rechercheActivite(int id);
void updateActivite (int id, String nom, String description);
}