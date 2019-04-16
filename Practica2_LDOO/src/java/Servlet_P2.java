/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cuack
 */
@WebServlet(name = "Servlet_P2", urlPatterns = {"/Servlet_P2"})
public class Servlet_P2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    // <editor-fold defaultstate="collapsed" desdc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter sal=response.getWriter();
            sal.println("<!DOCTYPE html>");
            sal.println("<html>");
            sal.println("<head>");
            sal.println("<title>Datos Introducidos</title>\n" +
"        <link rel=\"stylesheet\" href=\"main.css\">");            
            sal.println("</head>");
            sal.println("<body>");
            sal.println("<div>Email: " + request.getParameter("email") + "<br/>");
            sal.println("Contraseña: " + request.getParameter("password") + "<br/>");
            sal.println("Nombre: " + request.getParameter("nombre") + "<br/>");
            sal.println("Fecha de Nacimiento: " + request.getParameter("fecha") + "<br/>");
            sal.println("</div></body>");
            sal.println("</html>");

    }

   


}
