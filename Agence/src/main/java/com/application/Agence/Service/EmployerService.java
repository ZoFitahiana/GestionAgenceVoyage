package com.application.Agence.Service;

import com.application.Agence.Model.Employer;
import com.application.Agence.Repository.EmployerDAO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data

@Service
public class EmployerService implements InterfaceService{
    private EmployerDAO employer ;
    public EmployerService(EmployerDAO employer) {
        this.employer = employer;
    }

    @Override
    public Employer FindById(int id) {
        return employer.FindById(id);
    }

    @Override
    public List<Employer> FindAll() {
        return employer.FindAll();
    }

    @Override
    public Employer Register(Object entity) {
        Employer employers = (Employer) entity;
        return employer.Register(employers) ;
    }

    @Override
    public Employer Update(int id, Object entity) {
        Employer employers = (Employer) entity;
        return employer.Update(id,employers);
    }

    @Override
    public Employer UpdatePartial(int id, Object entity) {
        Employer employers = (Employer) entity;
        return employer.UpdatePartial(id,employers);
    }

    @Override
    public List<Employer> Delete(int id) {
        return employer.Delete(id);
    }
}
