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
public class EnduserDTO implements Serializable{
    private String username,fullname,userpassword,useremail,useradress,userphonenum,userrole,userstatus;
    private int userid;

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public EnduserDTO() {
    }

    public EnduserDTO(String username, String fullname, String userpassword, String useremail, String useradress, String userphonenum) {
        this.username = username;
        this.fullname = fullname;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.useradress = useradress;
        this.userphonenum = userphonenum;
    }

    public EnduserDTO(String username, String userpassword, String userrole) {
        this.username = username;
        this.userpassword = userpassword;
        this.userrole = userrole;
    }

    public EnduserDTO(String username,String fullname, String useremail, String useradress, String userphonenum) {
        this.username = username;
        this.fullname = fullname;
        this.useremail = useremail;
        this.useradress = useradress;
        this.userphonenum = userphonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUseradress() {
        return useradress;
    }

    public void setUseradress(String useradress) {
        this.useradress = useradress;
    }

    public String getUserphonenum() {
        return userphonenum;
    }

    public void setUserphonenum(String userphonenum) {
        this.userphonenum = userphonenum;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
    
    
}
