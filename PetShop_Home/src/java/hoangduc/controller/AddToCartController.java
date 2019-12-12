/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.controller;

import hoangduc.dtos.ProductDTO;
import hoangduc.dtos.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class AddToCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            ShoppingCart shopcart = (ShoppingCart)session.getAttribute("cart");
            String username = (String)session.getAttribute("USERLOGIN");
            if(shopcart == null && username == null)
            {
                shopcart = new ShoppingCart();
            }
            else if(shopcart == null && username != null)
            {
                shopcart = new ShoppingCart(username);
            }
            
            String productName = request.getParameter("productName");
            int productID = Integer.parseInt(request.getParameter("productID"));
            float productPrice = Float.parseFloat(request.getParameter("productPrice"));
            int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
            String productImage = request.getParameter("productImage");
            int quantitycart = 1;
            
            ProductDTO dto = new ProductDTO(productID, quantitycart, productName, productImage, productPrice);
            
            shopcart.addCart(dto);
            
            session.setAttribute("cart", shopcart);
        } catch (Exception e) {
            log("ERROR at AddToCartController: "+e.getMessage());
        }
        finally{
            response.sendRedirect("/PetShop/ShowProductController");
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
