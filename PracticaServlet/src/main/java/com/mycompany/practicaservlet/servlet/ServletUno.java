/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservlet.servlet;

import com.mycompany.persistencia.dao.PersonaDao;
import com.mycompany.persistencia.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
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

    @EJB
    private PersonaDao dao;
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
            case "formulari":
                rd = sc.getRequestDispatcher("/formulari.html");
                rd.forward(request, response);
                break;
            case "llista":
                out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Lista personas</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Lista personas</h1>");
                List<Persona> personas = dao.todas();
                for (Persona persona : personas) {
                    out.println("ID: "+persona.getId()+" Nom: "+persona.getNombre()+"<br>");
                }
                out.println("<br><br>");
                out.println("<a href=\"index.html\">Torna</a>");
                out.println("</body>");
                out.println("</html>");
                out.close();
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
                out.println("La pàgina " + page + " no s'ha trobat.<br><br>");
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
