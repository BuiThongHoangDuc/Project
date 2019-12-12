/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.daos;

import hoangduc.connection.MyConnection;
import hoangduc.dtos.EnduserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class EnduserDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public EnduserDAO() {
    }

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public EnduserDTO checkLogin(String username, String password) throws Exception {
        String role = "failed";
        int userid = 0;
        EnduserDTO dto = null;
        try {
            String sql = "Select UserID,UserRole From EndUser Where UserName = ? AND UserPassword = ? AND UserStatus = 1";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("UserRole");
                userid = rs.getInt("UserID");
                dto = new EnduserDTO();
                dto.setUserid(userid);
                dto.setUserrole(role);
            }else
            {
                dto = new EnduserDTO();
                dto.setUserrole(role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean userInsert(EnduserDTO dto) throws Exception {
        boolean insert = true;
        try {
            String sql = "Insert into EndUser(UserName,UserFullName, UserPassword,UserEmail,UserAdress,UserPhoneNum,UserStatus,UserRole) Values(?,?,?,?,?,?,1,2)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            System.out.println();
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getUserpassword());
            preStm.setString(3, dto.getUserpassword());
            preStm.setString(4, dto.getUseremail());
            preStm.setString(5, dto.getUseradress());
            preStm.setString(6, dto.getUserphonenum());
            insert = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return insert;
    }

    public List<EnduserDTO> findByLikeName(String search) throws Exception{
        List<EnduserDTO> result = null;
        String username = null;
        String userfullname = null;
        String useremail = null;
        String useradress = null;
        String userphonenum = null;
        String userrole = null;
        try {
            String sql = "Select UserName,UserFullName, UserEmail, UserAdress, UserPhoneNum ,TypeRole.RoleName From EndUser,TypeRole Where UserFullName LIKE ? AND UserStatus = 1 AND EndUser.UserRole = TypeRole.UserRole";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+search.trim()+"%");
            rs = preStm.executeQuery();
            EnduserDTO dto;
            result = new ArrayList<>();
            while(rs.next())
            {
                username = rs.getString("UserName");
                userfullname = rs.getString("UserFullName");
                useremail = rs.getString("UserEmail");
                useradress = rs.getString("UserAdress");
                userphonenum = rs.getString("UserPhoneNum");
                userrole = rs.getString("RoleName");
                dto = new EnduserDTO(username,userfullname , useremail, useradress, userphonenum);
                dto.setUserrole(userrole);
                result.add(dto);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean Delete(String id) throws Exception
    {
        boolean check = false;
        try
        {
            String sql = "Update EndUser SET UserStatus = ? Where UserName = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "0");
            preStm.setString(2, id);
            check = preStm.executeUpdate()>0;
        }finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean UpdateUser(EnduserDTO dto) throws Exception
    {
        boolean check = false;
        try
        {
            String sql = "Update EndUser SET UserFullName = ?,UserEmail = ?,UserAdress = ?,UserPhoneNum = ?,UserRole = ? Where UserName = ? ";
            
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setString(2, dto.getUseremail());
            preStm.setString(3, dto.getUseradress());
            preStm.setString(4, dto.getUserphonenum());
            preStm.setString(5, dto.getUserrole());
            preStm.setString(6, dto.getUsername());

            check = preStm.executeUpdate()>0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public EnduserDTO findByPrimaryKey(String id) throws Exception
    {
        EnduserDTO dto =  null;
        String userfullname = null;
        String useremail = null;
        String useradress = null;
        String userphonenum = null;
        String userrole = null;
        int userid = 0;
        try {
            String sql = "Select UserID,UserFullName, UserEmail, UserAdress, UserPhoneNum, UserRole From EndUser Where UserName = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                userid = rs.getInt("UserID");
                userfullname = rs.getString("UserFullName");
                useremail = rs.getString("UserEmail");
                useradress = rs.getString("UserAdress");
                userphonenum = rs.getString("UserPhoneNum");
                userrole = rs.getString("UserRole");
                dto = new EnduserDTO(id, userfullname, useremail, useradress, userphonenum);
                dto.setUserrole(userrole);
                dto.setUserid(userid);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    
}
