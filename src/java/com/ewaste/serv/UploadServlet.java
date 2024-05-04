package com.ewaste.serv;

import com.ewaste.dao.EwasteCenterDao;
import com.ewaste.dao.EwasteCenterDaoImple;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(fileSizeThreshold = 1024*1024*1,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*100)
public class UploadServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  
  HttpSession session = request.getSession(false);
  String centerId = (String)session.getAttribute("centerId");
  
  if(centerId!=null && !centerId.isEmpty()){
   Part part = request.getPart("centerImage");
   
   String fileName = part.getSubmittedFileName();
   fileName = fileName.substring(fileName.lastIndexOf("."));
   
   fileName = centerId+fileName;
   String filePath = getServletContext().getRealPath("/");
   filePath = filePath+File.separator+fileName;
   FileOutputStream fos = new FileOutputStream(filePath);
   
   InputStream is = part.getInputStream();
   byte ar[] = new byte[1024];
   while((is.read(ar))!=-1){
    fos.write(ar);
   }
   fos.flush();
   is.close();
   
   fos.close();
   EwasteCenterDao edao = new EwasteCenterDaoImple();
   edao.uploadCenterImage(Integer.parseInt(centerId), fileName);
   
   response.sendRedirect("center_list.jsp");
   
  }
 }

}
