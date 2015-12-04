package com.jva.dao.jpa;

import com.jva.dao.ObjectsDao;
import com.jva.entity.Objects;
import com.jva.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class JpaObjectsDao implements ObjectsDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void AddObjects(Objects obj) {
        em.persist(obj);
    }
    
    @Override
    public Objects GetObjectsByTitle(String title) {     
        
        Query query = em.createQuery("SELECT u FROM Objects u WHERE u.title LIKE '%:title%'");
        query.setParameter("title", title);        

        
        try {
            Objects obj = (Objects) query.getSingleResult();
            return obj;
        }
        catch (NoResultException exeption) {
            exeption.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Objects GetObjects() {
        return (Objects)em.createQuery("SELECT u FROM Objects")
                .getSingleResult();
    }

    @Override
    public void UpdateObjects(Objects objects) {
        em.remove(GetObjectsByTitle(objects.getTitle()));
        em.persist(objects);
    }
}
