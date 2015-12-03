/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.dao.jpa;

import com.jva.dao.UsersDao;
import com.jva.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaUsersDao implements UsersDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void AddUser(Users user) {
        em.persist(user);
    }

    @Override
    public void UpdateUser(Users olduser, Users newUser) {
        em.remove(olduser);
        em.persist(newUser);
    }
    
}
