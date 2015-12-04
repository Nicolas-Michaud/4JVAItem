/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.dao.jpa;

import com.jva.dao.UsersDao;
import com.jva.entity.Users;
import java.util.List;
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
    
    public void DeleteUser(Users user) {
        em.remove(user);
    }
    
    @Override
    public Users GetUser(String username, String password) {     
        
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.username= :username AND u.password= :password");
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
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.username= :username")
            .setParameter("username", username);
            
        try {
            Users usr = (Users) query.getSingleResult();
            return usr;
            
        } catch (NoResultException exeption) {
            exeption.printStackTrace();
            return null;
        }
        
    }

    @Override
    public void UpdateUser(Users user) {
        Users userbefore = GetUserByUsername(user.getUsername());
        DeleteUser(userbefore);
        em.persist(user);
        /*em.createQuery("UPDATE Users u SET u.firstname= :firstname, u.lastname= :lastname, u.email= :email, u.zipcode= :zipcode, u.password= :password WHERE u.username= :username")
            .setParameter("firstname",user.getFirstname())
            .setParameter("lastname",user.getLastname())
            .setParameter("email",user.getEmail())
            .setParameter("zipcode",user.getZipcode())
            .setParameter("password",user.getPassword())
            .setParameter("username",user.getUsername())
            .executeUpdate();*/
    }

    @Override
    public int CountUsers() {
        List<Users> users = em.createQuery("SELECT u FROM Users u").getResultList();
        return users.size();
    }
    
}
