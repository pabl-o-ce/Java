/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import static com.sun.webkit.perf.WCFontPerfLogger.log;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author pablocarrera
 */
@Named(value = "appStore")
@ApplicationScoped
public class AppStore {
    final private ArrayList items = new ArrayList();
    final private ArrayList itemsSolded = new ArrayList();
    Products camisasRojas;
    Products camisasAzules;
    Products camisasMoradas;
    Products camisasNegras;
    Products zapatosCafes;
    Products zapatosNegros;
    Products zapatosBlancos;
    String nm;
    String col;
    int cantidad;
    int indexpro;
    double preciototal;
    String totalMessage;
    
    AppStore() {
        camisasRojas = new Products(0,"Camisas","Rojas", ((float) 30), ((int)5));
        camisasAzules = new Products(1,"Camisas","Azules", ((float) 20), ((int)3));
        camisasMoradas = new Products(2,"Camisas","Moradas", ((float) 15), ((int)2));
        camisasNegras = new Products(3,"Camisas","Negras", ((float) 25), ((int)4));
        zapatosCafes = new Products(4,"Zapatos","Cafes", ((float) 25),((int)5));
        zapatosNegros = new Products(5,"Zapatos","Negros", ((float) 45),((int)3));
        zapatosBlancos = new Products(6,"Zapatos","Blancos", ((float) 55),((int)2));
        items.add(0,camisasRojas);
        items.add(1,camisasAzules);
        items.add(2,camisasMoradas);
        items.add(3,camisasNegras);
        items.add(4,zapatosCafes);
        items.add(5,zapatosNegros);
        items.add(6,zapatosBlancos);
        
    }
    public void setTotalMessage(){
        totalMessage = "Su pedido es de:"+((Products) items.get(indexpro)).getNameColor() +""
                + "con un precio de $"+String.valueOf(this.getPreciototal())+"";
    }
    public String getTotalMessage(){
        return totalMessage;
    }
    public void setPreciototal(double sub){
        double task = 1.075;
        preciototal = sub*task;
    }
    public double getPreciototal(){
        return preciototal;
    }
    public void setIndexpro(int n){
        indexpro = n;
    }
    public int getIndexpro(){
        return indexpro;
    }
    public void setNm(String n){
        nm = n;
    }
    public String getNm(){
        return nm;
    }
    public void setCol(String cl){
        col = cl;
    }
    public String getCol(){
        return col;
    }
    public void setCantidad(int can){
        cantidad = can;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setItem(int in, Products p){
        items.add(in,p);
    }
    public Object[] getItems(){
        return items.toArray();
    }
    public void setItemStock(String nm, String col, int n){
        if(nm.contentEquals("Camisas")){
            
            if(col.contentEquals("Rojas")){
                ((Products) items.get(0)).restStock(n);
            }else if(col.contentEquals("Azules")){
                ((Products) items.get(1)).restStock(n);
            }else if(col.contentEquals("Moradas")){
                ((Products) items.get(2)).restStock(n);
            }else if(col.contentEquals("Negras")){
                ((Products) items.get(3)).restStock(n);
            }
            
        }else if(nm.contentEquals("Zapatos")){
            
            if(col.contentEquals("Cafes")){
                ((Products) items.get(4)).restStock(n);
            }else if(col.contentEquals("Negros")){
                ((Products) items.get(5)).restStock(n);
            }else if(col.contentEquals("Blancos")){
                ((Products) items.get(6)).restStock(n);
            }
            
        }
    }
    
    public void validateQuantity(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int quantity = (int) value;
        Integer stock = ((Products) items.get(indexpro)).getStock();
        String msg = "Verifica el numero de items que tenemos en stock="+stock.toString()+"! y pon algo racional, no esto: "+value.toString();
        String msg2 = "Verifica que seleccionaste el producto primero";
        String msg3 = "Lo lamento ya no tenemos en stock=0 este producto! game over! man!";
        this.setTotalMessage();
        if (quantity>stock || quantity<0) {
          throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }else if(indexpro==-1){
          throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg2, msg2));
        }else if(stock == 0){
          throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg3, msg3));
        }
    }
    
    public void validateProduct(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String parm = value.toString();
        String msg = "Verifica seleccionar un producto que quiera comprar";
        this.setTotalMessage();
        if (parm.contentEquals("-1")) {
          throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
    }
    public String sendOrder(){
        int p = (int) ((Products) items.get(indexpro)).getPrice();
        ((Products) items.get(indexpro)).restStock(cantidad);
        double subcantidad = p*cantidad;
        this.setPreciototal(subcantidad);
        this.setTotalMessage();
        return "index";
    }
}
