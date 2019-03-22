/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cuack
 */
@WebServlet(urlPatterns = {"/registro"})
public class registro extends HttpServlet {

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
            User user=new User(request.getParameter("email"),request.getParameter("nombre")
                    ,request.getParameter("fecha"),request.getParameter("password"));
            sesion.setAttribute("user",user);
            
            Cookie cookie=new Cookie("id",sesion.getId());
            response.addCookie(cookie);
            
            PrintWriter out= response.getWriter();
            out.println("<!DOCTYPE html>\n" +
            "\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <title>Practicas 5 y 6 LDOO</title>\n" +
            "        <meta charset=\"UTF-8\">\n" +
            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <h1>Registrado</h1>\n" +
            "        \n" +
            "        <div>\n" +
            "            <h2>Registro de usuario</h2>\n" +
            "            <a href=\"login\">Ir a login</a>\n" +
            "        </div>\n" +
            "    </body>\n" +
            "</html>");
                   
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
