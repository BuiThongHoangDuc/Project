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
public class ProductDTO implements Serializable{
    private int productid,productquantity,type;
    private String productname, productdetail, productimage,typename;
    private float productprice;
    private boolean productstatus,productisdelete;

    public ProductDTO() {
    }

    public ProductDTO(int productid, int productquantity, String productname, String productimage, float productprice) {
        this.productid = productid;
        this.productquantity = productquantity;
        this.productname = productname;
        this.productimage = productimage;
        this.productprice = productprice;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public ProductDTO(int productquantity, String productname, String productdetail, String productimage, String typename, float productprice, boolean productstatus) {
        this.productquantity = productquantity;
        this.productname = productname;
        this.productdetail = productdetail;
        this.productimage = productimage;
        this.typename = typename;
        this.productprice = productprice;
        this.productstatus = productstatus;
    }

    public ProductDTO(int productid, int productquantity, String productname, String productdetail, String productimage, String typename, float productprice, boolean productstatus) {
        this.productid = productid;
        this.productquantity = productquantity;
        this.productname = productname;
        this.productdetail = productdetail;
        this.productimage = productimage;
        this.typename = typename;
        this.productprice = productprice;
        this.productstatus = productstatus;
    }



    public ProductDTO(int productid, int productquantity, String productname, String productdetail, String productimage, float productprice) {
        this.productid = productid;
        this.productquantity = productquantity;
        this.productname = productname;
        this.productdetail = productdetail;
        this.productimage = productimage;
        this.productprice = productprice;
    }

    public ProductDTO(int productquantity, int type, String productname, String productdetail, String productimage, float productprice, boolean productstatus) {
        this.productquantity = productquantity;
        this.type = type;
        this.productname = productname;
        this.productdetail = productdetail;
        this.productimage = productimage;
        this.productprice = productprice;
        this.productstatus = productstatus;
    }

    public boolean isProductisdelete() {
        return productisdelete;
    }

    public void setProductisdelete(boolean productisdelete) {
        this.productisdelete = productisdelete;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(String productdetail) {
        this.productdetail = productdetail;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public float getProductprice() {
        return productprice;
    }

    public void setProductprice(float productprice) {
        this.productprice = productprice;
    }

    public boolean isProductstatus() {
        return productstatus;
    }

    public void setProductstatus(boolean productstatus) {
        this.productstatus = productstatus;
    }
    
    
    
}
