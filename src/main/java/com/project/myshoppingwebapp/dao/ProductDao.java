/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.myshoppingwebapp.dao;
import com.project.myshoppingwebapp.entities.Product;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class ProductDao {
//    initilazing sessin factory
    private SessionFactory factory;
    
//    constructor
    public ProductDao(SessionFactory factory){
        this.factory=factory;
    }
    
//    method to save product
    public boolean saveProduct(Product product){
//        to check product is saved or not we use f
//        initaly f should be false and if product is added ,it will become true
        boolean f=false;
        try {
            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();
//            save product to data base
            session.save(product);
            tx.commit();
            session.close();
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
            f=false;
        }
        return f;
    }
    
    
//    get all product
    
    public List<Product> getAllProducts(){
        Session s = this.factory.openSession();
//        fireing query to get all product from database
        Query query = s.createQuery("from Product");
        List<Product> list=query.list();
        return list;
    }
    
//    get all product by category wise
    public List<Product> getAllProductsById(int cid){
        Session s = this.factory.openSession();
//        fireing query to get all product from database by category id
        Query query = s.createQuery("from Product as product where product.category.categoryId =: id");
        query.setParameter("id",cid);
        List<Product> list=query.list();
        return list;
    }
    
}
