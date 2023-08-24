package com.application.Agence;


import com.application.Agence.Model.Employer;
import com.application.Agence.Repository.EmployerDAO;
import com.application.Agence.Service.EmployerService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TestEmployer implements InterfaceTestFactory{
    java.sql.Date date = java.sql.Date.valueOf("2023-08-24");
    @Test
    @Override
    public void TestFindById() {
        EmployerDAO employerDAO = mock(EmployerDAO.class);
        EmployerService employerService = new EmployerService(employerDAO);

        Employer employer = new Employer(1, "Toky", "Mahery", "Directeur", "ivandry", "1234567", date);
        int id = 1 ;

        when(employerService.FindById(id)).thenReturn(employer);
        Employer result = employerService.FindById(1);
        assertNotNull(result);
    }
    @Test
    @Override
    public void TestFindAll() {
        EmployerDAO employerDAO = mock(EmployerDAO.class);
        EmployerService employerService = new EmployerService(employerDAO);

        List<Employer> ListOfEmployer = new ArrayList<>();
        ListOfEmployer.add(new Employer(1, "Toky", "Mahery", "Directeur", "ivandry", "1234567", date));
        ListOfEmployer.add(new Employer(2, "Toky", "Mahery", "Directeur", "ivandry", "1234567", date));

        when(employerService.FindAll()).thenReturn(ListOfEmployer);
        List<Employer> resultat = employerService.FindAll();
        assertNotNull(resultat);
        assertEquals(2, resultat.size());

    }
    @Test
    @Override
    public void TestPost() {
        EmployerDAO employerDAO = mock(EmployerDAO.class);
        EmployerService employerService = new EmployerService(employerDAO);

        Employer employer = new Employer(1, "Toky", "Mahery", "Directeur", "ivandry", "1234567", date);
        when(employerService.Register(employer)).thenReturn(employer);

        Employer result = employerService.Register(employer);
        assertNotNull(result);


    }
    @Test
    @Override
    public void TestUpdate() {
        EmployerDAO employerDAO = mock(EmployerDAO.class);
        EmployerService employerService = new EmployerService(employerDAO);

        Employer employer = new Employer(1, "Toky", "Mahery", "Directeur", "ivandry", "1234567", date);
        int id = 1 ;
        when(employerService.Update(id,employer)).thenReturn(employer);

        Employer result = employerService.Update(id,employer);
        assertNotNull(result);
    }
    @Test
    @Override
    public void TestDelete() {
        EmployerDAO employer = mock(EmployerDAO.class);
        int id = 1;
        employer.Delete(id);
        verify(employer).Delete(id);

    }
}
