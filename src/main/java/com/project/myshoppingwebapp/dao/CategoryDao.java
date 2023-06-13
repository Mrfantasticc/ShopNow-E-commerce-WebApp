
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.myshoppingwebapp.dao;

import com.project.myshoppingwebapp.entities.Category;
import java.util.List;
//import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class CategoryDao {
//    intalizing sessionfactory to do operaton with database
    private SessionFactory factroy;
    
//    constructor
        public CategoryDao(SessionFactory factroy) {
        this.factroy = factroy;
    }
    
     //creating method
        
        public int saveCategory(Category cat){
            
//            opening session factory
        Session session = this.factroy.openSession();
//        begning transaction
        Transaction tx = session.beginTransaction();
        
        int catId  = (int)session.save(cat);
        tx.commit();
        session.close();
        return catId;
        }
        
//        method to get list of category
        public List<Category> getCategory(){
        Session s = this.factroy.openSession();
//        fireing query to get all category from category class
        Query query = s.createQuery("from Category");
        List<Category> list=query.list();
        return list;
        }
       
//        method to get category by id
        public Category getCategoryById(int cid){
            Category cat=null;
            try {
                Session session = this.factroy.openSession();
                cat = session.get(Category.class,cid);
                session.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cat;
        }
}
