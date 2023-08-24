package com.application.Agence;

import com.application.Agence.Model.Employer;
import com.application.Agence.Model.Payment;
import com.application.Agence.Repository.PaymentDAO;
import com.application.Agence.Service.PaymentService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TestPayment implements InterfaceTestFactory{
    java.sql.Date date = java.sql.Date.valueOf("2023-08-24");
    @Test
    @Override
    public void TestFindById() {
        PaymentDAO paymentDAO = mock(PaymentDAO.class);
        PaymentService paymentService = new PaymentService(paymentDAO);

        int id = 1 ;
        Payment payment = new Payment(1,1,2000,date,"carte de credit");
        when(paymentService.FindById(id)).thenReturn(payment);

        Payment result = paymentService.FindById(1);
        assertNotNull(result);
    }
    @Test
    @Override
    public void TestFindAll() {
        PaymentDAO paymentDAO = mock(PaymentDAO.class);
        PaymentService paymentService = new PaymentService(paymentDAO);

        List<Payment> listOfPayment = new ArrayList<>();
        listOfPayment.add(new Payment(1,1,2000,date,"carte de credit"));
        listOfPayment.add(new Payment(2,1,2000,date,"carte de credit"));

        when(paymentService.FindAll()).thenReturn(listOfPayment);
        List<Payment> result = paymentService.FindAll();
        assertNotNull(result);
        assertEquals(2,listOfPayment.size());
    }
    @Test
    @Override
    public void TestPost() {
       PaymentDAO paymentDAO = mock(PaymentDAO.class);
       PaymentService paymentService = new PaymentService(paymentDAO);

       Payment payment = new Payment(1,1,2000,date,"carte de credit");
       when(paymentService.Register(payment)).thenReturn(payment);

       Payment result = paymentService.Register(payment);
       assertNotNull(result);
    }
    @Test
    @Override
    public void TestUpdate() {
        PaymentDAO paymentDAO = mock(PaymentDAO.class);
        PaymentService paymentService = new PaymentService(paymentDAO);

        int id = 1 ;
        Payment payment = new Payment(1,1,2000,date,"carte de credit");
        when(paymentService.Update(id,payment)).thenReturn(payment);

        Payment result = paymentService.Update(id,payment);
        assertNotNull(result);
    }
    @Test
    @Override
    public void TestDelete() {
        PaymentDAO paymentDAO = mock(PaymentDAO.class);
        int id = 1 ;
        paymentDAO.Delete(id);
        verify(paymentDAO).Delete(id);
    }
}
