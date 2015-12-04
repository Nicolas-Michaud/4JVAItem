/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.service;

import com.jva.dao.UsersDao;
import com.jva.entity.Users;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {
    
    @EJB
    private UsersDao userdao;
    
    public void AddUser(Users user) {
        userdao.AddUser(user);
    }
    
    public void UpdateUser(Users user) {
        userdao.UpdateUser(user);
    }
    
    public Users GetUserByUsername(String username) {
        return userdao.GetUserByUsername(username);
    }
    
    public Users GetUser(String username, String password) {
        return userdao.GetUser(username, password);
    }
    
    public int CountUsers() {
        return userdao.CountUsers();
    }
}
