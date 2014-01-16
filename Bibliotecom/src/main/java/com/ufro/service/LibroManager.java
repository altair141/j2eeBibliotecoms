package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Libro;

public interface LibroManager {
    public boolean save(Libro libro);
    public boolean delete(Libro libro);
    public Libro getLibro(Integer id);
    public List<Libro> getLibroList();
}
