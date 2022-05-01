/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Sarra
 */
public class Activite {
    private int  id;
    private String Nom, description;

    public Activite(String Nom, String description) {
        this.Nom = Nom;
        this.description = description;
    }



    @Override
    public String toString() {
        return "Activite{" + "id=" + id + ", Nom=" + Nom + ", description=" + description + '}';
    }

    public Activite(int id, String Nom, String description) {
        this.id = id;
        this.Nom = Nom;
        this.description = description;
    }

    public Activite() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
