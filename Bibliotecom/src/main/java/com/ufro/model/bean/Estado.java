package com.ufro.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.ufro.model.bean.Estado;
import com.ufro.model.bean.Libro;

public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8790790191223445035L;


	private Integer idEstado;
	private String nombreEstado;
	
	//lista de libros.
	private Set<Libro> libros = new HashSet<Libro>();

	
	public Estado() {
	}


	/**
	 * @return the idEstado
	 */
	public Integer getIdEstado() {
		return idEstado;
	}


	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}


	/**
	 * @return the nombreEstado
	 */
	public String getNombreEstado() {
		return nombreEstado;
	}


	/**
	 * @param nombreEstado the nombreEstado to set
	 */
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}


	/**
	 * @return the libros
	 */
	public Set<Libro> getLibros() {
		return libros;
	}


	/**
	 * @param libros the libros to set
	 */
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	public void addLibro(Libro libro) {
        if(!libros.contains(libro)) {
        	libros.add(libro);
        }
       if(libro.getEstado()!=this){
    	   libro.setEstado(this);
    
        }
    }
	public void removeLibro(Libro libro) {
		libros.remove(libro);
	}
	
}
