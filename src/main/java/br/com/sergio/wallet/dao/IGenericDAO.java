package br.com.sergio.wallet.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable  > {

    public void initDAOSession();
    public T getById(Integer id);
    public void saveOrUpdate(T object);
    public List<T> list(Criteria criteria);
    public void closeSession();

}
