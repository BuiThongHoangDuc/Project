/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.controller;

import hoangduc.daos.EnduserDAO;
import hoangduc.dtos.EnduserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class SignupController extends HttpServlet {

    private static final String SUCCESS = "login.jsp";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "signup.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            
            String username = request.getParameter("username");
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
            String adress = request.getParameter("adress");
            String phonenumber = request.getParameter("phonenumber");
            String pass = request.getParameter("pass");
            
            EnduserDAO dao = new EnduserDAO();
            EnduserDTO dto =  new EnduserDTO(username, fullname, pass, email, adress, phonenumber);
            
            if(dao.userInsert(dto))
            {
                url = SUCCESS;
            }
            else
            {
                request.setAttribute("ERROR", "Regist failed");
            }
        } catch (Exception e) {
            log("ERROR at SignupController: "+e.getMessage());
            if(e.getMessage().contains("duplicate"))
            {
                url = INVALID;
                request.setAttribute("INVALID", "UserName Is Already Inside");
            }
        }
        finally
        {
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
