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
public final class Normal implements Usuario {
    String user,password,email,fecha,nombre,subscripcion,domicilio;

    public Normal(String user, String password,String email,String fecha) {
        
        this.password=password;
        this.email=email;
        this.fecha=fecha;
        this.user=user;
        registrarUsuario();
    }
    
    public Normal(String user,String nombre,String subscripcion,String domicilio,String registro){
        this.user=user;
        registrarNormal(nombre,subscripcion,domicilio);
    }
            
    public Normal(String user,String Nombre,String validar) throws ClassNotFoundException, SQLException{
        this.user=user;
        
    }   
            
    @Override
    public void registrarUsuario(){
        try {
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO usuarios VALUES('" + user + "','"+password+"','"+ fecha + "','"+ email+"','Normal')");
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
    public final void registrarNormal(String nombre, String subscripcion,String domicilio){
        try {
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO normal VALUES('" + user + "','"+ nombre+"','"+subscripcion+"','"+domicilio+"')");
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
