/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "Exito", urlPatterns = {"/Exito"})
public class Exito extends HttpServlet {

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
        String emailV,passwordV,clave;
        emailV=request.getParameter("email");
        passwordV=request.getParameter("password");
        try {
            Conector conecta = new Conector(emailV,passwordV);
            clave=conecta.validar();
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
                "        <title>Bienvenico</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        \n" +
                "        <div>\n" +
                "            <h1>Bienvenido</h1>\n" +
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
                    "        <p>Error Inicio de Sesion</p><h1>Inicio de Sesion</h1>\n" +
                    "        \n" +
                    "        <div>\n" +
                    "            <form action=\"Exito\" method=\"post\">\n" +
                    "                <label>Email:</label><input type=\"email\" name=\"email\"/><br>\n" +
                    "                <label>Contraseña:</label><input type=\"password\" name=\"password\"/><br>\n" +
                    "                <input type=\"submit\" value=\"Enviar\"/ name=\"Enviar\"/>  \n" +
                    "            </form>\n" +
                    "        </div>\n" +
                    "    </body>\n" +
                    "</html>\n" +
                    "");    
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Exito.class.getName()).log(Level.SEVERE, null, ex);
        }
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
