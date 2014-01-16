package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Articulo;
import com.ufro.model.dao.ArticuloDAO;

public class ArticuloManagerImpl implements ArticuloManager {
    private ArticuloDAO articuloDAO;
 
    public ArticuloDAO getArticuloDAO() {
        return articuloDAO;
    }
 
    public void setArticuloDAO(ArticuloDAO articuloDAO) {
        this.articuloDAO = articuloDAO;
    }
 
    @Transactional
    public boolean save(Articulo contact) {
        try {
            articuloDAO.saveOrUpdate(contact);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Articulo contact) {
        try {
            articuloDAO.delete(contact);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Articulo getArticulo(Integer id) {
        try {
            return articuloDAO.find(Articulo.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Articulo> getArticuloList() {
        try {
            return articuloDAO.findAll(Articulo.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}