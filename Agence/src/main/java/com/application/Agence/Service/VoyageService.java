package com.application.Agence.Service;

import com.application.Agence.Model.Reservation;
import com.application.Agence.Model.Voyage;
import com.application.Agence.Repository.VoyageDAO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data

public class VoyageService implements InterfaceService {
    private VoyageDAO voyages;

    public VoyageService(VoyageDAO voyages) {
        this.voyages = voyages;
    }


    @Override
    public Voyage FindById(int id) {
        return voyages.FindById(id);
    }

    @Override
    public List<Voyage> FindAll() {
        return voyages.FindAll();
    }

    @Override
    public Voyage Register(Object entity) {
        Voyage voyage = (Voyage) entity;
        return voyages.Register(voyage);
    }

    @Override
    public Voyage Update(int id, Object entity) {
        Voyage voyage = (Voyage) entity;
        return voyages.Update(id,voyage);
    }

    @Override
    public Voyage UpdatePartial(int id, Object entity) {
        Voyage voyage = (Voyage) entity;
        return voyages.UpdatePartial(id,voyage);
    }

    @Override
    public List<Voyage> Delete(int id) {
        return voyages.Delete(id);
    }
}

