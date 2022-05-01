/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.ReservationRando;
import java.util.List;

/**
 *
 * @author Sarra
 */
public interface IReservation <T> {
 void updateResrvRando(int id, int event_id, int rando_id, int user_id, int transport, int nourriture);
  void insert(ReservationRando r);
     List<ReservationRando> readAll();
      void delete(int id);
}
