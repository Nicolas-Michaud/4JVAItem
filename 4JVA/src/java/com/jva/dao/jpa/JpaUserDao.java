/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.dao.jpa;

import com.jva.dao.UserDao;
import com.jva.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaUserDao implements UserDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void AddUser(User user) {
        em.persist(user);
    }

    @Override
    public void UpdateUser(User olduser, User newUser) {
        em.remove(olduser);
        em.persist(newUser);
    }
    
}
