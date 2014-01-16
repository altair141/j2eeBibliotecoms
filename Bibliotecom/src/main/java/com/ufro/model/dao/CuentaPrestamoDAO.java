package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.CuentaPrestamo;


public class CuentaPrestamoDAO extends HibernateDaoSupport {
    public void saveOrUpdate(CuentaPrestamo cuentaPrestamo) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(cuentaPrestamo);
    }
 
    public void delete(CuentaPrestamo cuentaPrestamo) throws DataAccessException {
        getHibernateTemplate().delete(cuentaPrestamo);
    }
 
    public CuentaPrestamo find(Class<CuentaPrestamo> clazz, Integer id) throws DataAccessException {
        CuentaPrestamo cuentaPrestamo = (CuentaPrestamo) getHibernateTemplate().load(clazz, id);
        return cuentaPrestamo;
    }
     
    public List<CuentaPrestamo> findAll(Class<CuentaPrestamo> clazz) throws DataAccessException {
        List<CuentaPrestamo> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
