package com.application.Agence.Service;

import com.application.Agence.Model.Employer;
import com.application.Agence.Repository.EmployerDAO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data

@Service
public class EmployerService {
    private EmployerDAO employer ;
    public EmployerService(EmployerDAO employer) {this.employer = employer;}

    public Employer FindEmployerById(int id ){return employer.FindById(id);}

    public List<Employer> FindAllEmployer(){return employer.FindAll();}

    public Employer RegiterEmployer(Employer employers){return employer.Register(employers);}

    public Employer UpdateEmployer(int id ,Employer employers){return  employer.Update(id,employers);}

    public Employer UpdateEmployerParcial(int id , Employer employers ){
        return  employer.UpdatePartial(id,employers);
    }

    public List<Employer> DeleteEmployer(int id ){return  employer.Delete(id);}

}
