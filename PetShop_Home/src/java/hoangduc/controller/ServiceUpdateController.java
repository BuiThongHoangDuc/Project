/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.controller;

import hoangduc.daos.ServiceDAO;
import hoangduc.dtos.ServiceDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ADMIN
 */
public class ServiceUpdateController extends HttpServlet {

    private static final String SUCCESS = "ServiceSearchController";
    private static final String ERROR = "error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            float price = Float.parseFloat(request.getParameter("price"));
            String image = null;
            
            try {
                image = uploadfile(request);
            } catch (FileNotFoundException ex) {
                image = request.getParameter("image");
            }

            ServiceDTO dto = new ServiceDTO(name, image, type);
            dto.setPrice(price);
            dto.setServiceid(id);
            
            ServiceDAO dao = new ServiceDAO();
            if(dao.Edit(dto))
            {
                url = SUCCESS;
            }
            else
            {
                request.setAttribute("ERROR", "Update Failed");
            }
        } catch (Exception e) {
            log("ERROR at UpdateController: "+e.getMessage());
        }
        finally
        {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    
    private String uploadfile(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("imagenew");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String applicationPath = "E:\\Java Web\\PetShop\\web\\images\\home";
        String basePath = applicationPath + File.separator + File.separator;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File outputFilePath = new File(basePath + fileName);
            inputStream = filePart.getInputStream();
            outputStream = new FileOutputStream(outputFilePath);
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        return fileName;
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
