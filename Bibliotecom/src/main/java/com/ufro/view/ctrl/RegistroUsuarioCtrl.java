package com.ufro.view.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.ufro.model.bean.TipoUsuario;
import com.ufro.model.bean.Usuario;
import com.ufro.service.ServiceLocator;
import com.ufro.service.UsuarioManager;
import com.ufro.view.ctrl.renderer.EstadoListRenderer;
import com.ufro.view.ctrl.renderer.UsuarioListRenderer;

public class RegistroUsuarioCtrl extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4635560688872216915L;

	// data binding create/edit Usuario bean
	private AnnotateDataBinder binder;
	private Usuario _Usuario = new Usuario();
	// wire component as member fields
	private Listbox listUsuario;
	// ... other components in ZUL

	// get singleton UsuarioManager object for CRUD operation
	private UsuarioManager usuarioManager = ServiceLocator.getUsuarioManager();

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = (AnnotateDataBinder) page.getAttribute("binder");
		// listUsuario.setModel(new
		// ListModelList(UsuarioManager.getUsuarioList()));
		// listUsuario.setItemRenderer(new UsuarioListRenderer());
	
	}

	private ListModel setUsuarioModel(TipoUsuario TipoUsuario) {
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		if (TipoUsuario.getUsuarios() != null)
			Usuarios.addAll(TipoUsuario.getUsuarios());
		
		return new ListModelList(Usuarios);
	}

	// set selection to edit data
	/*
	 * public void onSelect$UsuarioList() { _Usuario = (Usuario)
	 * listUsuario.getSelectedItem().getValue();
	 * binder.loadComponent(resgistroUsuarioGrid);
	 * 
	 * // used for Hibernate lazy-loading // _Usuario = (Usuario) //
	 * ServiceLocator.getHibernateSession().merge(_Usuario); Event event = new
	 * Event("onLoad", page.getFellow("UsuarioDiv"), _Usuario);
	 * EventQueues.lookup("loadUsuario", EventQueues.DESKTOP, true).publish(
	 * event); }
	 */

	public void onClick$createUsuario() throws InterruptedException {
		// process create
		if (this._Usuario != null) {

			TipoUsuario tipoUsuario = new TipoUsuario();
			tipoUsuario.setNombreTipo("usuario");
			tipoUsuario.setIdTipoUsuario(1);

			this.getUsuario().setTipoUsuario(tipoUsuario);

			System.out.println("datos Usuario");
			System.out.println(this.getUsuario().getNombre());
			System.out.println(this.getUsuario().getApellido1());
			System.out.println(this.getUsuario().getRut());
			System.out.println(this.getUsuario().getEmail());
			System.out.println(this.getUsuario().getApellido2());
			System.out.println(this.getUsuario().getFono());
			System.out.println(this.getUsuario().getDireccion());
			System.out.println(this.getUsuario().getTipoUsuario()
					.getIdTipoUsuario());
			System.out.println("fin datos Usuario");
			usuarioManager.save(getUsuario());
			
			System.out.println("asddassad listo");
		}

	}

	/*
	 * public void onClick$updateUsuario() throws InterruptedException { //
	 * process update if (this._Usuario != null) {
	 * UsuarioManager.save(getUsuario()); listUsuario.setItemRenderer(new
	 * UsuarioListRenderer()); }
	 * 
	 * }
	 * 
	 * public void onClick$deleteUsuario() throws InterruptedException { //
	 * process delete if (this._Usuario != null) {
	 * UsuarioManager.delete(getUsuario()); listUsuario.setModel(new
	 * ListModelList(UsuarioManager .getUsuarioList()));
	 * listUsuario.setItemRenderer(new UsuarioListRenderer()); } }
	 */
	private ListModelList getModel() {
		return (ListModelList) listUsuario.getModel();
	}

	public Usuario getUsuario() {
		return _Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		_Usuario = Usuario;
	}

}
