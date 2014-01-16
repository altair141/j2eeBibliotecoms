package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Estado;

public class EstadoDAO extends HibernateDaoSupport {
    public void saveOrUpdate(Estado estado) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(estado);
    }
 
    public void delete(Estado estado) throws DataAccessException {
        getHibernateTemplate().delete(estado);
    }
 
    public Estado find(Class<Estado> clazz, Integer id) throws DataAccessException {
        Estado estado = (Estado) getHibernateTemplate().load(clazz, id);
        return estado;
    }
     
    public List<Estado> findAll(Class<Estado> clazz) throws DataAccessException {
        List<Estado> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
