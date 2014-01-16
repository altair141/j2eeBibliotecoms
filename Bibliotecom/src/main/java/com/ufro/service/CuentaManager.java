package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Cuenta;

public interface CuentaManager {
    public boolean save(Cuenta cuenta);
    public boolean delete(Cuenta cuenta);
    public Cuenta getCuenta(Integer id);
    public List<Cuenta> getCuentaList();
}
