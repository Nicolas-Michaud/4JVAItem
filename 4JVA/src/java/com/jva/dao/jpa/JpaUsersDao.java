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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class JpaUsersDao implements UsersDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void AddUser(Users user) {
        em.persist(user);
    }
    
    @Override
    public Users GetUser(String username, String password) {     
        
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.firstname= :username AND u.password= :password");
        query.setParameter("username", username);        
        query.setParameter("password", password);
        
        try {
            Users usr = (Users) query.getSingleResult();
            return usr;
        }
        catch (NoResultException exeption) {
            exeption.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Users GetUserByUsername(String username) {
        return (Users)em.createQuery("SELECT u FROM Users WHERE u.username LIKE :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public void UpdateUser(Users user) {
        em.remove(GetUserByUsername(user.getUsername()));
        em.persist(user);
    }
    
}
