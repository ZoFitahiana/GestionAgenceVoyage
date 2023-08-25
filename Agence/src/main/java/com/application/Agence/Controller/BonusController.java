package com.application.Agence.Controller;

import com.application.Agence.Service.BonusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class BonusController {
    private final BonusService informationReservation;

    public BonusController(BonusService informationReservation) {
        this.informationReservation = informationReservation;
    }
    @GetMapping("/")
    public List<Map<String, Object>> GetInformationReservation(){
        return informationReservation.GetInformationReservation();
    }
}
