package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.TipoUsuario;

public class TipoUsuarioListRenderer implements ListitemRenderer<Object> {

	public void render(Listitem item, Object data) throws Exception {
		TipoUsuario tipoUsuarioLibro = (TipoUsuario) data;
		item.setValue(tipoUsuarioLibro);
		new Listcell(String.valueOf(tipoUsuarioLibro.getIdTipoUsuario()))
				.setParent(item);
		new Listcell(tipoUsuarioLibro.getNombreTipo()).setParent(item);

	}

	public void render(Listitem item, Object data, int arg2) throws Exception {
		TipoUsuario tipoUsuarioLibro = (TipoUsuario) data;
		item.setValue(tipoUsuarioLibro);
		new Listcell(String.valueOf(tipoUsuarioLibro.getIdTipoUsuario()))
				.setParent(item);
		new Listcell(tipoUsuarioLibro.getNombreTipo()).setParent(item);
	}
}
