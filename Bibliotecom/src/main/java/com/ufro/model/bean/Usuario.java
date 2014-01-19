package com.ufro.model.bean;

import java.io.Serializable;

public class Usuario  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6855456788175573045L;

	private Integer rut;
	private Integer idUsuario;
	private String dVerificador;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private Integer fono;
	private String email;
	private TipoUsuario tipoUsuario;
	private Cuenta cuenta;
	
	public Usuario() {
	}

	/**


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the fono
	 */
	public Integer getFono() {
		return fono;
	}

	/**
	 * @param fono the fono to set
	 */
	public void setFono(Integer fono) {
		this.fono = fono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idTUsuario
	 */
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param idTUsuario the idTUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getDVerificador() {
		return dVerificador;
	}

	public void setDVerificador(String dVerificador) {
		this.dVerificador = dVerificador;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public Integer getRut() {
		return rut;
	}

	public String getdVerificador() {
		return dVerificador;
	}

	public void setdVerificador(String dVerificador) {
		this.dVerificador = dVerificador;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
