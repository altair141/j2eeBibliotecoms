package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Libro;

public class LibroDAO extends HibernateDaoSupport {
    public void saveOrUpdate(Libro libro) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(libro);
    }
 
    public void delete(Libro libro) throws DataAccessException {
        getHibernateTemplate().delete(libro);
    }
 
    public Libro find(Class<Libro> clazz, Integer id) throws DataAccessException {
        Libro libro = (Libro) getHibernateTemplate().load(clazz, id);
        return libro;
    }
     
    public List<Libro> findAll(Class<Libro> clazz) throws DataAccessException {
        List<Libro> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
