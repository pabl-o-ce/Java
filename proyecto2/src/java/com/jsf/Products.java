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
    private int id;
    
    Products(int i,String nm, String col, float pr, int st) {
        id=i;
        name=nm;
        color=col;
        price=pr;
        stock=st;
    }
    public int getId(){
        return id;
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
    public int getStock(){
        return stock;
    }
    public void restStock(int res){
        stock -= res;
    }
    public String getNameColor(){
        String p = this.getName()+ " ".concat(this.getColor());
        return p;
    }
}
