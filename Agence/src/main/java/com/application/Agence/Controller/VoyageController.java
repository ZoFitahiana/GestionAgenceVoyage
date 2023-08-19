package com.application.Agence.Controller;

import com.application.Agence.Model.Voyage;
import com.application.Agence.Service.VoyageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoyageController {
    private VoyageService voyages ;

    public VoyageController(VoyageService voyages) {this.voyages = voyages;}

    @GetMapping("/voyage/{id}")
    public Voyage showVoyageById(@PathVariable int id ){return voyages.findByIdVoyage(id);}

    @GetMapping("/voyage")
    public List<Voyage> showAllVoyage(){return  voyages.FindAllVoyage();}

    @PostMapping("/PostVoyage")
    public Voyage PostVoyage(@RequestBody Voyage Newvoyage){return voyages.PostVoyage(Newvoyage);}
    @PutMapping("/UpdateVoyage/{id}")
    public Voyage UpdateVoyage(@PathVariable  int id , @RequestBody Voyage voyage){return voyages.Update(id,voyage);}

    @PatchMapping("/UpdateVoyageParcial/{id}")
    public  Voyage UpdateVoyages(@PathVariable int id ,@RequestBody Voyage voyage){
        return voyages.UpdateVoyageParcial(id,voyage);
    }

    @DeleteMapping("/DeleteVoyage/{id}")
    public List<Voyage> DeleteVoyage(@PathVariable int id ){return voyages.DeleteVoyage(id);}


}
