/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/RegistroTipo"})
public class RegistroTipo extends HttpServlet {

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
        PrintWriter out= response.getWriter();
            String email,password,user,fecha,tipo;
            email=request.getParameter("email");
            password=request.getParameter("password");
            user=request.getParameter("user");
            fecha= request.getParameter("fecha");
            tipo=request.getParameter("tipo");
                
            FabricaUsuarios fab=FabricaUsuarios.getInstance();
            Usuario usuario=fab.getUsuario(user,password,email,fecha,tipo);
            switch(tipo){
                case "admin":
                    out.println("<html>\n" +
                        "    <head>\n" +
                        "        <title>Menu</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        \n" +
                        "        <div>\n" +
                        "            <h2>Registro Administrador</h2>\n" +
                        "            <form action='LoginAdmin' method='post'>\n" +
                        "                <label>Usuario</label><input type='text' name=\"user\">\n<label>Numero de Empleado</label><input type='text' name=\"nEmpleado\">\n" +
                        "                <input type=\"submit\" value=\"Enviar\">\n" +
                        "            </form>\n" +
                        "            \n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>");
                    break;
                    
                case "normal":
                    out.println("<html>\n" +
                        "    <head>\n" +
                        "        <title>Menu</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        \n" +
                        "        <div>\n" +
                        "            <h2>Registro Usuario Normal</h2>\n" +
                        "            <form action='LoginNormal' method='post' id=\"registroTipo\">\n" +
                        "                <label>Usuario</label><input type='text' name=\"user\">\n<label>Nombre:</label><input type='text'name=\"nombre\" >\n" +
                        "                <select name=\"subscripcion\" form=\"registroTipo\">\n" +
                        "                    <option>Mensual</option>\n" +
                        "                    <option>Semestral</option>\n" +
                        "                    <option>Anual</option>\n" +
                        "                </select>\n" +
                        "                <label>Domicilio:</label><input type='text'name=\"domicilio\" >\n" +
                        "                <input type=\"submit\" value=\"Enviar\">\n" +
                        "            </form>\n" +
                        "            \n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>");
                    break;
                
                case "invitado":
                    out.println("<html>\n" +
                        "    <head>\n" +
                        "        <title>Menu</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        \n" +
                        "        <div>\n" +
                        "            <h2>Registro Invitado</h2>\n" +
                        "            <form action='LoginInvitado' method='post' id=\"registroTipo\">\n" +
                        "                <label>Usuario</label><input type='text' name=\"user\"><br><label>Nombre:</label><input type='text'name=\"nombre\" >\n" +
                        "                <input type=\"submit\" value=\"Enviar\">\n" +
                        "            </form>\n" +
                        "            \n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>");
                    break;
            }
                
                
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
    
