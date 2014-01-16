package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Articulo;

public class ArticuloListRenderer implements ListitemRenderer<Object> {
    public void render(Listitem item, Object data) throws Exception {
        Articulo articulo = (Articulo) data;
        item.setValue(articulo);
        new Listcell(String.valueOf(articulo.getIdArticulo())).setParent(item);
        new Listcell(articulo.getNombreArt()).setParent(item);
        new Listcell(String.valueOf(articulo.getPrecioArt())).setParent(item);
        new Listcell(String.valueOf(articulo.getCategoria())).setParent(item);
        
    }

	public void render(Listitem item, Object data, int arg2) throws Exception {
        Articulo articulo = (Articulo) data;
        item.setValue(articulo);
        new Listcell(String.valueOf(articulo.getIdArticulo())).setParent(item);
        new Listcell(articulo.getNombreArt()).setParent(item);
        new Listcell(String.valueOf(articulo.getPrecioArt())).setParent(item);
        new Listcell(String.valueOf(articulo.getCategoria())).setParent(item);
        
        
		
	}
}