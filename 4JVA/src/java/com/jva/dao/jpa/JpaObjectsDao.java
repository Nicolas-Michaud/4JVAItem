package com.jva.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaObjectsDao {
    
    @PersistenceContext
    private EntityManager em;
    
    
}
