package com.ufro.service;

import java.util.List;

import com.ufro.model.bean.Area;

public interface AreaManager {
    public boolean save(Area area);
    public boolean delete(Area area);
    public Area getArea(Integer id);
    public List<Area> getAreaList();
}
