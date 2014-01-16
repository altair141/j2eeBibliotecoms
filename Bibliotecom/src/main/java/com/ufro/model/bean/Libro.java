package com.ufro.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7236974454270679041L;

	

	private Integer codigoRegistro;
	private String titulo;
	private String isbn;
	private String autor;
	private String editorial;
	private String descripcion;
	private Area area;
	private Estado estado;
	private Integer agno;
	
	
	//lista de prestamo. 
		private Set<Prestamo> prestamos = new HashSet<Prestamo>();

			
		public Libro() {
			}
			
		/**
		 * @return the titulo
		 */
		public String getTitulo() {
			return titulo;
		}

		/**
		 * @param titulo
		 *            the titulo to set
		 */
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		/**
		 * @return the isbn
		 */
		public String getIsbn() {
			return isbn;
		}

		/**
		 * @param isbn
		 *            the isbn to set
		 */
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		/**
		 * @return the autor
		 */
		public String getAutor() {
			return autor;
		}

		/**
		 * @param autor
		 *            the autor to set
		 */
		public void setAutor(String autor) {
			this.autor = autor;
		}

		/**
		 * @return the editorial
		 */
		public String getEditorial() {
			return editorial;
		}

		/**
		 * @param editorial
		 *            the editorial to set
		 */
		public void setEditorial(String editorial) {
			this.editorial = editorial;
		}

		/**
		 * @return the agno
		 */
		public Integer getAgno() {
			return agno;
		}

		/**
		 * @param agno
		 *            the agno to set
		 */
		public void setAgno(Integer agno) {
			this.agno = agno;
		}

		/**
		 * @return the descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}

		/**
		 * @param descripcion
		 *            the descripcion to set
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		
		/**
		 * @return the estado
		 */
		public Estado getEstado() {
			return estado;
		}

		/**
		 * @param estado the estado to set
		 */
		public void setEstado(Estado estado) {
			this.estado = estado;
		}

		/**
		 * @return the codigoRegistro
		 */
		public Integer getCodigoRegistro() {
			return codigoRegistro;
		}

		/**
		 * @param codigoRegistro
		 *            the codigoRegistro to set
		 */
		public void setCodigoRegistro(Integer codigoRegistro) {
			this.codigoRegistro = codigoRegistro;
		}

		/**
		 * @return the idArea
		 */
		public Area getArea() {
			return area;
		}

		/**
		 * @param idArea
		 *            the idArea to set
		 */
		public void setArea(Area idArea) {
			this.area = idArea;
		}

			
			
			//metodos para la lista de prestamos. 
					public Set<Prestamo> getPrestamo() {
						return prestamos;
					}

					public void setPrestamos(Set<Prestamo> prestamos) {
						this.prestamos = prestamos;
					}

					public void addPrestamo(Prestamo prestamo) {
				        if(!prestamos.contains(prestamo)) {
				        	prestamos.add(prestamo);
				        }
				  
				        if (prestamo.getLibro() != this) {
				        	prestamo.setLibro(this);
				        }
				    }
					
					public void removePrestamo(Prestamo prestamo ) {
						prestamos.remove(prestamo);
					}


					/**
					 * @return the cuentasPrestamo
					 */
					/*
					public Set<CuentaPrestamo> getCuentasPrestamo() {
						return cuentasPrestamo;
					}
					*/
					/**
					 * @param cuentasLibros the cuentasLibros to set
					 */
					/*
					public void setCuentasPrestamo(Set<CuentaPrestamo> cuentasPrestamo) {
						this.cuentasPrestamo = cuentasPrestamo;
					}
					*/
					
					/**
					 * @return the prestamos
					 */
					public Set<Prestamo> getPrestamos() {
						return prestamos;
					}
}
