package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Usuario;

public class UsuarioListRenderer implements ListitemRenderer<Object> {

	public void render(Listitem item, Object data) throws Exception {
		Usuario usuario = (Usuario) data;
		item.setValue(usuario);
		new Listcell(String.valueOf(usuario.getRut())).setParent(item);
		new Listcell(usuario.getdVerificador()).setParent(item);
		new Listcell(usuario.getApellido1()).setParent(item);
		new Listcell(usuario.getApellido2()).setParent(item);
		new Listcell(usuario.getDireccion()).setParent(item);
		new Listcell(usuario.getEmail()).setParent(item);
		new Listcell(String.valueOf(usuario.getFono())).setParent(item);
		new Listcell(usuario.getNombre()).setParent(item);
		
	}

	public void render(Listitem item, Object data, int arg2) throws Exception {
		Usuario usuario = (Usuario) data;
		item.setValue(usuario);
		new Listcell(String.valueOf(usuario.getRut())).setParent(item);
		new Listcell(usuario.getdVerificador()).setParent(item);
		new Listcell(usuario.getApellido1()).setParent(item);
		new Listcell(usuario.getApellido2()).setParent(item);
		new Listcell(usuario.getDireccion()).setParent(item);
		new Listcell(usuario.getEmail()).setParent(item);
		new Listcell(String.valueOf(usuario.getFono())).setParent(item);
		new Listcell(usuario.getNombre()).setParent(item);
		
	}
}
