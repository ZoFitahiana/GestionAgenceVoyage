package com.application.Agence.Service;

import com.application.Agence.Model.Reservation;
import com.application.Agence.Repository.ReservationDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ReservationService implements  InterfaceService{
    private ReservationDAO reservations ;

    public ReservationService(ReservationDAO reservations) {
        this.reservations = reservations;
    }

    @Override
    public Reservation FindById(int id) {
        return reservations.FindById(id);
    }

    @Override
    public List<Reservation> FindAll() {
        return reservations.FindAll();
    }

    @Override
    public Reservation Register(Object entity) {
        Reservation reservation = (Reservation) entity;
        return reservations.Register(reservation);
    }

    @Override
    public Reservation Update(int id, Object entity) {
        Reservation reservation = (Reservation) entity;
        return reservations.Update(id, reservation);
    }

    @Override
    public Reservation UpdatePartial(int id, Object entity) {
        Reservation reservation = (Reservation) entity;
        return reservations.UpdatePartial(id,reservation);
    }

    @Override
    public List<Reservation> Delete(int id) {
        return reservations.Delete(id);
    }
}
