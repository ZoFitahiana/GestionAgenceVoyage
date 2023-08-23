package com.application.Agence.Controller;

import com.application.Agence.Model.Reservation;
import com.application.Agence.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ReservationController {


    private ReservationService resevations ;
    public ReservationController(ReservationService resevations) {
        this.resevations = resevations;
    }

    @GetMapping("/reservation/{id}")
    public Reservation ShowReservationById(@PathVariable int id ){
        return  resevations.FindById(id);
    }

    @GetMapping("/reservation")
    public List<Reservation> ShowAllReservation(){
        return resevations.FindAll();
    }

    @PostMapping("/post-reservation")
    public Reservation PostReservation(@RequestBody  Reservation reservation){
        return resevations.Register(reservation);
    }

    @PutMapping("/update-reservation/{id}")
    public  Reservation UpdateReservation(@PathVariable int id ,@RequestBody Reservation reservation){
        return  resevations.Update(id,reservation);
    }

    @PatchMapping("/update-partial-reservation/{id}")
    public  Reservation updatePartial(@PathVariable int id , @RequestBody Reservation reservation){
        return resevations.UpdatePartial(id,reservation);
    }
    
    @DeleteMapping("/delete-reservation/{id}")
    public List<Reservation> deleteReservation(@PathVariable int id){
        return resevations.Delete(id);
    }
}
