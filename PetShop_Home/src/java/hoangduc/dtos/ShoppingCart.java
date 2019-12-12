/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class ShoppingCart implements Serializable{
    private String customerName;
    private HashMap<Integer,ProductDTO> cart;
    
    public ShoppingCart()
    {
        this.cart = new HashMap<>();
        this.customerName = "Guest";
    }
    
    public ShoppingCart(String customerName)
    {
        this.cart = new HashMap<>();
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<Integer, ProductDTO> getCart() {
        return cart;
    }
    
    public void addCart(ProductDTO dto) throws Exception
    {
        if(this.cart.containsKey(dto.getProductid()))
        {
            int quantity = this.cart.get(dto.getProductid()).getProductquantity()+1;
            dto.setProductquantity(quantity);
        }
        this.cart.put(dto.getProductid(), dto);
    }
    
    public void removeProductCart(int id) throws Exception
    {
        if(this.cart.containsKey(id))
        {
            this.cart.remove(id);
        }
    }
    
    public float getTotal() throws Exception
    {
        float result = 0;
        for(ProductDTO dto : this.cart.values()){
            result += dto.getProductprice() * dto.getProductquantity();
        }
        return result;
    }
    
    public void updateCart(int id,int quantity) throws Exception
    {
        if(this.cart.containsKey(id))
        {
            this.cart.get(id).setProductquantity(quantity);
        }
    }
            
}
