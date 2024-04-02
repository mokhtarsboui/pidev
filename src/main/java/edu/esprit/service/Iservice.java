package edu.esprit.service;

import java.util.Set;

public interface Iservice <T>{
    public void ajouter(T t);
    public void modifier(T t);
    public void supprimer (int id);
    public Set<T> getall();
    public T getOneById (int id);


}
