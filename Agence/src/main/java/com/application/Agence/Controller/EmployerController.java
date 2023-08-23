package com.application.Agence.Controller;

import com.application.Agence.Model.Employer;
import com.application.Agence.Service.EmployerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployerController {
    private EmployerService employer ;

    public EmployerController(EmployerService employer) {this.employer = employer;}
    @GetMapping("/employer/{id}")
    public Employer showEmployerById(@PathVariable int id ){
        return employer.FindById(id);
    }

    @GetMapping("/employer")
    public List<Employer> showAllEmployer(){
        return employer.FindAll();
    }

    @PostMapping("/post-employer")
    public Employer AddEmployer(@RequestBody  Employer employers){
        return employer.Register(employers);
    }

    @PutMapping("/update-employer/{id}")
    public  Employer UpdateEmployer(@PathVariable int id , @RequestBody Employer employers ){
        return employer.Update(id,employers);
    }

    @PatchMapping("/update-partial-employer/{id}")
    public Employer UpdateEmployerParcial(@PathVariable int id , @RequestBody Employer employers){
        return  employer.UpdatePartial(id,employers);
    }

    @DeleteMapping("/delete-employer/{id}")
    public List<Employer> DeleteEmployer(@PathVariable int id ){
        return employer.Delete(id);
    }
}
