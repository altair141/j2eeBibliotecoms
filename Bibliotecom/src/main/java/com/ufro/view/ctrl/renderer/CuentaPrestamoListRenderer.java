package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.CuentaPrestamo;

public class CuentaPrestamoListRenderer implements ListitemRenderer<Object> {

	public void render(Listitem item, Object data) throws Exception {
		CuentaPrestamo cuentaPrestamo = (CuentaPrestamo) data;
		item.setValue(cuentaPrestamo);
		//new Listcell(String.valueOf(cuentaPrestamo.getIdCuentaLibro())).setParent(item);
		

	}

	public void render(Listitem item, Object data, int arg2) throws Exception {
		CuentaPrestamo cuentaPrestamo = (CuentaPrestamo) data;
		item.setValue(cuentaPrestamo);
		//new Listcell(String.valueOf(cuentaPrestamo.getIdCuentaLibro())).setParent(item);
		
	}
}

