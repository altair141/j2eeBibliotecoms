package com.ufro.view.ctrl;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.ufro.model.bean.TipoUsuario;
import com.ufro.model.bean.Estado;
import com.ufro.service.TipoUsuarioManager;
import com.ufro.service.ServiceLocator;
import com.ufro.view.ctrl.renderer.TipoUsuarioListRenderer;

public class TipoUsuarioCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = -4635560688872216915L;

	// data binding create/edit TipoUsuario bean
	private AnnotateDataBinder binder;
	private TipoUsuario _tipoUsuario = new TipoUsuario();
	// wire component as member fields
	private Listbox tipoUsuarioList;
	// ... other components in ZUL
	//List<TipoUsuario> tipoUsuarioListPrueba;
	private Grid datosLibroTipoUsuario;
	private Button createTipoUsuario;
	private Button updateTipoUsuario;
	private Button deleteTipoUsuario;

	// get singleton TipoUsuarioManager object for CRUD operation
	private TipoUsuarioManager tipoUsuarioManager = ServiceLocator.getTipoUsuarioManager();

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
		System.out.println(tipoUsuarioManager.getTipoUsuarioList().get(0).getNombreTipo()+"asdasdas");
		tipoUsuarioList.setModel(new ListModelList(tipoUsuarioManager.getTipoUsuarioList()));
		tipoUsuarioList.setItemRenderer(new TipoUsuarioListRenderer());

		System.out.println(tipoUsuarioManager.getTipoUsuarioList().get(0).getNombreTipo());

	}

	public void onClick$resetTipoUsuario() {
		// process reset view
	
		tipoUsuarioList.clearSelection();
		_tipoUsuario=new TipoUsuario();

		createTipoUsuario.setDisabled(false);
		updateTipoUsuario.setDisabled(true);
		binder.loadComponent(datosLibroTipoUsuario);
	}

	// set selection to edit data
	public void onSelect$tipoUsuarioList() {
		_tipoUsuario = (TipoUsuario) tipoUsuarioList.getSelectedItem().getValue();
		 binder.loadComponent(datosLibroTipoUsuario);
		createTipoUsuario.setDisabled(true);
		updateTipoUsuario.setDisabled(false);
		deleteTipoUsuario.setDisabled(false);
		// used for Hibernate lazy-loading
		// _tipoUsuario = (TipoUsuario)
		// ServiceLocator.getHibernateSession().merge(_tipoUsuario);
		Event event = new Event("onLoad", page.getFellow("tipoUsuarioDiv"), _tipoUsuario);
		EventQueues.lookup("loadTipoUsuario", EventQueues.DESKTOP, true).publish(
				event);
	}

	public void onClick$createTipoUsuario() throws InterruptedException {
		// process create
		if (this._tipoUsuario != null) {
			this.getTipoUsuario().setIdTipoUsuario(null);
			tipoUsuarioManager.save(getTipoUsuario());
			tipoUsuarioList.setModel(new ListModelList(tipoUsuarioManager.getTipoUsuarioList()));
			tipoUsuarioList.setItemRenderer(new TipoUsuarioListRenderer());
			updateTipoUsuario.setDisabled(false);
			deleteTipoUsuario.setDisabled(false);
		}

	}

	public void onClick$updateTipoUsuario() throws InterruptedException {
		// process update
		if (this._tipoUsuario != null) {
			tipoUsuarioManager.save(getTipoUsuario());
			tipoUsuarioList.setItemRenderer(new TipoUsuarioListRenderer());
		}

	}

	public void onClick$deleteTipoUsuario() throws InterruptedException {
		// process delete
		if (this._tipoUsuario != null) {
			tipoUsuarioManager.delete(getTipoUsuario());
			tipoUsuarioList.setModel(new ListModelList(tipoUsuarioManager.getTipoUsuarioList()));
			tipoUsuarioList.setItemRenderer(new TipoUsuarioListRenderer());
		}
	}

	private ListModelList getModel() {
		return (ListModelList) tipoUsuarioList.getModel();
	}

	public TipoUsuario getTipoUsuario() {
		return _tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		_tipoUsuario = tipoUsuario;
	}

}