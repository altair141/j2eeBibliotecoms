package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Usuario;
import com.ufro.model.dao.UsuarioDAO;

public class UsuarioManagerImpl implements UsuarioManager {
    private UsuarioDAO usuarioDAO;
 
    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }
 
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
 
    @Transactional
    public boolean save(Usuario usuario) {
        try {
            usuarioDAO.saveOrUpdate(usuario);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Usuario usuario) {
        try {
            usuarioDAO.delete(usuario);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Usuario getUsuario(Integer id) {
        try {
            return usuarioDAO.find(Usuario.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarioList() {
        try {
            return usuarioDAO.findAll(Usuario.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}