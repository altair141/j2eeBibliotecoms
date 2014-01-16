package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Libro;

public class LibroListRenderer implements ListitemRenderer<Object> {

	public void render(Listitem item, Object data) throws Exception {
		Libro libro = (Libro) data;
		item.setValue(libro);
		new Listcell(String.valueOf(libro.getAgno())).setParent(item);
		new Listcell(libro.getAutor()).setParent(item);
		new Listcell(libro.getDescripcion()).setParent(item);
		new Listcell(libro.getEditorial()).setParent(item);
		new Listcell(libro.getIsbn()).setParent(item);
		new Listcell(libro.getTitulo()).setParent(item);
		new Listcell(String.valueOf(libro.getCodigoRegistro())).setParent(item);


	}

	public void render(Listitem item, Object data, int arg2) throws Exception {
		Libro libro = (Libro) data;
		item.setValue(libro);
		new Listcell(String.valueOf(libro.getAgno())).setParent(item);
		new Listcell(libro.getAutor()).setParent(item);
		new Listcell(libro.getDescripcion()).setParent(item);
		new Listcell(libro.getEditorial()).setParent(item);
		new Listcell(libro.getIsbn()).setParent(item);
		new Listcell(libro.getTitulo()).setParent(item);
		new Listcell(String.valueOf(libro.getCodigoRegistro())).setParent(item);


	}
}
