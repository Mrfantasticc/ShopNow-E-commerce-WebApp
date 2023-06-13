
package com.project.myshoppingwebapp.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//in this helper class we are configuring and connecting with data base to perform CURD oprtation
public class FactoryProvider{
    private static SessionFactory factory;
    
    public static SessionFactory getFactory(){
//       checking if factory is null , then building or starting our hibernate session and configuring
//        if factroy is not null , then returning factroy
        try {
            if(factory==null){
            factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return factory;
    }
}
