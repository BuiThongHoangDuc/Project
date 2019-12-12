/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.daos;

import hoangduc.connection.MyConnection;
import hoangduc.dtos.BillItemsDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class BillItemsDAO implements Serializable {

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

    public boolean insertBillItem(BillItemsDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert INTO BillItems(Quantity,Price,BillID,ProductID) VALUES(?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getQuantity());
            preStm.setFloat(2, dto.getPrice());
            preStm.setInt(3, dto.getBillID());
            preStm.setInt(4, dto.getProductID());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
