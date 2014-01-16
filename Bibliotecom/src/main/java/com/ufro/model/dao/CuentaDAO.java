package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Cuenta;

public class CuentaDAO extends HibernateDaoSupport {
    public void saveOrUpdate(Cuenta cuenta) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(cuenta);
    }
 
    public void delete(Cuenta cuenta) throws DataAccessException {
        getHibernateTemplate().delete(cuenta);
    }
 
    public Cuenta find(Class<Cuenta> clazz, Integer id) throws DataAccessException {
        Cuenta cuenta = (Cuenta) getHibernateTemplate().load(clazz, id);
        return cuenta;
    }
     
    public List<Cuenta> findAll(Class<Cuenta> clazz) throws DataAccessException {
        List<Cuenta> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
