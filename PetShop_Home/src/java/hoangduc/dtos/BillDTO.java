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
public class BillDTO implements Serializable{
    private int billID,userID,quantity;
    private String datetime;
    private String status,username,productname,productimage;
    private float priceproduct;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public float getPriceproduct() {
        return priceproduct;
    }

    public void setPriceproduct(float priceproduct) {
        this.priceproduct = priceproduct;
    }

    public BillDTO(int quantity, String datetime, String productname, String productimage, float priceproduct) {
        this.quantity = quantity;
        this.datetime = datetime;
        this.productname = productname;
        this.productimage = productimage;
        this.priceproduct = priceproduct;
    }

    public BillDTO(int billID, String datetime, String status, String username) {
        this.billID = billID;
        this.datetime = datetime;
        this.status = status;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public BillDTO() {
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public BillDTO(int userID, String datetime) {
        this.userID = userID;
        this.datetime = datetime;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}
