/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SIGNUP = "SignupController";
    private static final String EDIT = "EditController";
    private static final String SEARCH = "SearchController";
    private static final String UPDATE = "UpdateController";
    private static final String DELETE = "DeleteController";
    private static final String ADDPRODUCT = "AddProductController";
    private static final String SEARCHPRODUCT = "SearchProductController";
    private static final String DELETEPRODUCT = "DeleteProductController";
    private static final String EDITPRODUCT = "EditProductController";
    private static final String UPDATEPRODUCT = "UpdateProductController";
    private static final String SEARCHPET = "SearchPetController";
    private static final String PERSONSEARCHP = "PersonSearchPetController";
    private static final String DELETEPET = "DeletePetController";
    private static final String ADDPET = "AddPetController";
    private static final String EDITPET = "EditPetController";
    private static final String UPDATEPET = "UpdatePetController";
    private static final String SERVICESEARCH = "ServiceSearchController";
    private static final String SERVICEDELETE = "ServiceDeleteController";
    private static final String SERVICEADD = "ServiceAddController";
    private static final String SERVICEEDIT = "ServiceEditController";
    private static final String SERVICEUPDATE = "ServiceUpdateController";
    private static final String ADDTOCART = "AddToCartController";
    private static final String REMOVECART = "RemoveCartController";
    private static final String UPDATECART = "UpdateCartController";
    private static final String CHECKOUT ="CheckOutController";
    private static final String SEARCHBILL ="SearchBillController";
    private static final String DELETEBILL = "DeleteBillController";
    private static final String VIEWBILL = "ViewBillController";
    private static final String USERLISTBILL = "UserListBillController";
    private static final String USERDELETEBILL = "UserDeleteBillController";
    private static final String USERVIEWBILL = "UserViewBillController";
    private static final String FINDPRODUCT = "FindProductController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            System.out.println("action "+action);
            if(action.equals("Login"))
            {
                url = LOGIN;
            }
            else if(action.equals("Search"))
            {
                url = SEARCH;
            }
            else if(action.equals("SignUp"))
            {
                url = SIGNUP;
            }
            else if(action.equals("Logout"))
            {
                url = LOGOUT;
            }
            else if(action.equals("Edit"))
            {
                url = EDIT;
            }
            else if(action.equals("Update"))
            {
                url = UPDATE;
            }
            else if(action.equals("Delete"))
            {
                url = DELETE;
            }
            else if(action.equals("Add Product"))
            {
                url = ADDPRODUCT;
            }
            else if(action.equals("ProductSearch"))
            {
                url = SEARCHPRODUCT;
            }
            else if(action.equals("ProductDelete"))
            {
                url = DELETEPRODUCT;
            }
            else if(action.equals("ProductEdit"))
            {
                url = EDITPRODUCT;
            }
            else if(action.equals("ProductUpdate"))
            {
                url = UPDATEPRODUCT;
            }
            else if(action.equals("SearchPet"))
            {
                url = SEARCHPET;
            }
            else if(action.equals("DeletePet"))
            {
                url = DELETEPET;
            }
            else if(action.equals("PPersonSearch"))
            {
                url = PERSONSEARCHP;
            }
            else if(action.equals("AddPet"))
            {
                url = ADDPET;
            }
            else if(action.equals("PetEdit"))
            {
                url = EDITPET;
            }
            else if(action.equals("UpdatePet"))
            {
                url = UPDATEPET;
            }
            else if(action.equals("ServiceSearch"))
            {
                url = SERVICESEARCH;
            }
            else if(action.equals("ServiceDelete"))
            {
                url = SERVICEDELETE;
            }
            else if(action.equals("ServiceAdd"))
            {
                url = SERVICEADD;
            }
            else if(action.equals("ServiceEdit"))
            {
                url = SERVICEEDIT;
            }
            else if(action.equals("ServiceUpdate"))
            {
                url = SERVICEUPDATE;
            }
            else if(action.equals("AddCart"))
            {
                url = ADDTOCART;
            }
            else if(action.equals("CartPDelete"))
            {
                url = REMOVECART;
            }
            else if(action.equals("UpdateQuantity"))
            {
                url = UPDATECART;
            }
            else if(action.equals("Check Out"))
            {
                url = CHECKOUT;
            }
            else if(action.equals("BillSearch"))
            {
                url = SEARCHBILL;
            }
            else if(action.equals("BillDelete"))
            {
                url = DELETEBILL;
            }
            else if(action.equals("BillView"))
            {
                url = VIEWBILL;
            }
            else if(action.equals("BillOnlyUser"))
            {
                url = USERLISTBILL;
            }
            else if(action.equals("DeleteBillUser"))
            {
                url = USERDELETEBILL;
            }
            else if(action.equals("UserBillView"))
            {
                url = USERVIEWBILL;
            }
            else if(action.equals("FindProduct"))
            {
                url = FINDPRODUCT;
            }
            else
            {
                request.setAttribute("ERROR", "Action is not supported");
            }
                    
        } catch (Exception e) {
            log("ERROR at MainController: "+e.getMessage());
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
