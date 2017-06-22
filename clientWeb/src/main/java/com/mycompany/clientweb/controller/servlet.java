/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientweb.controller;

import com.mycompany.clientweb.controller.SOAP;
import com.mycompany.clientweb.controller.SOAP_Service;
import com.mycompany.clientweb.controller.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author jmartinezlo
 */
public class servlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceServidor/SOAP.wsdl")
    private SOAP_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceServidor/SOAP.wsdl")
    private SOAP_Service service;

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
        String accion = request.getParameter("accion");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario result = null;
        if (accion.equals("nuevo")) {
            try { // Call Web Service Operation
                SOAP port = service.getSOAPPort();
                result = port.nuevoUser(username, password);
                accion = "Nuevo usuario registrado.";
            } catch (Exception ex) {
            }
        } else {

            try {
                SOAP port = service_1.getSOAPPort();
                result = port.autentificar(username, password);
                accion = "Autentificación usuario.";
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + accion + "</h1>");
        out.println("ID: " + result.getId());
        out.println("USERNAME: " + result.getUsername());
        out.println("PASSWORD: " + result.getPassword());
        out.println("</body>");
        out.println("</html>");
        out.close();

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
