package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Libro;
import com.ufro.model.dao.LibroDAO;

public class LibroManagerImpl implements LibroManager {
    private LibroDAO libroDAO;
 
    public LibroDAO getLibroDAO() {
        return libroDAO;
    }
 
    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }
 
    @Transactional
    public boolean save(Libro libro) {
        try {
            libroDAO.saveOrUpdate(libro);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Libro libro) {
        try {
            libroDAO.delete(libro);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Libro getLibro(Integer id) {
        try {
            return libroDAO.find(Libro.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Libro> getLibroList() {
        try {
            return libroDAO.findAll(Libro.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}