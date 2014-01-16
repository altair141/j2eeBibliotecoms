package com.ufro.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.ufro.model.bean.Area;
import com.ufro.model.bean.Libro;

public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8790790191223445035L;


	private Integer idArea;
	private String nombreArea;
	
	//lista de libros.
	private Set<Libro> libros = new HashSet<Libro>();

	
	public Area() {
	}


	/**
	 * @return the idArea
	 */
	public Integer getIdArea() {
		return idArea;
	}


	/**
	 * @param idArea the idArea to set
	 */
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}


	/**
	 * @return the nombreArea
	 */
	public String getNombreArea() {
		return nombreArea;
	}


	/**
	 * @param nombreArea the nombreArea to set
	 */
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
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
       if(libro.getArea()!=this){
    	   libro.setArea(this);
    
        }
    }
	public void removeLibro(Libro libro) {
		libros.remove(libro);
	}
	
}
