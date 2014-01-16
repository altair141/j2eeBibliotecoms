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

import com.ufro.model.bean.Area;
import com.ufro.model.bean.Estado;
import com.ufro.service.AreaManager;
import com.ufro.service.ServiceLocator;
import com.ufro.view.ctrl.renderer.AreaListRenderer;

public class AreaCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = -4635560688872216915L;

	// data binding create/edit Area bean
	private AnnotateDataBinder binder;
	private Area _area = new Area();
	// wire component as member fields
	private Listbox areaList;
	// ... other components in ZUL
	//List<Area> areaListPrueba;
	private Grid datosLibroArea;
	private Button createArea;
	private Button updateArea;
	private Button deleteArea;

	// get singleton AreaManager object for CRUD operation
	private AreaManager areaManager = ServiceLocator.getAreaManager();

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
		System.out.println(areaManager.getAreaList());
		areaList.setModel(new ListModelList(areaManager.getAreaList()));
		areaList.setItemRenderer(new AreaListRenderer());

		System.out.println(areaManager.getAreaList().get(0).getNombreArea());

	}

	public void onClick$resetArea() {
		// process reset view
	
		areaList.clearSelection();
		_area=new Area();

		createArea.setDisabled(false);
		updateArea.setDisabled(true);
		binder.loadComponent(datosLibroArea);
	}

	// set selection to edit data
	public void onSelect$areaList() {
		_area = (Area) areaList.getSelectedItem().getValue();
		 binder.loadComponent(datosLibroArea);
		createArea.setDisabled(true);
		updateArea.setDisabled(false);
		deleteArea.setDisabled(false);
		// used for Hibernate lazy-loading
		// _area = (Area)
		// ServiceLocator.getHibernateSession().merge(_area);
		Event event = new Event("onLoad", page.getFellow("areaDiv"), _area);
		EventQueues.lookup("loadArea", EventQueues.DESKTOP, true).publish(
				event);
	}

	public void onClick$createArea() throws InterruptedException {
		// process create
		if (this._area != null) {
			this.getArea().setIdArea(null);
			areaManager.save(getArea());
			areaList.setModel(new ListModelList(areaManager.getAreaList()));
			areaList.setItemRenderer(new AreaListRenderer());
			updateArea.setDisabled(false);
			deleteArea.setDisabled(false);
		}

	}

	public void onClick$updateArea() throws InterruptedException {
		// process update
		if (this._area != null) {
			areaManager.save(getArea());
			areaList.setItemRenderer(new AreaListRenderer());
		}

	}

	public void onClick$deleteArea() throws InterruptedException {
		// process delete
		if (this._area != null) {
			areaManager.delete(getArea());
			areaList.setModel(new ListModelList(areaManager.getAreaList()));
			areaList.setItemRenderer(new AreaListRenderer());
		}
	}

	private ListModelList getModel() {
		return (ListModelList) areaList.getModel();
	}

	public Area getArea() {
		return _area;
	}

	public void setArea(Area area) {
		_area = area;
	}

}