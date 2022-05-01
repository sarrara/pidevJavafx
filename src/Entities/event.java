/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Khadija
 */
public class event {
    
    private int id;
    private String nom;
    private Date date_arr;
    private Date date_dep;
    private String localisation;
    private int prix;
    private int nbr_place;
    private int nbr_prt;
    private String description;
    private String image;

    public event(int id, String nom, Date date_arr, Date date_dep, String localisation, int prix, int nbr_place, int nbr_prt, String description, String image) {
        this.id = id;
        this.nom = nom;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.localisation = localisation;
        this.prix = prix;
        this.nbr_place = nbr_place;
        this.nbr_prt = nbr_prt;
        this.description=description;
        this.image=image;
        
    }
 public event( String nom, Date date_arr, Date date_dep, String localisation, int prix, int nbr_place, int nbr_prt, String description, String image) {
       
        this.nom = nom;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.localisation = localisation;
        this.prix = prix;
        this.nbr_place = nbr_place;
        this.nbr_prt = nbr_prt;
        this.description=description;
        this.image=image;
        
    }

    public event(String nom, Date date_arr, Date date_dep, String localisation, String description, String image) {
        this.nom = nom;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.localisation = localisation;
        this.description = description;
        this.image = image;
    }
    public event() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public event(String localisation, String nom) {
        this.localisation = localisation;
        this.nom = nom;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Date getDate_arr() {
        return date_arr;
    }

    public void setDate_arr(Date date_arr) {
        this.date_arr = date_arr;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public int getNbr_prt() {
        return nbr_prt;
    }

    public void setNbr_prt(int nbr_prt) {
        this.nbr_prt = nbr_prt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "event{" + "id=" + id + ", nom=" + nom + ", date_arr=" + date_arr + ", date_dep=" + date_dep + ", localisation=" + localisation + ", prix=" + prix + ", nbr_place=" + nbr_place + ", nbr_prt=" + nbr_prt + ", description=" + description + '}';
    }
       
}

    
    

