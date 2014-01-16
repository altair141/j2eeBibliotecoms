package com.ufro.model.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ufro.model.bean.Area;

public class AreaDAO extends HibernateDaoSupport {
    public void saveOrUpdate(Area area) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(area);
    }
 
    public void delete(Area area) throws DataAccessException {
        getHibernateTemplate().delete(area);
    }
 
    public Area find(Class<Area> clazz, Integer id) throws DataAccessException {
        Area area = (Area) getHibernateTemplate().load(clazz, id);
        return area;
    }
     
    public List<Area> findAll(Class<Area> clazz) throws DataAccessException {
        List<Area> list = getHibernateTemplate().find("from " + clazz.getName());
        return list;
    }
}
