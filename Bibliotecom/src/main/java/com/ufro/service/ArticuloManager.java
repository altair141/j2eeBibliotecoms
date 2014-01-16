package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Articulo;

public interface ArticuloManager {
    public boolean save(Articulo articulo);
    public boolean delete(Articulo articulo);
    public Articulo getArticulo(Integer id);
    public List<Articulo> getArticuloList();
}
