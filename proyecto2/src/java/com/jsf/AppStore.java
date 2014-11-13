/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author pablocarrera
 */
@Named(value = "appStore")
@ApplicationScoped
public class AppStore {
    final private ArrayList items = new ArrayList();
    
    public AppStore() {
        Products camisasRojas = new Products("Camisas","Rojas", (float) 30, 5);
        Products camisasAzules = new Products("Camisas","Azules", (float) 20, 5);
        Products camisasMoradas = new Products("Camisas","Moradas", (float) 15, 5);
        Products camisasNegras = new Products("Camisas","Negras", (float) 25, 5);
        Products zapatosCafes = new Products("Zapatos","Cafes", (float) 25,5);
        Products zapatosNegros = new Products("Zapatos","Negros", (float) 45,5);
        Products zapatosBlancos = new Products("Zapatos","Blancos", (float) 55,5);
        this.setItem(1,camisasRojas);
        this.setItem(2,camisasAzules);
        this.setItem(3,camisasMoradas);
        this.setItem(4,camisasNegras);
        this.setItem(5,zapatosCafes);
        this.setItem(6,zapatosNegros);
        this.setItem(7,zapatosBlancos);
        
    }
    public void setItem(int in, Products p){
        items.add(in,p);
    }
    public Products getItem(int n){
        return (Products) items.get(n);
    }
    public void setItemStock(String nm, String col,int n){
        if(nm.contentEquals("Camisas")){
            
            if(col.contentEquals("Rojas")){
                
            }else if(col.contentEquals("Azules")){
                
            }else if(col.contentEquals("Moradas")){
                
            }else if(col.contentEquals("Negras")){
                
            }
            
        }else if(nm.contentEquals("Zapatos")){
            
            if(col.contentEquals("Cafes")){
                
            }else if(col.contentEquals("Negros")){
                
            }else if(col.contentEquals("Blancos")){
                
            }
            
        }
    }
}
