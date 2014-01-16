package com.ufro.view.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.ufro.model.bean.Articulo;
import com.ufro.model.bean.Categoria;
import com.ufro.service.ArticuloManager;
import com.ufro.service.ServiceLocator;
import com.ufro.view.ctrl.renderer.ArticuloListRenderer;

public class ArticuloCtrl extends GenericForwardComposer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4635560688872216915L;
	
	// data binding create/edit Articulo bean
    private AnnotateDataBinder binder;
    private Articulo _articulo = new Articulo();
    // wire component as member fields
    private Listbox articuloList;
    // ...   other components in ZUL
    
   //borrar
    private Categoria _categoria = new Categoria();
    private Listbox categoriaList;
    
    private Grid editArticuloGrid;
    private Button createArticulo;
    private Button updateArticulo;
    private Button deleteArticulo;
     
    // get singleton ArticuloManager object for CRUD operation
    private ArticuloManager articuloManager = ServiceLocator.getArticuloManager();

    
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        binder = (AnnotateDataBinder) page.getAttribute("binder");
        articuloList.setModel(new ListModelList(articuloManager.getArticuloList()));
        articuloList.setItemRenderer(new ArticuloListRenderer());
    }
     
    
    public void onClick$resetArticulo() {
        // process reset view
    	this.getArticulo().setIdArticulo(null);
    	this.getArticulo().setNombreArt(null);
    	this.getArticulo().setPrecioArt(0);
    	this.getArticulo().setCategoria(null);
    	
    	
    	createArticulo.setDisabled(false);
    	updateArticulo.setDisabled(true);
    	binder.loadComponent(editArticuloGrid);
    }
         
    //set selection to edit data
    public void onSelect$articuloList() {
        _articulo = (Articulo) articuloList.getSelectedItem().getValue();
        binder.loadComponent(editArticuloGrid);
        createArticulo.setDisabled(true);
        updateArticulo.setDisabled(false);
        deleteArticulo.setDisabled(false);
        // used for Hibernate lazy-loading
        //_articulo = (Articulo) ServiceLocator.getHibernateSession().merge(_articulo);
        Event event = new Event("onLoad", page.getFellow("articuloDiv"), _articulo);
        EventQueues.lookup("loadArticulo", EventQueues.DESKTOP, true).publish(event);
    }   
     
    public void onClick$createArticulo() throws InterruptedException {
        // process create
    	
    	if(this._articulo.getNombreArt()!=null && this._articulo.getPrecioArt()!=null){
    		this.getArticulo().setIdArticulo(null);
    		 
    		
    		
    		
    		articuloManager.save(getArticulo());
    		
    		articuloList.setModel(new ListModelList(articuloManager.getArticuloList()));
    		articuloList.setItemRenderer(new ArticuloListRenderer());
    		
  
    		  
    	}
    	
    }
    public void onClick$updateArticulo() throws InterruptedException {
        // process update
    	if(this._articulo!=null){
    		articuloManager.save(getArticulo());
    		articuloList.setItemRenderer(new ArticuloListRenderer());
    	}
    	
    	
    }
    public void onClick$deleteArticulo() throws InterruptedException {
        // process delete
    	if(this._articulo!=null){
    		articuloManager.delete(getArticulo());
    		articuloList.setModel(new ListModelList(articuloManager.getArticuloList()));
    		articuloList.setItemRenderer(new ArticuloListRenderer());
    	}
    }
    private ListModelList getModel() {
        return (ListModelList) articuloList.getModel();
    }
    public Articulo getArticulo() {   return _articulo; }
    public void setArticulo(Articulo articulo) { _articulo = articulo; }
    
   
    
    //borrar
    public void onSelect$categoriaList() {
        _categoria = (Categoria) categoriaList.getSelectedItem().getValue();

    }   
    
    
    
    
}