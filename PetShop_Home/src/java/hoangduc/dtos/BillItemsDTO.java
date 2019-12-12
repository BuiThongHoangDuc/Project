/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.dtos;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class BillItemsDTO implements Serializable{
    private int billitemID,quantity,billID,productID;
    private float price;

    public BillItemsDTO() {
    }

    public BillItemsDTO(int billitemID, int quantity, int billID, int productID, float price) {
        this.billitemID = billitemID;
        this.quantity = quantity;
        this.billID = billID;
        this.productID = productID;
        this.price = price;
    }

    public BillItemsDTO(int quantity, int billID, int productID, float price) {
        this.quantity = quantity;
        this.billID = billID;
        this.productID = productID;
        this.price = price;
    }

    public int getBillitemID() {
        return billitemID;
    }

    public void setBillitemID(int billitemID) {
        this.billitemID = billitemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
