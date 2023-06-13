
package com.project.myshoppingwebapp.entities;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;






//creating table
@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int categoryId;
    @Column
    private String categoryTitle;
    @Column
    private String categoryDescription;
    
//    mapping two table by one to many
//    because one category can have many products
   @OneToMany(mappedBy = "category")
    private List<Product> products=new ArrayList<>();

    public Category(int categoryId, String categoryTitle, String categoryDescription) {
        this.products = new ArrayList<>();
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public Category(String categoryTitle, String categoryDescription, List<Product> products) {
        this.products = new ArrayList<>();
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.products=products;
    }

    public Category(String categoryTitle, String categoryDescription) {
        this.products = new ArrayList<>();
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public Category() {
        this.products = new ArrayList<>();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription=" + categoryDescription + '}';
    }
    
    
}
