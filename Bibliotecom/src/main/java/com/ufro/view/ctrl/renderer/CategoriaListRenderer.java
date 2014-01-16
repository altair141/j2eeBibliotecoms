package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Categoria;

public class CategoriaListRenderer implements ListitemRenderer {
    public void render(Listitem item, Object data) throws Exception {
        Categoria categoria = (Categoria) data;
        item.setValue(categoria);
        new Listcell(String.valueOf(categoria.getIdCategoria())).setParent(item);
        new Listcell(categoria.getCatNombre()).setParent(item);
        
        
    }

	public void render(Listitem item, Object data, int arg2) throws Exception {
        Categoria categoria = (Categoria) data;
        item.setValue(categoria);
        new Listcell(String.valueOf(categoria.getIdCategoria())).setParent(item);
        new Listcell(categoria.getCatNombre()).setParent(item);
        
        
		
	}
}