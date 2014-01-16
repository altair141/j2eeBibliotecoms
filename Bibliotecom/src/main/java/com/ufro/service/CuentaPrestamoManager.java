package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.CuentaPrestamo;

public interface CuentaPrestamoManager {
    public boolean save(CuentaPrestamo cuentaPrestamo);
    public boolean delete(CuentaPrestamo cuentaPrestamo);
    public CuentaPrestamo getCuentaPrestamo(Integer id);
    public List<CuentaPrestamo> getCuentaPrestamoList();
}
