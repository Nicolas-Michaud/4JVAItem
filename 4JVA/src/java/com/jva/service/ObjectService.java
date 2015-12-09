/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.service;

import com.jva.dao.ObjectsDao;
import com.jva.entity.Objects;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ObjectService {
    @EJB
    private ObjectsDao objectsdao;
    
    public void AddObjects(Objects objects) {
       objectsdao.AddObjects(objects);
    }
    
    public void UpdateObjects(Objects objects) {
        objectsdao.UpdateObjects(objects);
    }
    
    public Objects GetObjectsByTitle(String title) {
        return objectsdao.GetObjectsByTitle(title);
    }
    
    public Objects GetObjects() {
        return objectsdao.GetObjects();
    }
    
    public int CountObjects() {
        return objectsdao.CountObjects();
    }
    
    public List<Objects> ListObjects () {
        return objectsdao.ListObjects();
    }
}
