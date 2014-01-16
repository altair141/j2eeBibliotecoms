package com.ufro.model.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Articulo;

public class ArticuloDAO extends HibernateDaoSupport {
	 
    public void saveOrUpdate(Articulo articulo) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(articulo);
    }
 
    public void delete(Articulo articulo) throws DataAccessException {
        getHibernateTemplate().delete(articulo);
    }
 
    public Articulo find(Class<Articulo> clazz, Integer id) throws DataAccessException {
        Articulo articulo = (Articulo) getHibernateTemplate().load(clazz, id);
        return articulo;
    }
     
    public List<Articulo> findAll(Class<Articulo> clazz) throws DataAccessException {
        List<Articulo> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}