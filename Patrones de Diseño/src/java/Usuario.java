
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuack
 */
public interface Usuario {    
    public static final String url="jdbc:mysql://localhost:3306/patterns";
    public static final String usuario="root";
    public static final String contraseña="";
    public static final String clase="com.mysql.jdbc.Driver";
    void registrarUsuario();
    String validarUsuario()throws ClassNotFoundException, SQLException;
}
