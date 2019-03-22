


import java.io.IOException;
/*import java.io.PrintWriter;*/
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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(action.equals("/out")){
            sesion.invalidate();
            response.sendRedirect("/index.html");
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession sesion= request.getSession();
            String email,pass;
            email= request.getParameter("email");
            pass= request.getParameter("password");
            
            if((pass.equals("admin"))&&(email.equals("admin@admin.com"))&&(sesion.getAttribute("correo")==null)){
            sesion.setAttribute("correo",email);
            response.sendRedirect("loginExito.jsp");
            
            }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
