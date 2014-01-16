package com.ufro.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TipoUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1392018391337791923L;

	private Integer idTipoUsuario;
	private String nombreTipo;
	
	//lista de usuarios. 
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	
	public TipoUsuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idTipoUsuario
	 */
	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	/**
	 * @param idTipoUsuario the idTipoUsuario to set
	 */
	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	/**
	 * @return the nombreTipo
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * @param nombreTipo the nombreTipo to set
	 */
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	
	//metodos para la lista de usuarios. 
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void addUsuario(Usuario usuario) {
        if(!usuarios.contains(usuario)) {
        	usuarios.add(usuario);
        }
  
        if (usuario.getTipoUsuario() != this) {
        	usuario.setTipoUsuario(this);
        }
    }
	
	public void removeUsuario(Usuario usuario ) {
		usuarios.remove(usuario);
	}
	
}
