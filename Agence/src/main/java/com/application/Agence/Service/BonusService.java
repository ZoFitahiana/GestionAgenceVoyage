package com.application.Agence.Service;

import com.application.Agence.Repository.Bonus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service

public class BonusService {
    private final Bonus informationReservation ;

    public BonusService(Bonus informationReservation) {
        this.informationReservation = informationReservation;
    }

    public List<Map<String, Object>> GetInformationReservation(){
        return  informationReservation.getReservationInfo();
    }
}
