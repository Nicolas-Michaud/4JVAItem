/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItemStream;

/**
 *
 * @author nicolas
 */
public class FileUpload {
    public static boolean processFile(String path, FileItemStream fs, HttpServletRequest request) {
        try {
            File file = new File(path + File.separator + "images");
            if(!file.exists()){file.mkdir();}
            File savedFile = new File(file.getAbsolutePath() + File.separator + fs.getName());
            request.getSession().setAttribute("picturePath", fs.getName());
            FileOutputStream fos = new FileOutputStream(savedFile);
            InputStream ips = fs.openStream();
            int x = 0;
            byte[] b = new byte[1024];
            while((x = ips.read(b)) != -1) {
                fos.write(b,0,x);
            }
            fos.flush();
            fos.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }   
        return false;
    }
}
