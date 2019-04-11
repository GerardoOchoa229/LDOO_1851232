package BaseDatos;

import com.mysql.jdbc.Connection;
import java.sql.*;

public class Conector {
    public static String url="jdbc:mysql://localhost:3306/login";
    public static String usuario="root";
    public static String contraseña="";
    public static String clase="com.mysql.jdbc.Driver";
    public static String email,password,name,fecha;
    
    
    Conector(String email, String password) throws ClassNotFoundException, SQLException{
        setEmail(email);
        setPassword(password);
        
    }
    Conector(String email,String password,String name, String fecha) throws SQLException, ClassNotFoundException {
        setEmail(email);
        setPassword(password);
        setName(name);
        setFecha(fecha);
        
    }

    public static void setEmail(String email) {
        Conector.email = email;
    }

    public static void setPassword(String password) {
        Conector.password = password;
    }

    public static void setName(String name) {
        Conector.name = name;
    }

    public static void setFecha(String fecha) {
        Conector.fecha = fecha;
    }

    


    public void registrar() throws SQLException, ClassNotFoundException{
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            Statement sentencia=conexion.createStatement();
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO usuarios VALUES('" + email + "','"+password+"','"+ name + "','"+ fecha+"')");
            ps.executeUpdate();
    }
    
    
    
    public String validar() throws ClassNotFoundException, SQLException{
        String salida="";
        Class.forName(clase);
        Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
        Statement sentencia=conexion.createStatement();
        ResultSet resultado= sentencia.executeQuery("SELECT * FROM usuarios WHERE email='"+email+"'");
        while(resultado.next()){
            salida=resultado.getString("password");
        }
        return salida;
    }

}
