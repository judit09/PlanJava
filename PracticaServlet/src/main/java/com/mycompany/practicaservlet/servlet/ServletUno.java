/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jmartinezlo
 */
public class ServletUno extends HttpServlet {

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
        String page = request.getParameter("page");
        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = getServletContext();
        RequestDispatcher rd = null;
        PrintWriter out = null;
        switch (page) {
            case "uno":
                rd = sc.getRequestDispatcher("/uno.html");
                rd.forward(request, response);
                break;
            case "dos":
                rd = sc.getRequestDispatcher("/dos.html");
                rd.forward(request, response);
                break;
            case "error":
                 out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Pàgina no trobada</title>");
                out.println("</head>");
                out.println("<body>");
                String str = null;
                out.println(str.charAt(0));
                out.println("<a href=\"index.html\">Retorna</a>");
                out.println("</body>");
                out.println("</html>");
                out.close();
                break;
            default:
                 out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Pàgina no trobada</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("La pàgina "+page+" no s'ha trobat.<br><br>");
                out.println("<a href=\"index.html\">Retorna</a>");
                out.println("</body>");
                out.println("</html>");
                out.close();
                break;

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
