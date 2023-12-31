/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.myshoppingwebapp.servlet;

import com.project.myshoppingwebapp.dao.UserDao;
import com.project.myshoppingwebapp.entities.User;
import com.project.myshoppingwebapp.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //coding area
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            //validation
            //authenticating user
            UserDao userDao = new UserDao(FactoryProvider.getFactory());
            User user = userDao.getUserByEmailAndPassword(email, password);
            
            //System.out.println(user);
            HttpSession httpsession = request.getSession();
//            checking that user is avaliable in data base or not
//            if user is avaliable then user will be not null and if not then it will be null
            
            if(user==null){
                
                httpsession.setAttribute("message","Invalid Details !! Try with correct details ");
                response.sendRedirect("login.jsp");
                return;
            }else{
                out.println("<h1>Welcome "+user.getUserName()+"</h1>");
                
                //store login details in current-user
                httpsession.setAttribute("current-user", user);
                //admin login
                if(user.getUserType().equals("admin")){
                    response.sendRedirect("admin.jsp");
                    
                    //user login
                }else if(user.getUserType().equals("normal")){
                    response.sendRedirect("normal.jsp");
                }else{
                    out.println("we have not identify user type");
                }
               
            }
            


        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
