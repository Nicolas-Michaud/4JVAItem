/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet;

import com.jva.entity.Users;
import com.jva.service.UserService;
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
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {

    @EJB
    private UserService userservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object toto = request.getSession().getAttribute("username");
        if(toto != null) {
            Users user = userservice.GetUserByUsername(toto.toString());
            request.setAttribute("user", user);
            request.getRequestDispatcher("/jsp/updateUser.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = new Users();
        user.setUsername(request.getSession().getAttribute("username").toString());
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setZipcode(Long.parseLong(request.getParameter("zipcode"), 10));
        user.setPassword(request.getParameter("password"));
        
        userservice.UpdateUser(user);
        
        response.sendRedirect(request.getContextPath());
    }
}
