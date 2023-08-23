package com.application.Agence.Service;
import com.application.Agence.Model.Payment;
import com.application.Agence.Repository.PaymentDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentService implements InterfaceService {
    private PaymentDAO payment ;

    public PaymentService(PaymentDAO payment) {
        this.payment = payment;
    }

    @Override
    public Payment FindById(int id) {
        return payment.FindById(id);
    }

    @Override
    public List<Payment> FindAll() {
        return payment.FindAll();
    }

    @Override
    public Payment Register(Object entity) {
        Payment payments = (Payment) entity;
        return payment.Register(payments);
    }
    @Override
    public Payment Update(int id, Object entity) {
        Payment payments = (Payment) entity;
        return payment.Update(id,payments);
    }

    @Override
    public Payment UpdatePartial(int id, Object entity) {
        Payment payments = (Payment) entity;
        return payment.UpdatePartial(id,payments) ;
    }

    @Override
    public List<Payment> Delete(int id) {
        return payment.Delete(id);
    }
}
