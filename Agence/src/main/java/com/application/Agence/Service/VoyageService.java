package com.application.Agence.Service;

import com.application.Agence.Model.Voyage;
import com.application.Agence.Repository.VoyageDAO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data

public class VoyageService {
    private VoyageDAO voyages;

    public VoyageService(VoyageDAO voyages) {
        this.voyages = voyages;
    }

    public Voyage findByIdVoyage(int id ){return voyages.FindById(id);}
    public List<Voyage> FindAllVoyage(){return  voyages.FindAll();}

    public Voyage PostVoyage(Voyage voyage){return  voyages.Register(voyage);}

    public  Voyage Update(int id ,Voyage entity){return voyages.Update(id , entity);}

    public  Voyage UpdateVoyageParcial(int id , Voyage entity){return  voyages.UpdatePartial(id , entity);}

    public List<Voyage> DeleteVoyage(int id ){return voyages.Delete(id);}

}

