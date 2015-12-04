package com.jva.dao;

import com.jva.entity.Objects;
import javax.ejb.Local;

@Local
public interface ObjectsDao {
    void AddObjects(Objects obj);    
}
