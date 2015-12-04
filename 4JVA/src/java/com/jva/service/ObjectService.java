/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.service;

import com.jva.dao.ObjectsDao;
import com.jva.entity.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ObjectService {
    @EJB
    private ObjectsDao objectsdao;
    
    public void addUser(Objects objects) {
       objectsdao.AddObjects(objects);
    }
    
    public void UpdateObjects(Objects objects) {
        objectsdao.UpdateObjects(objects);
    }
    
    public Objects GetObjectsByTitle(String title) {
        return objectsdao.GetObjectsByTitle(title);
    }
    
    public Objects GetUser() {
        return objectsdao.GetObjects();
    }
}
