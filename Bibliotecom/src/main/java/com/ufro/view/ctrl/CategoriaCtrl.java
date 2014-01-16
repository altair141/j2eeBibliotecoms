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

import com.ufro.model.bean.Categoria;
import com.ufro.service.CategoriaManager;
import com.ufro.service.ServiceLocator;
import com.ufro.view.ctrl.renderer.CategoriaListRenderer;

public class CategoriaCtrl extends GenericForwardComposer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4635560688872216915L;
	
	// data binding create/edit Categoria bean
    private AnnotateDataBinder binder;
    private Categoria _categoria = new Categoria();
    // wire component as member fields
    private Listbox categoriaList;
    // ...   other components in ZUL
    
    private Grid editCategoriaGrid;
    private Button createCategoria;
    private Button updateCategoria;
    private Button deleteCategoria;
     
    // get singleton CategoriaManager object for CRUD operation
    private CategoriaManager categoriaManager = ServiceLocator.getCategoriaManager();
     
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        binder = (AnnotateDataBinder) page.getAttribute("binder");
        categoriaList.setModel(new ListModelList(categoriaManager.getCategoriaList()));
        categoriaList.setItemRenderer(new CategoriaListRenderer());
    }
     
    public void onClick$resetCategoria() {
        // process reset view
    	this.getCategoria().setIdCategoria(null);
    	this.getCategoria().setCatNombre(null);

    	
    	createCategoria.setDisabled(false);
    	updateCategoria.setDisabled(true);
    	binder.loadComponent(editCategoriaGrid);
    }
         
    //set selection to edit data
    public void onSelect$categoriaList() {
        _categoria = (Categoria) categoriaList.getSelectedItem().getValue();
        binder.loadComponent(editCategoriaGrid);
        createCategoria.setDisabled(true);
        updateCategoria.setDisabled(false);
        deleteCategoria.setDisabled(false);
        // used for Hibernate lazy-loading
        //_categoria = (Categoria) ServiceLocator.getHibernateSession().merge(_categoria);
        Event event = new Event("onLoad", page.getFellow("categoriaDiv"), _categoria);
        EventQueues.lookup("loadCategoria", EventQueues.DESKTOP, true).publish(event);
    }   
     
    public void onClick$createCategoria() throws InterruptedException {
        // process create
    	if(this._categoria!=null){
    		this.getCategoria().setIdCategoria(null);
    		categoriaManager.save(getCategoria());
    		categoriaList.setModel(new ListModelList(categoriaManager.getCategoriaList()));
    		categoriaList.setItemRenderer(new CategoriaListRenderer());
    	}
    	
    }
    public void onClick$updateCategoria() throws InterruptedException {
        // process update
    	if(this._categoria!=null){
    		categoriaManager.save(getCategoria());
    		categoriaList.setItemRenderer(new CategoriaListRenderer());
    	}
    	
    }
    public void onClick$deleteCategoria() throws InterruptedException {
        // process delete
    	if(this._categoria!=null){
    		categoriaManager.delete(getCategoria());
    		categoriaList.setModel(new ListModelList(categoriaManager.getCategoriaList()));
    		categoriaList.setItemRenderer(new CategoriaListRenderer());
    	}
    }
    private ListModelList getModel() {
        return (ListModelList) categoriaList.getModel();
    }
    public Categoria getCategoria() {   return _categoria; }
    public void setCategoria(Categoria categoria) { _categoria = categoria; }
    
     
    
    
}