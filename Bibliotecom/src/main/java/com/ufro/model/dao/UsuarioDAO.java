package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Usuario;

public class UsuarioDAO extends HibernateDaoSupport {
    public void saveOrUpdate(Usuario usuario) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(usuario);
    }
 
    public void delete(Usuario usuario) throws DataAccessException {
        getHibernateTemplate().delete(usuario);
    }
 
    public Usuario find(Class<Usuario> clazz, Integer id) throws DataAccessException {
        Usuario usuario = (Usuario) getHibernateTemplate().load(clazz, id);
        return usuario;
    }
     
    public List<Usuario> findAll(Class<Usuario> clazz) throws DataAccessException {
        List<Usuario> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
