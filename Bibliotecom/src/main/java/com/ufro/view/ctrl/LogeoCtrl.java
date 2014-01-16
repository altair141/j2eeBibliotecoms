package com.ufro.view.ctrl;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.ufro.model.bean.Cuenta;
import com.ufro.service.CuentaManager;
import com.ufro.service.CuentaManagerImpl;
import com.ufro.service.ServiceLocator;

public class LogeoCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = -4635560688872216915L;

	// data binding create/edit Cuenta bean
	private AnnotateDataBinder binder;
	private Cuenta _Cuenta = new Cuenta();

	// ... other components in ZUL

	private List<Cuenta> cuentaList;

	private Button iniciarSesion;
	private Textbox user;
	private Textbox pass;
	private String tipoUsuario;
	// get singleton CuentaManager object for CRUD operation
	private CuentaManager cuentaManager = ServiceLocator.getCuentaManager();
	
	/**
	 * public void doAfterCompose(Component comp) throws Exception {
	 * super.doAfterCompose(comp); binder = (AnnotateDataBinder)
	 * page.getAttribute("binder"); categoriaList.setModel(new
	 * ListModelList(categoriaManager.getCategoriaList()));
	 * categoriaList.setItemRenderer(new CategoriaListRenderer()); }
	 */

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = (AnnotateDataBinder) page.getAttribute("binder");

	}

	public void onClick$iniciarSesion() throws InterruptedException {

		/* cuentaList=cuentaManagerImpl.getCuentaList();
		
		cuentaList =cuentaManagerImpl.getCuentaList();
		int auxCM = cuentaManagerImpl.getCuentaList().size();
		
		System.out.println("totalCuenta"+auxCM);
		String rut[] = new String[auxCM];
		String clave[] = new String[auxCM];
		int id[] = new int[auxCM];
		for (int i = 0; i < auxCM; i++) {
			rut[i] = cuentaManagerImpl.getCuentaList().get(i).getUsuario().getRut();
			System.out.println(rut[i]);
			id[i] = cuentaManagerImpl.getCuentaList().get(i).getIdCuenta();
			System.out.println(id[i]);
			clave[i] =cuentaManagerImpl.getCuentaList().get(i).getClave();
			System.out.println(clave[i]);

		}
		int i = 0;
		for (i = 0; i < auxCM; i++) {
			if (user.getText().equals(rut[i])
					&& pass.getText().equals(clave[i])) {

				tipoUsuario = cuentaManagerImpl.getCuenta(i).getUsuario()
						.getTipoUsuario().getNombreTipo();
				System.out.println(tipoUsuario+ "asdasd");
				break;
			}
		}
		if (!cuentaList.isEmpty()) {
			if (tipoUsuario.equals("administrador")) {
				Executions.sendRedirect("/ConsultasAdministrador.zul");
			} else if (tipoUsuario.equals("usuario")) {
				Executions.sendRedirect("/Consultas.zul");
			} else {
			}
		}*/
	}

	public void buscarRut() {

	}

	/*
	 * private ListModelList getModel() { return (ListModelList)
	 * CuentaList.getModel(); }
	 */
	public Cuenta getCuenta() {
		return _Cuenta;
	}

	public void setCuenta(Cuenta Cuenta) {
		_Cuenta = Cuenta;
	}

}