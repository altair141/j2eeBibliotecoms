package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Prestamo;

public class PrestamoListRenderer implements ListitemRenderer<Object> {

	public void render(Listitem item, Object data) throws Exception {
		Prestamo prestamo = (Prestamo) data;
		item.setValue(prestamo);
		new Listcell(String.valueOf(prestamo.getIdPrestamo())).setParent(item);
		new Listcell(String.valueOf(prestamo.getFechaPrestamo())).setParent(item);


	}

	public void render(Listitem item, Object data, int arg2) throws Exception {
		Prestamo prestamo = (Prestamo) data;
		item.setValue(prestamo);
		new Listcell(String.valueOf(prestamo.getIdPrestamo())).setParent(item);
		new Listcell(String.valueOf(prestamo.getFechaPrestamo())).setParent(item);


	}
}
