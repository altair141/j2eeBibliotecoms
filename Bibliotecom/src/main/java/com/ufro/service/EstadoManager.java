package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Estado;

public interface EstadoManager {
    public boolean save(Estado estado);
    public boolean delete(Estado estado);
    public Estado getEstado(Integer id);
    public List<Estado> getEstadoList();
}
