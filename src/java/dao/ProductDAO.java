/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Product;

/**
 *
 * @author be_me
 */
public class ProductDAO {
    
    /* Gets number of top products specified */
    /* we are gonna fake this one */
    public ArrayList<Product> getTopProducts(int numProducts){
        
        ArrayList<Product> prods = new ArrayList();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Rex");
        p1.setDescription("Dog Minding Opportunity");
        p1.setPrice(13);
        p1.setImageLocation("dog1.jpg");
        prods.add(p1);
        
        Product p2 = new Product();
        p2.setId(1);
        p2.setName("Sam");
        p2.setDescription("Dog Minding Opportunity");
        p2.setPrice(5);
        p2.setImageLocation("dog7.jpg");
        prods.add(p2);
        
        Product p3 = new Product();
        p3.setId(1);
        p3.setName("Bella");
        p3.setDescription("Dog Walking Opportunity");
        p3.setPrice(5);
        p3.setImageLocation("dog3.jpg");
        prods.add(p3);
        
        Product p4 = new Product();
        p4.setId(1);
        p4.setName("Buddy");
        p4.setDescription("Dog Minding Opportunity");
        p4.setPrice(5);
        p4.setImageLocation("dog4.jpg");
        prods.add(p4);
        
        Product p5 = new Product();
        p5.setId(1);
        p5.setName("Max");
        p5.setDescription("Dog Walking Opportunity");
        p5.setPrice(17);
        p5.setImageLocation("dog2.jpg");
        prods.add(p5);
        
        Product p6 = new Product();
        p6.setId(1);
        p6.setName("Rover");
        p6.setDescription("Dog Minding Opportunity");
        p6.setPrice(17);
        p6.setImageLocation("dog6.jpg");
        prods.add(p6);
        
        return prods;     
        
    }
    
}
