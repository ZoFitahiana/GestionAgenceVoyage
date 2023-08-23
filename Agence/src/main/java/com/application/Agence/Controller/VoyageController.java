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
    public Voyage showVoyageById(@PathVariable int id ){
        return voyages.FindById(id);
    }

    @GetMapping("/voyage")
    public List<Voyage> showAllVoyage(){
        return  voyages.FindAll();
    }

    @PostMapping("/post-voyage")
    public Voyage PostVoyage(@RequestBody Voyage Newvoyage){
        return voyages.Register(Newvoyage);
    }
    @PutMapping("/update-voyage/{id}")
    public Voyage UpdateVoyage(@PathVariable  int id , @RequestBody Voyage voyage){
        return voyages.Update(id,voyage);
    }

    @PatchMapping("/update-partial-voyage/{id}")
    public  Voyage UpdateVoyages(@PathVariable int id ,@RequestBody Voyage voyage){
        return voyages.UpdatePartial(id,voyage);
    }

    @DeleteMapping("/delete-voyage/{id}")
    public List<Voyage> DeleteVoyage(@PathVariable int id ){
        return voyages.Delete(id);
    }


}
