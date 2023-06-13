/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.myshoppingwebapp.servlet;

import com.project.myshoppingwebapp.dao.CategoryDao;
import com.project.myshoppingwebapp.dao.ProductDao;
import com.project.myshoppingwebapp.entities.Category;
import com.project.myshoppingwebapp.entities.Product;
import com.project.myshoppingwebapp.helper.FactoryProvider;
import jakarta.servlet.ServletContext;
import javax.servlet.ServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
//import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@MultipartConfig
public class ProductOperationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
//             servlet 2:
//             add category
//             add product
               
               String op=request.getParameter("operation");
               
               if(op.trim().equals("addcategory")){
                   
                    //add category details
                    
                    String title=request.getParameter("catTitle");
                    String description=request.getParameter("catDescription");
                    
                   Category category = new Category();
                   category.setCategoryTitle(title);
                   category.setCategoryDescription(description);
                   
                   
                   //save category in database
                   CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
                   int catId = categoryDao.saveCategory(category);
                   //out.print("category saved" +catId);
                   
                   HttpSession httpSession = request.getSession();
                   httpSession.setAttribute("message","Category is saved successful : "+catId);
                   response.sendRedirect("admin.jsp");
                   return;
                   
                   
               }else if(op.trim().equals("addproduct")){
                   
                   //add product details
                   String pName = request.getParameter("pTitle");
                   String pDesc = request.getParameter("pDescription");
                   int pPrice = Integer.parseInt(request.getParameter("pPrice"));
                   int pDiscount = Integer.parseInt(request.getParameter("pDiscount"));
                   int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
                   int catId = Integer.parseInt(request.getParameter("catId"));
                   
                   
//                   featching file
                   Part part = request.getPart("pPic");
                   
                   
                   //create product object and set product data
                   Product p = new Product();
                   p.setpName(pName);
                   p.setpDesc(pDesc);
                   p.setpPrice(pPrice);
                   p.setdDiscount(pDiscount);
                   p.setpQuantity(pQuantity);
                   p.setpPhoto(part.getSubmittedFileName());
                   
                   
                   
                   //get category by id
                   CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                   Category category = cdao.getCategoryById(catId);
                   
                   p.setCategory(category);
                   
                   
                   // save product in DB
                   ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
                   pdao.saveProduct(p);
                   
                   //pic upload
                   //find out the path to upload photo
                   try {
                       
                   
                   String path ="/img/products/";
                   String realPath=request.getServletContext().getRealPath(path)+part.getSubmittedFileName();
                   System.out.println(realPath);
                   
                   //uploading photo....
                   FileOutputStream fos = new FileOutputStream(realPath);
                   InputStream is = part.getInputStream();
                   
                   //reading pic data...
                   byte [] data=new byte[is.available()];
                   
                   is.read(data);
                   
                   // writing the data ....
                   fos.write(data);
                   fos.close();
                   
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                                           
                   //out.println("product save succesfully..");
                                      
                   HttpSession httpSession = request.getSession();
                   httpSession.setAttribute("message","Product is added successfully...");
                   response.sendRedirect("admin.jsp");
                   return;
                   
                   
                   
               }



            
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
