package com.ufro.view.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.ufro.model.bean.Estado;
import com.ufro.service.EstadoManager;
import com.ufro.service.ServiceLocator;
import com.ufro.view.ctrl.renderer.EstadoListRenderer;

public class EstadoCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = -4635560688872216915L;

	// data binding create/edit Estado bean
	private AnnotateDataBinder binder;
	private Estado _estado = new Estado();
	// wire component as member fields
	private Listbox estadoList;
	// ... other components in ZUL
	// List<Estado> estadoListPrueba;
	private Grid datosLibroEstado;
	private Button createEstado;
	private Button updateEstado;
	private Button deleteEstado;
	

	// get singleton EstadoManager object for CRUD operation
	private EstadoManager estadoManager = ServiceLocator.getEstadoManager();

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
		System.out.println(estadoManager.getEstadoList());
		estadoList.setModel(new ListModelList(estadoManager.getEstadoList()));
		estadoList.setItemRenderer(new EstadoListRenderer());

		System.out.println(estadoManager.getEstadoList().get(0)
				.getNombreEstado());

	}

	public void onClick$resetEstado() {
		// process reset view

		estadoList.clearSelection();
		_estado=new Estado();
/*
		 this.getEstado().setIdEstado(null);
		 this.getEstado().setNombreEstado(null);
		*/
		
		createEstado.setDisabled(false);
		updateEstado.setDisabled(true);
		binder.loadComponent(datosLibroEstado);
		 

	}

	// set selection to edit data
	public void onSelect$estadoList() {
		_estado = (Estado) estadoList.getSelectedItem().getValue();
		binder.loadComponent(datosLibroEstado);
		createEstado.setDisabled(true);
		updateEstado.setDisabled(false);
		deleteEstado.setDisabled(false);
		// used for Hibernate lazy-loading
		// _estado = (Estado)
		// ServiceLocator.getHibernateSession().merge(_estado);
		Event event = new Event("onLoad", page.getFellow("estadoDiv"), _estado);
		EventQueues.lookup("loadEstado", EventQueues.DESKTOP, true).publish(
				event);
	}

	public void onClick$createEstado() throws InterruptedException {
		// process create
		if (this._estado != null) {
			this.getEstado().setIdEstado(null);
			estadoManager.save(getEstado());
			estadoList
					.setModel(new ListModelList(estadoManager.getEstadoList()));
			estadoList.setItemRenderer(new EstadoListRenderer());
			updateEstado.setDisabled(false);
			deleteEstado.setDisabled(false);
		}

	}

	public void onClick$updateEstado() throws InterruptedException {
		// process update
		if (this._estado != null) {
			estadoManager.save(getEstado());
			estadoList.setItemRenderer(new EstadoListRenderer());
		}

	}

	public void onClick$deleteEstado() throws InterruptedException {
		// process delete
		if (this._estado != null) {
			estadoManager.delete(getEstado());
			estadoList
					.setModel(new ListModelList(estadoManager.getEstadoList()));
			estadoList.setItemRenderer(new EstadoListRenderer());
		}
	}

	private ListModelList getModel() {
		return (ListModelList) estadoList.getModel();
	}

	public Estado getEstado() {
		return _estado;
	}

	public void setEstado(Estado estado) {
		_estado = estado;
	}

}