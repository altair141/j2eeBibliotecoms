package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Cuenta;
import com.ufro.model.dao.CuentaDAO;

public class CuentaManagerImpl implements CuentaManager {
    private CuentaDAO cuentaDAO;
 
    public CuentaDAO getCuentaDAO() {
        return cuentaDAO;
    }
 
    public void setCuentaDAO(CuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }
 
    @Transactional
    public boolean save(Cuenta cuenta) {
        try {
            cuentaDAO.saveOrUpdate(cuenta);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Cuenta cuenta) {
        try {
            cuentaDAO.delete(cuenta);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Cuenta getCuenta(Integer id) {
        try {
            return cuentaDAO.find(Cuenta.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Cuenta> getCuentaList() {
        try {
            return cuentaDAO.findAll(Cuenta.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}