package com.application.Agence.Repository;

import java.util.List;

public interface ModelDAOFactory<T>{
    public T FindById(int id);
    public List<T> FindAll();
    public T Register(T entity);
    public T Update(int id, T entity);
    public T UpdatePartial(int id, T entity);
    public List<T> Delete(int id);

}
