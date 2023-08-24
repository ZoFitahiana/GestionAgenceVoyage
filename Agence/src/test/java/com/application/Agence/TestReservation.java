package com.application.Agence;

import com.application.Agence.Model.Payment;
import com.application.Agence.Model.Reservation;
import com.application.Agence.Repository.ReservationDAO;
import com.application.Agence.Service.ReservationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TestReservation implements  InterfaceTestFactory{
    java.sql.Date date = java.sql.Date.valueOf("2023-08-24");
    @Test
    @Override
    public void TestFindById() {
        ReservationDAO reservationDAO = mock(ReservationDAO.class);
        ReservationService reservationService = new ReservationService(reservationDAO);

        int id = 1 ;
        Reservation reservation = new Reservation(1,1,1,1,date,"confirmé",22);
        when(reservationService.FindById(id)).thenReturn(reservation);

        Reservation resultat = reservationService.FindById(id);
        assertNotNull(resultat);

    }
    @Test
    @Override
    public void TestFindAll() {
        ReservationDAO reservationDAO = mock(ReservationDAO.class);
        ReservationService reservationService = new ReservationService(reservationDAO);

        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add( new Reservation(1,1,1,1,date,"confirmé",22));
        reservationList.add( new Reservation(1,1,1,1,date,"confirmé",22));
        when(reservationService.FindAll()).thenReturn(reservationList);

        List<Reservation> reservations = reservationService.FindAll();
        assertNotNull(reservations);
        assertEquals(2,reservations.size());
    }
    @Test
    @Override
    public void TestPost() {
        ReservationDAO reservationDAO = mock(ReservationDAO.class);
        ReservationService reservationService = new ReservationService(reservationDAO);

        Reservation reservation = new Reservation(1,1,1,1,date,"confirmé",22);
        when(reservationService.Register(reservation)).thenReturn(reservation);

        Reservation result = reservationService.Register(reservation);
        assertNotNull(result);
    }
    @Test
    @Override
    public void TestUpdate() {
        ReservationDAO reservations = mock(ReservationDAO.class);
        ReservationService reservationService = new ReservationService(reservations);

        int id = 1 ;
        Reservation reservation = new Reservation(1,1,1,1,date,"confirmé",22);
        when(reservationService.Update(id,reservation)).thenReturn(reservation);

        Reservation result = reservationService.Update(1,reservation);
        assertNotNull(result);

    }
    @Test
    @Override
    public void TestDelete() {
         ReservationDAO reservationDAO = mock(ReservationDAO.class);
         int id = 1 ;
         reservationDAO.Delete(id);
         verify(reservationDAO).Delete(id);
       }
}
