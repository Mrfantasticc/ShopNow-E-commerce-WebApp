/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.myshoppingwebapp.helper;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Helper {
    
//    displaying only 10 word in product discription from description which is saved in data base
    public static String get10Words(String desc){
//        spliting the description , if we found " " and concatinating it in res string
        String[] strs =desc.split(" ");
        if (strs.length>10){
            String res="";
            for(int i=0;i<10;i++){
                res=res+strs[i]+" ";
            }
            return (res+"...");
        }else{
            return desc+"...";
        }
    }
    
//    getting count of all product and user avaliable in data abse
//    fireing query q1 and q1 to get no. of user and no. of product
    public static Map<String,Long> getCounts(SessionFactory factory){
        Session session = factory.openSession();
        String q1="Select count(*) from User";
        String q2="Select count(*) from Product";
        Query query1=session.createQuery(q1);
        Query query2=session.createQuery(q2);
        
        Long userCount=(Long)query1.list().get(0);
        Long productCount=(Long)query2.list().get(0);
        
//        storing count of user and product in hashmap 
        Map<String,Long> map=new HashMap<>();
        map.put("userCount",userCount);
        map.put("productCount",productCount);
        
        session.close();
        
        return map;
    }
    
}
