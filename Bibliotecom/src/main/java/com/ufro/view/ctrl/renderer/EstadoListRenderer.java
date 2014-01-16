package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Estado;


public class EstadoListRenderer implements ListitemRenderer<Object> {
    
	public void render(Listitem item, Object data) throws Exception {
        Estado estado = (Estado) data;
        item.setValue(estado);
        new Listcell(String.valueOf(estado.getIdEstado())).setParent(item);
        new Listcell(estado.getNombreEstado()).setParent(item);
        
        
    }
	public void render(Listitem item, Object data, int arg2) throws Exception {
        Estado estado = (Estado) data;
        item.setValue(estado);
        new Listcell(String.valueOf(estado.getIdEstado())).setParent(item);
        new Listcell(estado.getNombreEstado()).setParent(item);
        
        
        
		
	}


		
	}


