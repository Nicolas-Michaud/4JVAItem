package com.jva.dao;

import com.jva.entity.Users;
import javax.ejb.Local;

@Local
public interface UsersDao {
    void AddUser(Users user);    
    void UpdateUser(Users user);
    public Users GetUserByUsername(String username);
    public Users GetUser(String username, String password);
}
