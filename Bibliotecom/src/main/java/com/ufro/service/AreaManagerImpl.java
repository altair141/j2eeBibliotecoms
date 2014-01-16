package com.ufro.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ufro.model.bean.Area;
import com.ufro.model.dao.AreaDAO;

public class AreaManagerImpl implements AreaManager {
    private AreaDAO areaDAO;
 
    public AreaDAO getAreaDAO() {
        return areaDAO;
    }
 
    public void setAreaDAO(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }
 
    @Transactional
    public boolean save(Area area) {
        try {
            areaDAO.saveOrUpdate(area);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional
    public boolean delete(Area area) {
        try {
            areaDAO.delete(area);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
     
    @Transactional(readOnly = true)
    public Area getArea(Integer id) {
        try {
            return areaDAO.find(Area.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }
     
    @Transactional(readOnly = true)
    public List<Area> getAreaList() {
        try {
            return areaDAO.findAll(Area.class);
        } catch (DataAccessException e) {
            return null;
        }
    }
}