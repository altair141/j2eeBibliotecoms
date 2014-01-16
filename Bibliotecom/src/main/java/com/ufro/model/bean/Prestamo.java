package com.ufro.model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Prestamo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1392018391337791923L;

	private Integer idPrestamo;
	private Date fechaPrestamo;

	
	// lista de cuenta_prestamo.
	private Set<CuentaPrestamo> cuentasPrestamos = new HashSet<CuentaPrestamo>();

	private Libro libro;

	public Prestamo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the idPrestamo
	 */
	public Integer getIdPrestamo() {
		return idPrestamo;
	}


	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}


	/**
	 * @return the fecha
	 */
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}


	//metodos para la lista de cuentasPrestamos. 
	public Set<CuentaPrestamo> getCuentasPrestamos() {
		return cuentasPrestamos;
	}

	public void setCuentasPrestamos(Set<CuentaPrestamo> cuentasPrestamos) {
		this.cuentasPrestamos = cuentasPrestamos;
	}

	public void addCuentaPrestamo(CuentaPrestamo cuentaPrestamo) {
        if(!cuentasPrestamos.contains(cuentaPrestamo)) {
        	cuentasPrestamos.add(cuentaPrestamo);
        }
  
        if (cuentaPrestamo.getPrestamo() != this) {
        	cuentaPrestamo.setPrestamo(this);
        }
    }
	
	public void removeCuentasPrestamos(CuentaPrestamo cuentaPrestamo ) {
		cuentasPrestamos.remove(cuentaPrestamo);
	}

	
	/**
	 * @return the codigoRegistro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param codigoRegistro the codigoRegistro to set
	 */
	public void setLibro(Libro codigoRegistro) {
		this.libro = codigoRegistro;
	}
	

}
