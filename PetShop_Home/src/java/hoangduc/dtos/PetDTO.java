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
public class PetDTO implements Serializable{
    private String petname,type;
    private int petid,userid;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public PetDTO() {
    }

    public PetDTO(String petname, String type) {
        this.petname = petname;
        this.type = type;
    }

    public PetDTO(String petname, String type, int petid, int userid) {
        this.petname = petname;
        this.type = type;
        this.petid = petid;
        this.userid = userid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
}
