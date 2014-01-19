package com.ufro.view.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.ufro.model.bean.Area;
import com.ufro.model.bean.Estado;
import com.ufro.model.bean.Libro;
import com.ufro.service.AreaManager;
import com.ufro.service.EstadoManager;
import com.ufro.service.LibroManager;
import com.ufro.service.ServiceLocator;
import com.ufro.view.ctrl.renderer.LibroListRenderer;

public class LibroCtrl extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7610625747609391116L;
	// data binding create/edit Libro bean
	private AnnotateDataBinder binder;
	private Libro _libro = new Libro();
	private Listbox libroList;

	private ArrayList<Estado> listEstado = new ArrayList<Estado>();
	private ArrayList<Area> listArea= new ArrayList<Area>();
	
	private Grid agregarEditarLibroGrid;
	private Button crearLibro;
	private Button editarLibro;
	private Button eliminarLibro;
	
	// get singleton LibroManager object for CRUD operation
	private LibroManager libroManager = ServiceLocator.getLibroManager();
	private EstadoManager estadoManager = ServiceLocator.getEstadoManager();
	private AreaManager areaManager = ServiceLocator.getAreaManager();

	
	
	public LibroCtrl(){
		setListAreas();
		setListEstados();
	}
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	
		binder = (AnnotateDataBinder) page.getAttribute("binder");
		_libro = new Libro();
		libroList.setModel(new ListModelList(libroManager.getLibroList()));
		libroList.setItemRenderer(new LibroListRenderer());
		
		/*
		 * lenguas=getLenguas(); String out="";
		 * 
		 * for(int i=0;i<lenguas.length;i++){ out+=lenguas[i]+"\n"; }
		 * System.out.println(out);* this.setLenguas(lenguas);
		 */
		/*
		 * EventQueues.lookup("loadLibro", EventQueues.DESKTOP,
		 * true).subscribe(new EventListener() { public void onEvent(Event
		 * event) throws Exception { event.getTarget().setVisible(true); Area
		 * area = (Area) event.getData();
		 * 
		 * System.out.println(area.getNombreArea());
		 * areaListLibro.setModel(setAreaModel(area)); } });
		 * areaListLibro.setItemRenderer(new LibroListRenderer());
		 */
	}

	private ListModel setAreaModel(Area area) {
		List<Libro> libros = new ArrayList<Libro>();
		if (area.getLibros() != null)
			libros.addAll(area.getLibros());

		System.out.println(libros.get(0).getArea().getNombreArea());

		return new ListModelList<Libro>(libros);
	}

	public void onClick$reiniciarLibro() {
		// process reset view

		libroList.clearSelection();
		_libro = new Libro();
		crearLibro.setDisabled(false);
		editarLibro.setDisabled(true);
		binder.loadComponent(agregarEditarLibroGrid);
	}

	// set selection to edit data
	public void onSelect$libroList() {
		_libro = (Libro) libroList.getSelectedItem().getValue();
		binder.loadComponent(agregarEditarLibroGrid);
		crearLibro.setDisabled(true);
		editarLibro.setDisabled(false);
		eliminarLibro.setDisabled(false);

		Event event = new Event("onLoad", page.getFellow("libroDiv"), _libro);
		EventQueues.lookup("loadLibro", EventQueues.DESKTOP, true).publish(
				event);
	}

	public void onClick$crearLibro() throws InterruptedException {
		// process create

		if (this._libro.getAutor() != null && this._libro.getIsbn() != null) {
			this.getLibro().setCodigoRegistro(null);

			libroManager.save(getLibro());

			libroList.setModel(new ListModelList(libroManager.getLibroList()));
			libroList.setItemRenderer(new LibroListRenderer());

		}

	}

	public void onClick$editarLibro() throws InterruptedException {
		// process update
		if (this._libro != null) {
			libroManager.save(getLibro());
			libroList.setItemRenderer(new LibroListRenderer());
		}

	}

	public void onClick$eliminarLibro() throws InterruptedException {
		// process delete
		if (this._libro != null) {
			libroManager.delete(getLibro());
			libroList.setModel(new ListModelList(libroManager.getLibroList()));
			libroList.setItemRenderer(new LibroListRenderer());
		}
	}

	private ListModelList getModel() {
		return (ListModelList) libroList.getModel();
	}

	public Libro getLibro() {
		return _libro;
	}

	public void setLibro(Libro libro) {
		_libro = libro;
	}

	

	public ArrayList<Estado> getListEstado() {
		return listEstado;
	}
	public void setListEstado(ArrayList<Estado> listEstado) {
		this.listEstado = listEstado;
	}

	public void setListEstados(){
		for (int i = 0; i < estadoManager.getEstadoList().size(); i++) {
			 listEstado.add(estadoManager.getEstadoList().get(i));
			
		}
	}
	public ArrayList<Area> getListArea() {
		return listArea;
	}
	public void setListArea(ArrayList<Area> listArea) {
		this.listArea = listArea;
	}
	public void setListAreas(){
		for (int i = 0; i < areaManager.getAreaList().size(); i++) {
			 listArea.add(areaManager.getAreaList().get(i));
			
		}
	}
}
