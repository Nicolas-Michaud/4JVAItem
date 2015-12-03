package com.jva.dao;

import com.jva.entity.User;
import javax.ejb.Local;

@Local
public interface UserDao {
    void AddUser(User user);    
    void UpdateUser(User olduser, User newUser);
}
