/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.controller;

import hoangduc.daos.BillDAO;
import hoangduc.daos.BillItemsDAO;
import hoangduc.daos.ProductDAO;
import hoangduc.dtos.BillDTO;
import hoangduc.dtos.BillItemsDTO;
import hoangduc.dtos.ProductDTO;
import hoangduc.dtos.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class CheckOutController extends HttpServlet {

    private static final String INVALID = "cart.jsp";
    private static final String SUCCESS = "/ShowProductController";
    private static final String ERROR = "error.jsp";
    private static final String NOTYET = "/login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("USERID") == null) {
                url = NOTYET;
            } else {
                ShoppingCart shopcart = (ShoppingCart) session.getAttribute("cart");
                if (shopcart == null) {
                    url = INVALID;
                } else {
                    //check is have enough quantity
                    ProductDAO dao = new ProductDAO();
                    for (ProductDTO dto : shopcart.getCart().values()) {
                        int productID = dto.getProductid();
                        int quantityOfProduct = dao.findByPrimaryKeyQuantity(productID);
                        int quantityOfCart = dto.getProductquantity();
                        if (quantityOfCart > quantityOfProduct) {
                            url = INVALID;
                            request.setAttribute("INVALID", "Our Product Don't Have Enough");
                            return;
                        } else {
                            url = "success";
                        }
                    }

                    if (url.equals("success")) {
                        url = SUCCESS;
                        //create a Bill
                        int userid = (int) session.getAttribute("USERID");
                        Date date = new Date();
                        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        String dateString = df.format(date);
                        BillDTO dtoBill = new BillDTO(userid, dateString);
                        dtoBill.setStatus("0");
                        BillDAO daoBill = new BillDAO();
                        daoBill.insertBill(dtoBill);

                        //find Bill just create
                        int BillID = daoBill.findNewBill(userid);

                        //Insert items into BillItems By BillID
                        for (ProductDTO dto : shopcart.getCart().values()) {
                            int productID = dto.getProductid();
                            int quantityOfProduct = dao.findByPrimaryKeyQuantity(productID);
                            int quantityOfCart = dto.getProductquantity();
                            float priceOfCart = dto.getProductprice() * dto.getProductquantity();
                            BillItemsDTO dtoBillItems = new BillItemsDTO(quantityOfCart, BillID, productID, priceOfCart);
                            BillItemsDAO daoBillItems = new BillItemsDAO();
                            daoBillItems.insertBillItem(dtoBillItems);

                            //ReQuantity of Product
                            int newQuantity = quantityOfProduct - quantityOfCart;
                            ProductDTO dtoProduct = new ProductDTO();
                            dtoProduct.setProductid(productID);
                            dtoProduct.setProductquantity(newQuantity);
                            if (newQuantity == 0) {
                                dtoProduct.setProductstatus(false);
                            } else {
                                dtoProduct.setProductstatus(true);
                            }
                            ProductDAO daoPrudct = new ProductDAO();
                            dao.UpdateQuantity(dtoProduct);

                            //update bill status into process
                            dtoBill = new BillDTO();
                            dtoBill.setStatus("1");
                            dtoBill.setBillID(BillID);
                            daoBill.updatetBillStatus(dtoBill);
                        }
                        session.removeAttribute("cart");
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR at CheckOutController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
