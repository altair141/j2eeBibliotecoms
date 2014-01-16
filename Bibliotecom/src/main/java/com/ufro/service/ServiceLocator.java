package com.ufro.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zkoss.zkplus.spring.SpringUtil;

public class ServiceLocator {

	private ServiceLocator() {
	}

	public static Session getHibernateSession() {
		return ((SessionFactory) SpringUtil.getBean("sessionFactory",
				SessionFactory.class)).getCurrentSession();
	}



	public static CategoriaManager getCategoriaManager() {
		return (CategoriaManager) SpringUtil.getBean("categoriaManager",
				CategoriaManager.class);
	}

	public static ArticuloManager getArticuloManager() {
		return (ArticuloManager) SpringUtil.getBean("articuloManager",
				ArticuloManager.class);
	}


	
	public static EstadoManager getEstadoManager() {
		return (EstadoManager) SpringUtil.getBean("estadoManager",
				EstadoManager.class);
	}
	public static LibroManager getLibroManager() {
		return (LibroManager) SpringUtil.getBean("libroManager",
				LibroManager.class);
	}
	public static PrestamoManager getPrestamoManager() {
		return (PrestamoManager) SpringUtil.getBean("prestamoManager",
				PrestamoManager.class);
	}
	public static CuentaPrestamoManager getCuentaLibroManager() {
		return (CuentaPrestamoManager) SpringUtil.getBean("cuentaPrestamoManager",
				CuentaPrestamoManager.class);
	}

	public static TipoUsuarioManager getTipoUsuarioManager() {
		return (TipoUsuarioManager) SpringUtil.getBean("tipoUsuarioManager",
				TipoUsuarioManager.class);
	}
	public static UsuarioManager getUsuarioManager() {
		return (UsuarioManager) SpringUtil.getBean("usuarioManager",
				UsuarioManager.class);
	}
	public static CuentaManager getCuentaManager() {
		return (CuentaManager) SpringUtil.getBean("cuentaManager",
				CuentaManager.class);
	}

	public static AreaManager getAreaManager() {
		return (AreaManager) SpringUtil.getBean("areaManager",
				AreaManager.class);
	}

}