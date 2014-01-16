package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.CuentaPrestamo;
import com.ufro.model.dao.CuentaPrestamoDAO;

public class CuentaPrestamoManagerImpl implements CuentaPrestamoManager {
    private CuentaPrestamoDAO cuentaPrestamoDAO;
 
    public CuentaPrestamoDAO getCuentaPrestamoDAO() {
        return cuentaPrestamoDAO;
    }
 
    public void setCuentaPrestamoDAO(CuentaPrestamoDAO cuentaPrestamoDAO) {
        this.cuentaPrestamoDAO = cuentaPrestamoDAO;
    }
 
    @Transactional
    public boolean save(CuentaPrestamo cuentaPrestamo) {
        try {
            cuentaPrestamoDAO.saveOrUpdate(cuentaPrestamo);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(CuentaPrestamo cuentaPrestamo) {
        try {
            cuentaPrestamoDAO.delete(cuentaPrestamo);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public CuentaPrestamo getCuentaPrestamo(Integer id) {
        try {
            return cuentaPrestamoDAO.find(CuentaPrestamo.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<CuentaPrestamo> getCuentaPrestamoList() {
        try {
            return cuentaPrestamoDAO.findAll(CuentaPrestamo.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}