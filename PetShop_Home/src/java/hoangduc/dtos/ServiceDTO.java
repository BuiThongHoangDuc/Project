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
public class ServiceDTO implements Serializable{
    private int serviceid;
    private String servicename, serviceimage,typeofpet;
    private float price;
    private boolean status;

    public ServiceDTO() {
    }

    public ServiceDTO(String servicename, String serviceimage, String typeofpet, float price, boolean status) {
        this.servicename = servicename;
        this.serviceimage = serviceimage;
        this.typeofpet = typeofpet;
        this.price = price;
        this.status = status;
    }

    public ServiceDTO(String servicename, String serviceimage, String typeofpet) {
        this.servicename = servicename;
        this.serviceimage = serviceimage;
        this.typeofpet = typeofpet;
    }
    
    
    
    public ServiceDTO(int serviceid, String servicename, String serviceimage, String typeofpet, boolean status) {
        this.serviceid = serviceid;
        this.servicename = servicename;
        this.serviceimage = serviceimage;
        this.typeofpet = typeofpet;
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServiceimage() {
        return serviceimage;
    }

    public void setServiceimage(String serviceimage) {
        this.serviceimage = serviceimage;
    }

    public String getTypeofpet() {
        return typeofpet;
    }

    public void setTypeofpet(String typeofpet) {
        this.typeofpet = typeofpet;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
