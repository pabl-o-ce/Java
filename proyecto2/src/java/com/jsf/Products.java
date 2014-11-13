/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

/**
 *
 * @author pablocarrera
 */
public class Products {
    private String name;
    private String color;
    private float price;
    private int stock;
    
    Products(String nm, String col, float pr, int st) {
        this.setName(nm);
        this.setColor(col);
        this.setPrice(pr);
        this.setStock(st);
    }

    public void setName(String nm){
        name = nm;
    }
    public String getName(){
        return name;
    }
    public void setColor(String cl){
        color = cl;
    }
    public String getColor(){
        return color;
    }
    public void setPrice(float pr){
        price = pr;
    }
    public float getPrice(){
        return price;
    }
    public void setStock(int st){
        stock = st;
    }
    public float getStock(){
        return stock;
    }
    public void restStock(int res){
        stock -= res;
    }
}
