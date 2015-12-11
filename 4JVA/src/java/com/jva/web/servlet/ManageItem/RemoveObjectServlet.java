/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet.ManageItem;

import com.jva.dao.ItemDao;
import com.jva.entity.Item;
import com.jva.service.ItemService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolas
 */
@WebServlet(name = "RemoveObject", urlPatterns = {"/user/object/remove"})
public class RemoveObjectServlet extends HttpServlet {

    @EJB
    ItemService objservice;
    
    
    @EJB
    private ItemDao objectsdao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        
        Item obj = objservice.GetItemByTitle(title);
        objectsdao.DeleteItem(obj);
        
        response.sendRedirect(getServletContext().getContextPath() + "/listObjects");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }
}
