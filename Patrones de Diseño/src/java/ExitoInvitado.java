/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cuack
 */
@WebServlet(urlPatterns = {"/ExitoInvitado"})
public class ExitoInvitado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        try {
            String userV,passwordV,validar,clave;
            validar="";
            userV=request.getParameter("user");
            passwordV=request.getParameter("password");
            Invitado invitado= new Invitado(userV,passwordV);
            clave=invitado.validarUsuario();
            PrintWriter out= response.getWriter();
            
            if(clave.equals(passwordV)){
                out.println("<!DOCTYPE html>\n" +
                "<!--\n" +
                "To change this license header, choose License Headers in Project Properties.\n" +
                "To change this template file, choose Tools | Templates\n" +
                "and open the template in the editor.\n" +
                "-->\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Bienvenido</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        \n" +
                "        <div>\n" +
                "            <h1>Bienvenido Invitado</h1>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>\n" +
                "");
            }else{
                out.println("<html>\n" +
                    "    <head>\n" +
                    "        <title>Log In</title>\n" +
                    "        <meta charset=\"UTF-8\">\n" +
                    "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        <p>Error Inicio de Sesion</p><br><h1>Inicio de Sesion</h1>\n" +
                    "        \n" +
                    "        <div>\n" +
                    "            <form action=\"ExitoInvitado\" method=\"post\">\n" +
                    "                <label>Usuario:</label><input type=\"text\" name=\"user\"/><br>\n" +
                    "                <label>Contraseña:</label><input type=\"password\" name=\"password\"/><br>\n" +
                    "                <input type=\"submit\" value=\"Enviar\"/ name=\"Enviar\"/>  \n" +
                    "            </form>\n" +
                    "        </div>\n" +
                    "    </body>\n" +
                    "</html>\n" +
                    ""); 
            }      
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExitoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


