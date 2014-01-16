package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.TipoUsuario;

public interface TipoUsuarioManager {
    public boolean save(TipoUsuario tipoUsuario);
    public boolean delete(TipoUsuario tipoUsuario);
    public TipoUsuario getTipoUsuario(Integer id);
    public List<TipoUsuario> getTipoUsuarioList();
}
