package Sesion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cuack
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        HttpSession sesion= request.getSession();
        Cookie cookie[]= request.getCookies();
        Usuario user= (Usuario)sesion.getValue("usuario");
        PrintWriter out = response.getWriter();
        String idsession = cookie[0].getValue();
        String email2,email3,pass2,pass3;
        email2=user.getEmail();
        email3=request.getParameter("email");
        pass2=user.getPassword();
        pass3=request.getParameter("password");
        
        if(email2.equals(email3)&& pass2.equals(pass3) ){
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Bienvenido</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"main.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <form action='Expirar' method='post'><input  type='submit' value='Expirar Cookie'></form>\n" +
"        <h1>Bienvenido</h1>\n" +
"    </body>\n" +
"</html>\n" +
"");
        }else{
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Iniciar Sesión</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"main.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <div>\n" +
             "<h2>Datos Incorrectos</h2>"+
            "<form action='Login' method='post'>\n" +
"                 <label>Email:</label><input type=\"email\" name=\"email\"/><br>\n" +
"                 <label>Contraseña:</label><input type=\"password\" name=\"password\"/><br>\n" +
"                 <input type=\"submit\" value=\"Enviar\"/>  \n" +
"            </form>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
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
