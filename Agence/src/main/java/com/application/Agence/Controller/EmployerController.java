package com.application.Agence.Controller;

import com.application.Agence.Model.Employer;
import com.application.Agence.Service.EmployerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployerController {
    private EmployerService employer ;

    public EmployerController(EmployerService employer) {this.employer = employer;}
    @GetMapping("/Employer/{id}")
    public Employer showEmployerById(@PathVariable int id ){return employer.FindEmployerById(id);}

    @GetMapping("/Employer")
    public List<Employer> showAllEmployer(){return employer.FindAllEmployer();}

    @PostMapping("/PostEmployer")
    public Employer AddEmployer(@RequestBody  Employer employers){
        return employer.RegiterEmployer(employers);
    }

    @PutMapping("/UpdateEmployer/{id}")
    public  Employer UpdateEmployer(@PathVariable int id , @RequestBody Employer employers ){
        return employer.UpdateEmployer(id,employers);
    }

    @PatchMapping("/UpdateEmployerParcial/{id}")
    public Employer UpdateEmployerParcial(@PathVariable int id , @RequestBody Employer employers){
        return  employer.UpdateEmployerParcial(id,employers);
    }

    @DeleteMapping("/DeleteEmployer/{id}")
    public List<Employer> DeleteEmployer(@PathVariable int id ){
        return employer.DeleteEmployer(id);
    }
}
