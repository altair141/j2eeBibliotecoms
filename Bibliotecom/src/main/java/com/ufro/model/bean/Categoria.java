package com.ufro.model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Categoria implements Serializable{
	
	private Integer idCategoria;
	private String catNombre;
	private Set<Articulo> articulos = new HashSet<Articulo>();

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3582046257258157759L;
	
	
	public Categoria() {
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getCatNombre() {
		return catNombre;
	}


	public void setCatNombre(String catNombre) {
		this.catNombre = catNombre;
	}

	public Set<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	public void addArticulo(Articulo articulo) {
        if(!articulos.contains(articulo)) {
        	articulos.add(articulo);
        }
        if (articulo.getCategoria() != this) {
        	articulo.setCategoria(this);
        	
        }
    }
	
	public void removeArt(Articulo articulo) {
		articulos.remove(articulo);
	}
	
	
}
