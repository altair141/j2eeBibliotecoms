package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Cuenta;

public class CuentaListRenderer implements ListitemRenderer<Object> {

	public void render(Listitem item, Object data) throws Exception {
		Cuenta cuenta = (Cuenta) data;
		item.setValue(cuenta);
		new Listcell(String.valueOf(cuenta.getIdCuenta())).setParent(item);
	
		new Listcell(cuenta.getClave()).setParent(item);

	}

	public void render(Listitem item, Object data, int arg2) throws Exception {
		Cuenta cuenta = (Cuenta) data;
		item.setValue(cuenta);
		new Listcell(String.valueOf(cuenta.getIdCuenta())).setParent(item);
		
		new Listcell(cuenta.getClave()).setParent(item);

	}
}
