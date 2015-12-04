package com.jva.dao;

import com.jva.entity.Objects;
import javax.ejb.Local;

@Local
public interface ObjectsDao {
    void AddObjects(Objects obj);    
    void UpdateObjects(Objects obj);
    public Objects GetObjectsByTitle(String title);
    public Objects GetObjects();
}
