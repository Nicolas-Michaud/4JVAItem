/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet;

import com.jva.entity.Objects;
import com.jva.service.ObjectService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListObjectServlet", urlPatterns = {"/listObjects"})
public class ListObjectServlet extends HttpServlet {

    @EJB
    private ObjectService objectservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Objects> objList = objectservice.ListObjects();
        String path = getServletContext().getRealPath("/");
        String pathToPicture = path + "images/";
          
        
        
        request.setAttribute("listObjects", objList);        
        request.setAttribute("pathToPicture", pathToPicture);

        request.getRequestDispatcher("/jsp/listObjects.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }
}
