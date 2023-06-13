package com.project.myshoppingwebapp.servlet;

import com.project.myshoppingwebapp.entities.User;
import com.project.myshoppingwebapp.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.util.SerializationHelper;

/**
 *
 * @author Dell
 */
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

//            featching all the data from registeration page and storing in data base
            try {
                String userName = request.getParameter("user_name");
                String userEmail = request.getParameter("user_email");
                String userPassword = request.getParameter("user_password");
                String userPhone = request.getParameter("user_phone");
                String userAddress = request.getParameter("user_address");

                //validation
//                validating name
                if (userName.isEmpty()) {
                    //out.println("Name is blank");
                    HttpSession httpsession = request.getSession();
                    httpsession.setAttribute("message", "Name is Mandatory");
                    response.sendRedirect("register.jsp");
                    return;
                }
                   
                
//                validating for password
                if (userPassword != null) {
                    int passwordLength = 8, upChars = 0, lowChars = 0;
                    int special = 0, digits = 0;
                    char ch;
                    int total = userPassword.length();
                    if (total < passwordLength) {
                        HttpSession httpsession = request.getSession();
                        httpsession.setAttribute("message", "Password is weak.Password should be like (Xyz@1) and atleat have 8 character");
                        response.sendRedirect("register.jsp");

                        return;
                    } else {
                        for (int i = 0; i < total; i++) {
                            ch = userPassword.charAt(i);
                            if (Character.isUpperCase(ch)) {
                                upChars = 1;
                            } else if (Character.isLowerCase(ch)) {
                                lowChars = 1;
                            } else if (Character.isDigit(ch)) {
                                digits = 1;
                            } else {
                                special = 1;
                            }
                        }
                    }
                    if (upChars == 1 && lowChars == 1 && digits == 1 && special == 1) {
//                        System.out.println("\nThe Password is Strong.");
                    } else {
                        HttpSession httpsession = request.getSession();
                        httpsession.setAttribute("message", "Password is weak. Password should be like (Xyz@1) and atleat have 8 character");
                        response.sendRedirect("register.jsp");
                        return;
                    }

                }

                //creating user object
                User user = new User(userName, userEmail, userPassword, userPhone, "default.jpg", userAddress, "normal");

                int userId;
                try (Session hibernateSession = FactoryProvider.getFactory().openSession()) {
                    Transaction tx = hibernateSession.beginTransaction();
                    userId = (int) hibernateSession.save(user);
                    tx.commit();
                    hibernateSession.close();

                    HttpSession httpsession = request.getSession();
                    httpsession.setAttribute("message", "Regestration Successfull !!  " + "User Id : " + userId);
                    response.sendRedirect("register.jsp");
                    return;
                }

                //out.println("Succesfully saved");
                // out.println("<br> your userId id : "+userId);
            } catch (Exception e) {
                e.printStackTrace();
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
