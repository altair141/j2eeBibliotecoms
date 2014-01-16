package com.ufro.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3590793464545915392L;

	private Integer idCuenta;
	private Usuario rutUsuario;
	private String clave;
	
	//lista de cuenta_Libro. 
	private Set<CuentaPrestamo> cuentasPrestamos = new HashSet<CuentaPrestamo>();
	
	public Cuenta() {
	}

	/**
	 * @return the rutUsuario
	 */
	public Usuario getUsuario() {
		return rutUsuario;
	}

	/**
	 * @param rutUsuario the rutUsuario to set
	 */
	public void setUsuario(Usuario rutUsuario) {
		this.rutUsuario = rutUsuario;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the idCuenta
	 */
	public Integer getIdCuenta() {
		return idCuenta;
	}

	/**
	 * @param idCuenta the idCuenta to set
	 */
	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}
	
	
	//metodos para la lista de cuentasPrestamos. 
	public Set<CuentaPrestamo> getCuentasPrestamos() {
		return cuentasPrestamos;
	}

	public void setcuentasPrestamos(Set<CuentaPrestamo> cuentasPrestamos) {
		this.cuentasPrestamos = cuentasPrestamos;
	}

	public void addCuentaPrestamo(CuentaPrestamo CuentaPrestamo) {
        if(!cuentasPrestamos.contains(CuentaPrestamo)) {
        	cuentasPrestamos.add(CuentaPrestamo);
        }
  
        if (CuentaPrestamo.getCuenta() != this) {
        	CuentaPrestamo.setCuenta(this);
        }
    }
	
	public void removeCuentaLibro(CuentaPrestamo CuentaPrestamo ) {
		cuentasPrestamos.remove(CuentaPrestamo);
	}
	
	
}
