package com.application.Agence.Service;

import java.util.List;

public interface InterfaceService<T> {
    public T FindById(int id);
    public List<T> FindAll();
    public T Register(T entity);
    public T Update(int id, T entity);
    public T UpdatePartial(int id, T entity);
    public List<T> Delete(int id);

}
