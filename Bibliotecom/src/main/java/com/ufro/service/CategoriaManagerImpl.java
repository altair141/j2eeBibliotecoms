package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Categoria;
import com.ufro.model.dao.CategoriaDAO;

public class CategoriaManagerImpl implements CategoriaManager {
    private CategoriaDAO categoriaDAO;
 
    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }
 
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
 
    @Transactional
    public boolean save(Categoria contact) {
        try {
            categoriaDAO.saveOrUpdate(contact);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Categoria contact) {
        try {
            categoriaDAO.delete(contact);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Categoria getCategoria(Integer id) {
        try {
            return categoriaDAO.find(Categoria.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Categoria> getCategoriaList() {
        try {
            return categoriaDAO.findAll(Categoria.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}