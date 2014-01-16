package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Usuario;

public interface UsuarioManager {
    public boolean save(Usuario usuario);
    public boolean delete(Usuario usuario);
    public Usuario getUsuario(Integer id);
    public List<Usuario> getUsuarioList();
}
