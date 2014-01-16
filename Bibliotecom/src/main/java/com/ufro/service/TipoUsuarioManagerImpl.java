package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.TipoUsuario;
import com.ufro.model.dao.TipoUsuarioDAO;

public class TipoUsuarioManagerImpl implements TipoUsuarioManager {
    private TipoUsuarioDAO tipoUsuarioDAO;
 
    public TipoUsuarioDAO getTipoUsuarioDAO() {
        return tipoUsuarioDAO;
    }
 
    public void setTipoUsuarioDAO(TipoUsuarioDAO tipoUsuarioDAO) {
        this.tipoUsuarioDAO = tipoUsuarioDAO;
    }
 
    @Transactional
    public boolean save(TipoUsuario tipoUsuario) {
        try {
            tipoUsuarioDAO.saveOrUpdate(tipoUsuario);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(TipoUsuario tipoUsuario) {
        try {
            tipoUsuarioDAO.delete(tipoUsuario);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public TipoUsuario getTipoUsuario(Integer id) {
        try {
            return tipoUsuarioDAO.find(TipoUsuario.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<TipoUsuario> getTipoUsuarioList() {
        try {
            return tipoUsuarioDAO.findAll(TipoUsuario.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}