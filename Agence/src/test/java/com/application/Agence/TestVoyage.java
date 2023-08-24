package com.application.Agence;

import com.application.Agence.Model.Reservation;
import com.application.Agence.Model.Voyage;
import com.application.Agence.Repository.VoyageDAO;
import com.application.Agence.Service.VoyageService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TestVoyage implements  InterfaceTestFactory{
    java.sql.Date date = java.sql.Date.valueOf("2023-08-24");
    @Test
    @Override
    public void TestFindById() {
        VoyageDAO voyageDAO = mock(VoyageDAO.class);
        VoyageService voyageService = new VoyageService(voyageDAO);

        int id = 1 ;
        Voyage voyage = new Voyage(1,"MADAGASCAR",date,2,"Tour madagascar",200,8);
        when(voyageService.FindById(id)).thenReturn(voyage);

        Voyage result = voyageService.FindById(1);
        assertNotNull(result);
    }
    @Test
    @Override
    public void TestFindAll() {
        VoyageDAO voyageDAO= mock(VoyageDAO.class);
        VoyageService voyageService = new VoyageService(voyageDAO);

        List<Voyage> voyageList = new ArrayList<>();
        voyageList.add(new Voyage(1,"MADAGASCAR",date,2,"Tour madagascar",200,8));
        voyageList.add(new Voyage(2,"MADAGASCAR",date,3,"Tour madagascar",200,8));
        when(voyageService.FindAll()).thenReturn(voyageList);

        List<Voyage> result = voyageService.FindAll();
        assertNotNull(result);
        assertEquals(2,result.size());
    }
    @Test
    @Override
    public void TestPost() {
         VoyageDAO voyageDAO = mock(VoyageDAO.class);
         VoyageService voyageService = new VoyageService(voyageDAO);

         Voyage voyage = new Voyage(1,"MADAGASCAR",date,2,"Tour madagascar",200,8);
         when(voyageService.Register(voyage)).thenReturn(voyage);

         Voyage result = voyageService.Register(voyage);
         assertNotNull(result);
    }
    @Test
    @Override
    public void TestUpdate() {
         VoyageDAO voyageDAO = mock(VoyageDAO.class);
         VoyageService voyageService = new VoyageService(voyageDAO);

         int id = 1;
         Voyage voyage = new Voyage(1,"MADAGASCAR",date,2,"Tour madagascar",200,8);
         when(voyageService.Update(id,voyage)).thenReturn(voyage);

         Voyage result = voyageService.Update(1,voyage);
         assertNotNull(result);
    }
    @Test
    @Override
    public void TestDelete() {
        VoyageDAO voyageDAO = mock(VoyageDAO.class);
        int id = 1 ;
        voyageDAO.Delete(id);
        verify(voyageDAO).Delete(id);
    }
}
