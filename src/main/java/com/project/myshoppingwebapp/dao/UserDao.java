/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.myshoppingwebapp.dao;

import com.project.myshoppingwebapp.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 Dao:(data accessing object)
 * contacting database
 */
public class UserDao {
    private SessionFactory factory; 

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //creating method 
    //get user by email and password
     
    public User getUserByEmailAndPassword(String email,String password){
//        initally user is null
        User user=null;
        
        
        try {
//            sending query to check for username and password
            String query="from User where userEmail=: e and userPassword=: p ";
            Session session = this.factory.openSession();
//            creating query for sql
            Query q = session.createQuery(query);
//            after fatching the data storing email in "e" and password in "p"
//            and returning user
            q.setParameter("e",email);
            q.setParameter("p",password);
            
            user = (User)q.uniqueResult();
            
            
           session.close();
            
            
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return user;
    }
}
