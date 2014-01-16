package com.ufro.view.ctrl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.ufro.model.bean.Area;


public class AreaListRenderer implements ListitemRenderer<Object> {
    
	public void render(Listitem item, Object data) throws Exception {
        Area area = (Area) data;
        item.setValue(area);
        new Listcell(String.valueOf(area.getIdArea())).setParent(item);
        new Listcell(area.getNombreArea()).setParent(item);
        
        
    }
	public void render(Listitem item, Object data, int arg2) throws Exception {
        Area area = (Area) data;
        item.setValue(area);
        new Listcell(String.valueOf(area.getIdArea())).setParent(item);
        new Listcell(area.getNombreArea()).setParent(item);
        
        
        
		
	}


		
	}


