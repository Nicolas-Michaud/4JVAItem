package com.jva.dao;

import com.jva.entity.Objects;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ObjectsDao {
    void AddObjects(Objects obj);    
    void UpdateObjects(Objects obj);
    public Objects GetObjectsByTitle(String title);
    public Objects GetObjects();
    public int CountObjects();
    public List<Objects> ListObjects();
}
