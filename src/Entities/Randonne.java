/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Sarra
 */
public class Randonne {
     private int id ;
     private int IdActiv;
private String nom ;
private String localisation  ;
private float prix  ;
private int nbplaces ;
private Date date  ;
private String image;

    public void setId(int id) {
        this.id = id;
    }

    public Randonne(String nom, String localisation, float prix, int nbplaces, Date date, String image) {
        this.nom = nom;
        this.localisation = localisation;
        this.prix = prix;
        this.nbplaces = nbplaces;
        this.date = date;
        this.image = image;
    }

    public Randonne(int id, int IdActiv, String nom, String localisation, float prix, int nbplaces, Date date, String image) {
        this.id = id;
        this.IdActiv = IdActiv;
        this.nom = nom;
        this.localisation = localisation;
        this.prix = prix;
        this.nbplaces = nbplaces;
        this.date = date;
        this.image = image;
    }


 

    public void setIdActiv(int IdActiv) {
        this.IdActiv = IdActiv;
    }

    public int getIdActiv() {
        return IdActiv;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Randonne{" + "id=" + id + ", nom=" + nom + ", nb_places=" + nbplaces + ", localisation=" + localisation + ", date=" + date + ", prix=" + prix + ", IdActiv=" + IdActiv + ", image=" + image + '}';
    }

    public Randonne(int IdActiv, String nom, String localisation, float prix, int nbplaces, Date date, String image) {
        this.IdActiv = IdActiv;
        this.nom = nom;
        this.localisation = localisation;
        this.prix = prix;
        this.nbplaces = nbplaces;
        this.date = date;
        this.image = image;
    }


 

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public String getLocalisation() {
        return localisation;
    }

    public Date getDate() {
        return date;
    }

    public float getPrix() {
        return prix;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbplaces(int nb_places) {
        this.nbplaces = nbplaces;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Randonne() {
    }

}