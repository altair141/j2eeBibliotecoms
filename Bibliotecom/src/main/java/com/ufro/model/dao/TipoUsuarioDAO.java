package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.TipoUsuario;

public class TipoUsuarioDAO extends HibernateDaoSupport {
    public void saveOrUpdate(TipoUsuario tipoUsuario) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(tipoUsuario);
    }
 
    public void delete(TipoUsuario tipoUsuario) throws DataAccessException {
        getHibernateTemplate().delete(tipoUsuario);
    }
 
    public TipoUsuario find(Class<TipoUsuario> clazz, Integer id) throws DataAccessException {
        TipoUsuario tipoUsuario = (TipoUsuario) getHibernateTemplate().load(clazz, id);
        return tipoUsuario;
    }
     
    public List<TipoUsuario> findAll(Class<TipoUsuario> clazz) throws DataAccessException {
        List<TipoUsuario> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
