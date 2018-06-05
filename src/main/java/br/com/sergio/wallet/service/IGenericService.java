package br.com.sergio.wallet.service;

import br.com.sergio.wallet.dao.IGenericDAO;

import java.io.Serializable;
import java.util.List;


public interface IGenericService<T extends Serializable> extends IGenericDAO<T> {
    List<T> getAll();
    void deleteAll();
}
