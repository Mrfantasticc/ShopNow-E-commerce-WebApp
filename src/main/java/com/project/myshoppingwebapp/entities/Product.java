
package com.project.myshoppingwebapp.entities;

//import jakarta.persistence.Column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


//creating table in data base with name product
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String pName;
    @Column(length = 3000)
    private String pDesc;
    private String pPhoto;
    private int pPrice;
    private int dDiscount;
    private int pQuantity;
//    mapping many to one 
//    because many product can have one category
   @ManyToOne
    private Category category; //prduct v kisi tarah ka category hoga isliya ye many to one mapping hoga

    public Product() {
    }

    public Product(String pName, String pDesc, String pPhoto, int pPrice, int dDiscount, int pQuantity, Category category) {
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.dDiscount = dDiscount;
        this.pQuantity = pQuantity;
        this.category=category;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getdDiscount() {
        return dDiscount;
    }

    public void setdDiscount(int dDiscount) {
        this.dDiscount = dDiscount;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    @Override
    public String toString() {
        return "Product{" + "pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice=" + pPrice + ", dDiscount=" + dDiscount + ", pQuantity=" + pQuantity + '}';
    }
    
//    claculate price after discount
    public int getPrinceAfterApplyingDiscount(){
        int d=(int)((this.getdDiscount() / 100.0)* this.getpPrice());
        return this.getpPrice()-d;
    }
}
