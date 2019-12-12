/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.daos;

import hoangduc.connection.MyConnection;
import hoangduc.dtos.ProductDTO;
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
public class ProductDAO implements Serializable {

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

    public boolean productInsert(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert INTO Product(ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity,ProductStatus,ProductIsDelete,TypeID) VALUES(?,?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getProductname());
            preStm.setString(2, dto.getProductdetail());
            preStm.setString(3, dto.getProductimage());
            preStm.setFloat(4, dto.getProductprice());
            preStm.setInt(5, dto.getProductquantity());
            if (dto.getProductquantity() > 0) {
                preStm.setBoolean(6, dto.isProductstatus());
            } else {
                preStm.setBoolean(6, false);
            }
            preStm.setBoolean(7, dto.isProductisdelete());
            preStm.setInt(8, dto.getType());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean productDelete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Product SET ProductIsDelete = ? Where ProductID = ?";
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

    public List<ProductDTO> findByLikeName(String search) throws Exception {
        List<ProductDTO> result = null;
        String name, detail, image, typename;
        float price = 0;
        int quantity = 0, id = 0;
        boolean status;
        try {
            String sql = "Select ProductID,ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity,ProductStatus,TypeOfProduct.TypeName From Product,TypeOfProduct Where TypeOfProduct.TypeID = Product.TypeID AND ProductName LIKE ? AND ProductIsDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ProductID");
                name = rs.getString("ProductName");
                detail = rs.getString("ProductDetail");
                image = rs.getString("ProductImage");
                price = rs.getFloat("ProductPrice");
                quantity = rs.getInt("ProductQuantity");
                status = rs.getBoolean("ProductStatus");
                typename = rs.getString("TypeName");
                ProductDTO dto = new ProductDTO(id, quantity, name, detail, image, typename, price, status);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> showAllProduct(String search) throws Exception {
        List<ProductDTO> result = null;
        String name, detail, image;
        float price = 0;
        int quantity = 0, id = 0;
        try {
            String sql = "Select ProductID,ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity From Product Where ProductStatus = ? AND ProductIsDelete = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            preStm.setBoolean(2, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ProductID");
                name = rs.getString("ProductName");
                detail = rs.getString("ProductDetail");
                image = rs.getString("ProductImage");
                price = rs.getFloat("ProductPrice");
                quantity = rs.getInt("ProductQuantity");
                ProductDTO dto = new ProductDTO(id, quantity, name, detail, image, price);
                result.add(dto);

            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<ProductDTO> findProduct(String search) throws Exception {
        List<ProductDTO> result = null;
        String name, detail, image;
        float price = 0;
        int quantity = 0, id = 0;
        try {
            String sql = "Select ProductID,ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity From Product Where ProductName LIKE ? AND ProductStatus = ? AND ProductIsDelete = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+search+"%");
            preStm.setBoolean(2, true);
            preStm.setBoolean(3, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ProductID");
                name = rs.getString("ProductName");
                detail = rs.getString("ProductDetail");
                image = rs.getString("ProductImage");
                price = rs.getFloat("ProductPrice");
                quantity = rs.getInt("ProductQuantity");
                ProductDTO dto = new ProductDTO(id, quantity, name, detail, image, price);
                result.add(dto);

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> showDogProduct(String search) throws Exception {
        List<ProductDTO> result = null;
        String name, detail, image;
        float price = 0;
        int quantity = 0, id = 0;
        try {
            String sql = "Select ProductID,ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity From Product Where TypeID = ? AND ProductStatus = ? AND ProductIsDelete = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, 1);
            preStm.setBoolean(2, true);
            preStm.setBoolean(3, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ProductID");
                name = rs.getString("ProductName");
                detail = rs.getString("ProductDetail");
                image = rs.getString("ProductImage");
                price = rs.getFloat("ProductPrice");
                quantity = rs.getInt("ProductQuantity");
                ProductDTO dto = new ProductDTO(id, quantity, name, detail, image, price);
                result.add(dto);

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> showCatProduct(String search) throws Exception {
        List<ProductDTO> result = null;
        String name, detail, image;
        float price = 0;
        int quantity = 0, id = 0;
        try {
            String sql = "Select ProductID,ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity From Product Where TypeID = ? AND ProductStatus = ? AND ProductIsDelete = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, 2);
            preStm.setBoolean(2, true);
            preStm.setBoolean(3, false);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("ProductID");
                name = rs.getString("ProductName");
                detail = rs.getString("ProductDetail");
                image = rs.getString("ProductImage");
                price = rs.getFloat("ProductPrice");
                quantity = rs.getInt("ProductQuantity");
                ProductDTO dto = new ProductDTO(id, quantity, name, detail, image, price);
                result.add(dto);

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public ProductDTO findByPrimaryKey(int id) throws Exception {
        ProductDTO dto = null;
        String name, detail, image;
        float price = 0;
        int quantity = 0, type = 0;
        boolean status = false;
        try {
            String sql = "Select ProductName,ProductDetail,ProductImage,ProductPrice,ProductQuantity,TypeID,ProductStatus From Product Where ProductID = ? AND ProductIsDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("ProductName");
                detail = rs.getString("ProductDetail");
                image = rs.getString("ProductImage");
                price = rs.getFloat("ProductPrice");
                quantity = rs.getInt("ProductQuantity");
                type = rs.getInt("TypeID");
                status = rs.getBoolean("ProductStatus");
                dto = new ProductDTO(quantity, type, name, detail, image, price, status);
                dto.setProductid(id);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public int findByPrimaryKeyQuantity(int id) throws Exception {
        int quantity = 0;
        boolean status = false;
        try {
            String sql = "Select ProductQuantity From Product Where ProductID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("ProductQuantity");
            }
        } finally {
            closeConnection();
        }
        return quantity;
    }

    public boolean Edit(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Product SET ProductName = ?, ProductDetail = ?, ProductImage = ?, ProductPrice = ?, ProductQuantity = ?, TypeID = ?, ProductStatus = ? Where ProductID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getProductname());
            preStm.setString(2, dto.getProductdetail());
            preStm.setString(3, dto.getProductimage());
            preStm.setFloat(4, dto.getProductprice());
            preStm.setInt(5, dto.getProductquantity());
            preStm.setInt(6, dto.getType());
            preStm.setBoolean(7, dto.isProductstatus());
            preStm.setInt(8, dto.getProductid());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean UpdateQuantity(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Product SET ProductQuantity = ?, ProductStatus = ? Where ProductID = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getProductquantity());
            preStm.setBoolean(2, dto.isProductstatus());
            preStm.setInt(3, dto.getProductid());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
