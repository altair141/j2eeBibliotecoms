package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Prestamo;

public class PrestamoDAO extends HibernateDaoSupport {
    public void saveOrUpdate(Prestamo prestamo) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(prestamo);
    }
 
    public void delete(Prestamo prestamo) throws DataAccessException {
        getHibernateTemplate().delete(prestamo);
    }
 
    public Prestamo find(Class<Prestamo> clazz, Integer id) throws DataAccessException {
        Prestamo prestamo = (Prestamo) getHibernateTemplate().load(clazz, id);
        return prestamo;
    }
     
    public List<Prestamo> findAll(Class<Prestamo> clazz) throws DataAccessException {
        List<Prestamo> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
