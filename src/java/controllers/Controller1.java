/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.ProductCRUD;

/**
 *
 * @author NIYIRETH_OSORIO
 */
@WebServlet(name = "Controller1", urlPatterns = {"/Controller1"})
public class Controller1 extends HttpServlet {

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
        String operation = request.getParameter("operation");
        
        if ("productRegister".equals(operation)) {
            String productCode = request.getParameter("productCode");
            String productName = request.getParameter("productName");
            int productPrice = Integer.parseInt(request.getParameter("productPrice"));
            int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
            ProductCRUD crud = new ProductCRUD();
            boolean message = crud.productRegister(productCode, productName, productPrice, productQuantity);
            Gson json = new Gson();
            String result = json.toJson(message);
            response.setContentType("application/json");
            response.getWriter().write(result);
        }
        else if ("productShow".equals(operation)) {
            System.out.println("Hola bus");
            ProductCRUD crud = new ProductCRUD();
            ArrayList<Product> products = crud.productShow();
            Gson json = new Gson();
            String resultado = json.toJson(products);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
//        else if("busPassword".equals(operation))
//        {
//            int idbus=Integer.parseInt(request.getParameter("idbus"));
//            ProductCRUD crud = new ProductCRUD();
//            String password=crud.busPassword(idbus);
//            Gson json = new Gson();
//            String resultado = json.toJson(password);
//            response.setContentType("application/json");
//            response.getWriter().write(resultado);
//        }
//        else if("busUpdate".equals(operation))
//        {
//            int idbus= Integer.parseInt(request.getParameter("idbus"));
//            String password = request.getParameter("password");
//            String passwordRepeat = request.getParameter("passwordRepeat");
//            String driverName = request.getParameter("driverName");
//            String busType = request.getParameter("busType");
//            int ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
//            ProductCRUD crud = new ProductCRUD();
//            boolean message= crud.busUpdate(idbus,password,passwordRepeat,driverName,busType, ticketPrice);
//            Gson json = new Gson();
//            String result = json.toJson(message);
//            response.setContentType("application/json");
//            response.getWriter().write(result);
//        }
//        
//        else if("busDelete".equals(operation))
//        {
//            int idbus=Integer.parseInt(request.getParameter("idbus"));
//            ProductCRUD crud = new ProductCRUD();
//            boolean message=crud.busDelete(idbus);
//            Gson json = new Gson();
//            String resultado = json.toJson(message);
//            response.setContentType("application/json");
//            response.getWriter().write(resultado);
//        }
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
