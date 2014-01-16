package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Prestamo;

public interface PrestamoManager {
    public boolean save(Prestamo prestamo);
    public boolean delete(Prestamo prestamo);
    public Prestamo getPrestamo(Integer id);
    public List<Prestamo> getPrestamoList();
}
