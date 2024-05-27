package org.Yaed.services;

import org.Yaed.dao.GenericDAOImpl;
import org.Yaed.dao.IGenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GenericServiceImpl <T> implements IGenericService<T>{
    private IGenericDAO <T> dao;
    private Class <T> cl;
    SessionFactory session;
    public GenericServiceImpl (Class<T> cl, SessionFactory sessionFactory){
        this.cl=cl;
        dao = new GenericDAOImpl<>(cl, sessionFactory);
        session = sessionFactory;
    }

    @Override
    public T get(Class<T> cl, Integer id) {

        return (T) dao.get(cl,id);
    }

    @Override
    public T get(Class <T> CL, Long id) {
        return null;
    }

    @Override
    public T save(T object) {
        return (T) dao.save(object);
    }

    @Override
    public void update(T object) {
        dao.update(object);

    }

    @Override
    public void delete(T object) {
        dao.delete(object);

    }

    @Override
    public List<T> query(String hsql, Map<String, Objects> params) {

        return (List<T>) dao.query(hsql, params);
    }

    @Override
    public List<T> getAll() {
        return (List <T> ) dao.query("FROM "+ cl.getSimpleName(), null) == null ? null : dao.query("FROM "+ cl.getSimpleName(), null);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public T getById(int i) {
        return null;
    }

    @Override
    public T getId(Long i) {
        return null;
    }

    @Override
    public T getByName(String name) {
        return null;
    }
}
