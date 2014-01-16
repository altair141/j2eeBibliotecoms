package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Categoria;

public interface CategoriaManager {
    public boolean save(Categoria categoria);
    public boolean delete(Categoria categoria);
    public Categoria getCategoria(Integer id);
    public List<Categoria> getCategoriaList();
}
