package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Prestamo;
import com.ufro.model.dao.PrestamoDAO;

public class PrestamoManagerImpl implements PrestamoManager {
    private PrestamoDAO prestamoDAO;
 
    public PrestamoDAO getPrestamoDAO() {
        return prestamoDAO;
    }
 
    public void setPrestamoDAO(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }
 
    @Transactional
    public boolean save(Prestamo prestamo) {
        try {
            prestamoDAO.saveOrUpdate(prestamo);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Prestamo prestamo) {
        try {
            prestamoDAO.delete(prestamo);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Prestamo getPrestamo(Integer id) {
        try {
            return prestamoDAO.find(Prestamo.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Prestamo> getPrestamoList() {
        try {
            return prestamoDAO.findAll(Prestamo.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}