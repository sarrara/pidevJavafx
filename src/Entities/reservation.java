/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class reservation {
    private int id;
    private int nourriture;
    private int transport;
    private String info_supp;
    //private int idevent;
    private int iduser;
     private int idrando;

    public reservation(String info_supp) {
       this.info_supp = info_supp;
    }

    public void setIdrando(int idrando) {
        this.idrando = idrando;
    }

    public reservation(int id, int nourriture, int transport, String info_supp,  int iduser, int idrando) {
        this.id = id;
        this.nourriture = nourriture;
        this.transport = transport;
        this.info_supp = info_supp;
       // this.idevent = idevent;
        this.iduser = iduser;
        this.idrando = idrando;
    }

    public int getIdrando() {
        return idrando;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }*/

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

   /* public reservation(int id, int nourriture, int transport, String info_supp, int idevent, int iduser) {
        this.id = id;
        this.nourriture = nourriture;
        this.transport = transport;
        this.info_supp = info_supp;
        this.idevent = idevent;
        this.iduser = iduser;
    }*/
   /* public reservation( int nourriture, int transport, String info_supp, int idevent, int iduser) {
        
        this.nourriture = nourriture;
        this.transport = transport;
        this.info_supp = info_supp;
        this.idevent = idevent;
        this.iduser = iduser;
    }*/
    
 public int getNourriture() {
        return nourriture;
    }
 
  public int getTransport() {
        return transport;
    }

    public int isNourriture() {
        return nourriture;
    }

    public void setNourriture(int nourriture) {
        this.nourriture = nourriture;
    }

    public int isTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public String getInfo_supp() {
        return info_supp;
    }

    public void setInfo_supp(String info_supp) {
        this.info_supp = info_supp;
    }

    public reservation(int id, int nourriture, int transport, String info_supp) {
        this.id = id;
        this.nourriture = nourriture;
        this.transport = transport;
        this.info_supp = info_supp;
    }
public reservation( int nourriture, int transport, String info_supp) {
       
        this.nourriture = nourriture;
        this.transport = transport;
        this.info_supp = info_supp;
       
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        
        hash = 17 * hash + Objects.hashCode(this.info_supp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final reservation other = (reservation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nourriture != other.nourriture) {
            return false;
        }
        if (!Objects.equals(this.info_supp, other.info_supp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reservation{" + "id=" + id + ", nourriture=" + nourriture + ", transport=" + transport + ", info_supp=" + info_supp +  ", iduser=" + iduser + ", idrando=" + idrando + '}';
    }

    public void getIdrando(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
