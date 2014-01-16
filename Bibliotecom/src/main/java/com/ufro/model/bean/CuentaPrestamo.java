package com.ufro.model.bean;

import java.io.Serializable;


public class CuentaPrestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3453375126202596397L;
	
	private Integer idCuentaPrestamo;
	private Cuenta idCuenta;
	private Prestamo idPrestamo;
	
	
	public CuentaPrestamo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the idCuentaPrestamo
	 */
	public Integer getIdCuentaPrestamo() {
		return idCuentaPrestamo;
	}


	/**
	 * @param idCuentaLibro the idCuentaPrestamo to set
	 */
	public void setIdCuentaPrestamo(Integer idCuentaPrestamo) {
		this.idCuentaPrestamo = idCuentaPrestamo;
	}


	/**
	 * @return the idCuenta
	 */
	public Cuenta getCuenta() {
		return idCuenta;
	}


	/**
	 * @param idCuenta the idCuenta to set
	 */
	public void setCuenta(Cuenta idCuenta) {
		this.idCuenta = idCuenta;
	}



	/**
	 * @return the idPrestamo
	 */
	public Prestamo getPrestamo() {
		return idPrestamo;
	}


	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setPrestamo(Prestamo idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	
	
	
}
