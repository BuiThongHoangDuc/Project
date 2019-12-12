/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangduc.controller;

import hoangduc.daos.ProductDAO;
import hoangduc.dtos.ProductDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddProductController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchProductController";
    private static final String INVALID = "/admin/productform.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url =ERROR;
        try {
            String name = request.getParameter("name");
            int type = Integer.parseInt(request.getParameter("type"));
            String detail = request.getParameter("detail");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float price = Float.parseFloat(request.getParameter("price"));
            String image = uploadfile(request);
            if(image.equals(""))
            {
                Part filePart = request.getPart("image");
                image = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            }
            ProductDTO dto = new ProductDTO(quantity, type, name, detail, image, price, true);
            dto.setProductisdelete(false);
            
            ProductDAO dao = new ProductDAO();
            if(dao.productInsert(dto))
            {
                url = SUCCESS;
            }
            else
            {
                request.setAttribute("ERROR", "Insert Failed");
            }
        } catch (Exception e) {
            log("ERROR at AddProductController: "+e.getMessage());
            if(e.getMessage().contains("duplicate"))
            {
                url = INVALID;
                request.setAttribute("INVALID", "Product Is Already Inside");
            }
        }
        finally
        {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    private String uploadfile(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String applicationPath = "D:\\Java\\PetShop_Home\\web\\images\\home";
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
        } catch (Exception e) {
            fileName = "";
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
