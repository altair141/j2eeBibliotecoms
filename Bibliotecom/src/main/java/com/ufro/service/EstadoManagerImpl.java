package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Estado;
import com.ufro.model.dao.EstadoDAO;

public class EstadoManagerImpl implements EstadoManager {
    private EstadoDAO estadoDAO;
 
    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }
 
    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }
 
    @Transactional
    public boolean save(Estado estado) {
        try {
            estadoDAO.saveOrUpdate(estado);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Estado estado) {
        try {
            estadoDAO.delete(estado);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Estado getEstado(Integer id) {
        try {
            return estadoDAO.find(Estado.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Estado> getEstadoList() {
        try {
            return estadoDAO.findAll(Estado.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}