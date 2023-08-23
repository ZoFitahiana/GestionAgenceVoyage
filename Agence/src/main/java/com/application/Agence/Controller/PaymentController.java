package com.application.Agence.Controller;

import com.application.Agence.Model.Payment;
import com.application.Agence.Service.PaymentService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PaymentController {
    private PaymentService payment;

    public PaymentController(PaymentService payment) {
        this.payment = payment;
    }
    @GetMapping("/payment/{id}")
    public Payment showPaymentById(@PathVariable int id ){
        return payment.FindById(id);
    }
    @GetMapping("/payment")
    public List<Payment> showAllPayment(){
        return  payment.FindAll();
    }
    @PostMapping("/post-payment")
    public Payment PostPayment(@RequestBody Payment payments){
        return payment.Register(payments);
    }
    @PutMapping("/update-payment/{id}")
    public Payment UpdatePayment(@PathVariable int id ,@RequestBody Payment payments){
        return  payment.Update(id,payments);
    }
    @PatchMapping("/update-partial-payment/{id}")
    public Payment UpdateParcialPayment(@PathVariable  int id ,@RequestBody Payment payments){
        return payment.UpdatePartial(id,payments);
    }
    @DeleteMapping("/delete-payment/{id}")
    public List<Payment> DeletePayment(@PathVariable  int id){
        return   payment.Delete(id);
    }
}
