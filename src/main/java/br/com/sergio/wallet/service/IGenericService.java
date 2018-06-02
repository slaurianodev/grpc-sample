package br.com.sergio.wallet.service;

import br.com.sergio.wallet.dao.IGenericDAO;

import java.util.List;


public interface IGenericService<T> extends IGenericDAO<T> {
    List<T> getAll();
    void deleteAll();
}
