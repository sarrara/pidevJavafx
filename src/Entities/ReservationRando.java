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
public class ReservationRando {
    int id ,event_id,rando_id,user_id;
    int transport,nourriture;

    public ReservationRando(int id, int event_id, int rando_id, int user_id, int transport, int nourriture) {
        this.id = id;
        this.event_id = event_id;
        this.rando_id = rando_id;
        this.user_id = user_id;
        this.transport = transport;
        this.nourriture = nourriture;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", event_id=" + event_id + ", rando_id=" + rando_id + ", user_id=" + user_id + ", transport=" + transport + ", nourriture=" + nourriture + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setRando_id(int rando_id) {
        this.rando_id = rando_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTransport(int transport) {
        this.transport = transport;
      
    }

    public void setNourriture(int nourriture) {
        this.nourriture = nourriture;
    }

    public int getId() {
        return id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getRando_id() {
        return rando_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int isTransport() {
        return transport;
    }

    public int isNourriture() {
        return nourriture;
        
    }
    int boolToInt(boolean b) {
    return Boolean.compare(b, false);
}
}
