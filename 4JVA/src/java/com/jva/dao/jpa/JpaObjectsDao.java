package com.jva.dao.jpa;

import com.jva.dao.ObjectsDao;
import com.jva.entity.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaObjectsDao implements ObjectsDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void AddObjects(Objects obj) {
        em.persist(obj);
    }
}
