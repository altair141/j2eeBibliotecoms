package com.ufro.model.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Categoria;

public class CategoriaDAO extends HibernateDaoSupport {
	 
    public void saveOrUpdate(Categoria categoria) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(categoria);
    }
 
    public void delete(Categoria categoria) throws DataAccessException {
        getHibernateTemplate().delete(categoria);
    }
 
    public Categoria find(Class<Categoria> clazz, Integer id) throws DataAccessException {
        Categoria categoria = (Categoria) getHibernateTemplate().load(clazz, id);
        return categoria;
    }
     
    public List<Categoria> findAll(Class<Categoria> clazz) throws DataAccessException {
        List<Categoria> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}