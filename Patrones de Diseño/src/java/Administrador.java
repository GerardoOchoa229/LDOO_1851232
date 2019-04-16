
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuack
 */
public final class Administrador implements Usuario {
    String user,password,email,fecha,nEmpleado;

    public Administrador(String user, String password,String email,String fecha) {
        
        this.password=password;
        this.email=email;
        this.fecha=fecha;
        this.user=user;
        registrarUsuario();
        
    }
    
    public Administrador(String user,String nEmpleado){
        this.user=user;
        registrarAdministrador(user,nEmpleado);
    }
    public Administrador(String user,String password,String validar) throws ClassNotFoundException, SQLException {
        this.password=password;
        this.user=user;
        
    }
   
    
    
    @Override
    public void registrarUsuario(){
        try {
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO usuarios VALUES('" + user + "','"+password+"','"+ fecha + "','"+ email+"','Administrador')");
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String validarUsuario()throws ClassNotFoundException, SQLException{
       
            String salida="";
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            Statement sentencia=conexion.createStatement();
            ResultSet resultado= sentencia.executeQuery("SELECT * FROM usuarios WHERE Username='"+user+"'");
            while(resultado.next()){
                salida=resultado.getString("password");
            }
            return salida;
        
    }
    public void registrarAdministrador(String user,String nEmpleado){
        try {
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO admin VALUES('" + user + "','"+ nEmpleado+"')");
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String validarAdmin() throws SQLException, ClassNotFoundException{
        
            String salida="";
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            Statement sentencia=conexion.createStatement();
            ResultSet resultado= sentencia.executeQuery("SELECT * FROM admin WHERE Usuario='"+user+"'");
            while(resultado.next()){
                salida=resultado.getString("Empleado");
            }
            
            
            return salida;
    }
}

