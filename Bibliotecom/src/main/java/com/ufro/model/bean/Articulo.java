package com.ufro.model.bean;

import java.io.Serializable;



public class Articulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5110405405539688024L;
	/**
	 * 
	 */
	
	private Integer idArticulo;
	private String nombreArt;
	private Integer precioArt;
	private Categoria categoria; 
	
	/**
	 * 
	 */
	
	
	
	public Articulo() {
	}


	public Integer getIdArticulo() {
		return idArticulo;
	}


	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}


	public String getNombreArt() {
		return nombreArt;
	}


	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}


	public Integer getPrecioArt() {
		return precioArt;
	}


	public void setPrecioArt(Integer precioArt) {
		this.precioArt = precioArt;
	}



	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	

	
}
