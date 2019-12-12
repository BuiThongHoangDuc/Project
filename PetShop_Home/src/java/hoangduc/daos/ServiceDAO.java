/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.daos;

import hoangduc.connection.MyConnection;
import hoangduc.dtos.ServiceDTO;
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
public class ServiceDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public List<ServiceDTO> findByLikeName(String search) throws Exception {
        List<ServiceDTO> result = null;
        int id = 0;
        String name, image, typepet;
        float price = 0;
        try {
            String sql = "Select ServiceID,ServiceName,SerivcePrice,ServiceImage,TypePetService From ServicePet Where ServiceName LIKE ? AND SerivceStatus = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("ServiceID"));
                name = rs.getString("ServiceName");
                image = rs.getString("ServiceImage");
                price = rs.getFloat("SerivcePrice");
                typepet = rs.getString("TypePetService");
                ServiceDTO dto = new ServiceDTO(name, image, typepet);
                dto.setPrice(price);
                dto.setServiceid(id);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean serviceDelete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update ServicePet SET SerivceStatus = ? Where ServiceID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "1");
            preStm.setString(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean serviceInsert(ServiceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert INTO ServicePet(ServiceName,SerivcePrice,SerivceStatus,ServiceImage,TypePetService) VALUES(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getServicename());
            preStm.setFloat(2, dto.getPrice());
            preStm.setBoolean(3, dto.isStatus());
            preStm.setString(4, dto.getServiceimage());
            preStm.setString(5, dto.getTypeofpet());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ServiceDTO findByPrimaryKey(int id) throws Exception {
        ServiceDTO dto = null;
        String name, image, type;
        float price = 0;
        try {
            String sql = "Select ServiceName,SerivcePrice,ServiceImage,TypePetService From ServicePet Where ServiceID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("ServiceName");
                image = rs.getString("ServiceImage");
                price = rs.getFloat("SerivcePrice");
                type = rs.getString("TypePetService");
                dto = new ServiceDTO(name, image, type);
                dto.setPrice(price);
                dto.setServiceid(id);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean Edit(ServiceDTO dto) throws Exception
    {
        boolean check = false;
        try {
            String sql = "Update ServicePet SET ServiceName = ?, SerivcePrice = ?, ServiceImage = ?, TypePetService = ? Where ServiceID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getServicename());
            preStm.setFloat(2, dto.getPrice());
            preStm.setString(3, dto.getServiceimage());
            preStm.setString(4, dto.getTypeofpet());
            preStm.setInt(5, dto.getServiceid());
            check = preStm.executeUpdate() > 0;
        } finally
        {
            closeConnection();
        }
        return check;
    }
    
}
