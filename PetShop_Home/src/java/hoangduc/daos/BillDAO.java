/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.daos;

import hoangduc.connection.MyConnection;
import hoangduc.dtos.BillDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BillDAO implements Serializable{
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
        if(rs!=null)
        {
            rs.close();
        }
    }
    
    public boolean insertBill(BillDTO dto) throws Exception
    {
        boolean check = false;
        try{
            String sql = "Insert INTO Bill(BillDate,BillStatus,UserID) VALUES(?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getDatetime());
            preStm.setString(2, dto.getStatus());
            preStm.setInt(3, dto.getUserID());
            check = preStm.executeUpdate()>0;
        }finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean updatetBillStatus(BillDTO dto) throws Exception
    {
        boolean check = false;
        try{
            String sql = "Update Bill SET BillStatus = ? Where BillID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getStatus());
            preStm.setInt(2, dto.getBillID());
            check = preStm.executeUpdate()>0;
        }finally
        {
            closeConnection();
        }
        return check;
    }
    
    public int findNewBill(int search) throws Exception
    {
        int BillID = 0;
        try {
            String sql = "Select BillID From Bill Where UserID = ? AND BillStatus = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, search);
            preStm.setString(2, "0");
            rs = preStm.executeQuery();
            if(rs.next())
            {
                BillID = rs.getInt("BillID");
            }
        } finally
        {
            closeConnection();
        }
        return BillID;
    }
    
    public List<BillDTO> findByUserBill(String search) throws Exception
    {
        List<BillDTO> result = null;
        try{
            String sql = "Select BillID,BillDate,BillStatus,EndUser.UserName,Bill.UserID From Bill,EndUser Where Bill.UserID = EndUser.UserID AND EndUser.UserName LIKE ? AND BillStatus='1'";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+search+"%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                int userID = rs.getInt("UserID");
                int billID = rs.getInt("BillID");
                Date Date = rs.getDate("BillDate");
                Time Time = rs.getTime("BillDate");
                String billStatus = rs.getString("BillStatus");
                String userName = rs.getString("UserName");
                String dateB = Date.toString();
                String timeB = Time.toString();
                String billDate = dateB+" "+timeB;
                BillDTO dto = new BillDTO(billID, billDate, billStatus, userName);
                dto.setUserID(userID);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public List<BillDTO> findByUserOnLyBill(int search) throws Exception
    {
        List<BillDTO> result = null;
        try{
            String sql = "Select BillID,BillDate,BillStatus From Bill Where UserID = ? AND BillStatus='1'";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, search);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                int billID = rs.getInt("BillID");
                Date Date = rs.getDate("BillDate");
                Time Time = rs.getTime("BillDate");
                String billStatus = rs.getString("BillStatus");
                String dateB = Date.toString();
                String timeB = Time.toString();
                String billDate = dateB+" "+timeB;
                BillDTO dto = new BillDTO();
                dto.setBillID(billID);
                dto.setDatetime(billDate);
                dto.setStatus(billStatus);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public List<BillDTO> viewBill(BillDTO dto) throws Exception
    {
        List<BillDTO> result = null;
        try{
            String sql = "Select BillDate,BillItems.Price,BillItems.Quantity,Product.ProductName,Product.ProductImage From Bill,BillItems,Product,EndUser Where Bill.BillID = BillItems.BillID AND Product.ProductID = BillItems.ProductID AND Bill.UserID = EndUser.UserID AND Bill.UserID = ? AND Bill.BillID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getUserID());
            preStm.setInt(2, dto.getBillID());
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                Date Date = rs.getDate("BillDate");
                Time Time = rs.getTime("BillDate");
                float productPrice = rs.getFloat("Price");
                int quantity = rs.getInt("Quantity");
                String productName = rs.getString("ProductName");
                String productImage = rs.getString("ProductImage");
                String dateB = Date.toString();
                String timeB = Time.toString();
                String billDate = dateB+" "+timeB;
                dto = new BillDTO(quantity, billDate, productName, productImage, productPrice);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
}
