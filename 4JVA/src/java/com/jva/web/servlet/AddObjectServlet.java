/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet;


import com.jva.entity.Objects;
import com.jva.entity.Users;
import com.jva.service.ObjectService;
import com.jva.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "AddObjectServlet", urlPatterns = {"/addObject"})
public class AddObjectServlet extends HttpServlet {

    @EJB
    public UserService userservice;
    
    @EJB
    public ObjectService objectservice;
    
    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addObject.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/HTML");
        
        Objects obj = new Objects();
        obj.setTitle(request.getParameter("title"));
        obj.setDescription(request.getParameter("description"));
        obj.setTypeof(request.getParameter("typeof"));
        obj.setPrice(44);
            
        request.getSession().setAttribute("picturePath", "none");
        GetImage(request, response);
        String path = request.getSession().getAttribute("picturePath").toString();
        obj.setPicture(path);
        
        Users user = userservice.GetUserByUsername(request.getSession().getAttribute("username").toString());
        obj.setUser(user);
        
        objectservice.AddObjects(obj);
        
        response.sendRedirect(request.getContextPath());
    }
    
    
    public FileItemStream GetImage (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        
        if(isMultipart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);
                while (itr.hasNext()) {
                    FileItemStream fs = itr.next();
                    if(fs.isFormField()) {
                        String fieldName = fs.getFieldName();
                        InputStream ips = fs.openStream();
                        byte[] b = new byte[ips.available()];
                        ips.read(b);
                        String value = new String(b);
                        response.getWriter().println(fieldName + "/" + value + "<br/>");
                        
                    }else {
                        String path = getServletContext().getRealPath("/");
                        if(FileUpload.processFile(path, fs, request)) {
                            response.getWriter().println("file uploaded successfully");
                        } else {
                            response.getWriter().println("file uploading failed");
                        }
                    } 
                }
            }catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
