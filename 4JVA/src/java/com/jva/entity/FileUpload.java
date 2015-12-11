/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.entity;

import com.sun.webkit.graphics.WCImage;
import static com.sun.webkit.graphics.WCImage.getImage;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
    
    
    public static boolean SaveImage(HttpServletRequest request, String imgName) throws IOException {
        ServletFileUpload upload = new ServletFileUpload();
        try {
        FileItemIterator iterator = upload.getItemIterator(request);
            while (iterator.hasNext()) {
                FileItemStream fileItemStream = iterator.next();
                if (!fileItemStream.isFormField()) {
                    try {
                        File uploads = new File(request.getServletContext().getContextPath() + File.separator + "web/images");
                        if(!uploads.exists()){uploads.mkdir();}
                        File savedFile = new File(uploads.getAbsolutePath() + File.separator + imgName);
                        FileOutputStream fos = new FileOutputStream(savedFile);

                        InputStream ips = fileItemStream.openStream();
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
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
