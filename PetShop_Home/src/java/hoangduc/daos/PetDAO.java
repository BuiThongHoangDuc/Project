/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.daos;

import hoangduc.connection.MyConnection;
import hoangduc.dtos.PetDTO;
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
public class PetDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public void closeConnection() throws Exception
    {
        if(rs!=null)
        {
            rs.close();
        }
        if(preStm!=null)
        {
            preStm.close();
        }
        if(conn!=null)
        {
            conn.close();
        }
    }
    
    public List<PetDTO> findPetByID(int id) throws Exception
    {
        List<PetDTO> result = null;
        try{
            String sql = "Select PetID,PetName,PetType From Pet,EndUser Where Pet.UserID = EndUser.UserID And EndUser.UserID = ? And PetStatus = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                int petid = Integer.parseInt(rs.getString("PetID"));
                String petname = rs.getString("PetName");
                String pettype = rs.getString("PetType");
                PetDTO dto = new PetDTO(petname, pettype);
                dto.setPetid(petid);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public List<PetDTO> findPetByIDAndName(int id,String name) throws Exception
    {
        List<PetDTO> result = null;
        try{
            String sql = "Select PetID,PetName,PetType From Pet,EndUser Where  Pet.UserID = EndUser.UserID And EndUser.UserID = ? And PetStatus = ? AND PetName LIKE ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            preStm.setBoolean(2, false);
            preStm.setString(3, "%"+name+"%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                int petid = Integer.parseInt(rs.getString("PetID"));
                String petname = rs.getString("PetName");
                String pettype = rs.getString("PetType");
                PetDTO dto = new PetDTO(petname, pettype);
                dto.setPetid(petid);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public PetDTO findPetByIDPet(int id) throws Exception
    {
        PetDTO dto = null;
        try{
            String sql = "Select PetName,PetType From Pet Where PetID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();

            while(rs.next())
            {
                String petname = rs.getString("PetName");
                String pettype = rs.getString("PetType");
                dto = new PetDTO(petname, pettype);
                dto.setPetid(id);
            }
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public boolean Insert(PetDTO dto)throws Exception
    {
        boolean check = false;
        try{
            String sql = "Insert INTO Pet(PetName,PetStatus,PetType,UserID) VALUES(?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPetname());
            preStm.setBoolean(2, dto.isStatus());
            preStm.setString(3, dto.getType());
            preStm.setInt(4, dto.getUserid());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean Delete(String id) throws Exception
    {
        boolean check = false;
        try{
            String sql ="Update Pet SET PetStatus = ? Where PetID =?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "1");
            preStm.setString(2, id);
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean Update(PetDTO dto) throws Exception
    {
        boolean check = false;
        try{
            String sql ="Update Pet SET PetName = ?, PetType = ? Where PetID =?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPetname());
            preStm.setString(2, dto.getType());
            preStm.setInt(3, dto.getPetid());
            check = preStm.executeUpdate()>0;
        }finally{
            closeConnection();
        }
        return check;
    }
}
