
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
public final class Invitado implements Usuario {
    String user,password,nombre,fecha,email;

    public Invitado(String user, String password,String email,String fecha) {
        this.password=password;
        this.email=email;
        this.fecha=fecha;
        this.user=user;
        registrarUsuario();
        
    }
    
    public Invitado(String user,String password){
        this.user=user;
        this.password=password;
        
    }
    
    public Invitado(String user,String nombre,String fecha) throws ClassNotFoundException, SQLException {
        this.user=user;
        this.nombre=nombre;
        this.fecha=fecha;
        
    }
    @Override
    public void registrarUsuario(){
        try {
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO usuarios VALUES('" + user + "','"+password+"','"+ fecha + "','"+ email+"','Invitado')");
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
    
    public void registrarInvitado(String nombre, String fRegistro){
        try {
            Class.forName(clase);
            Connection conexion= (Connection) DriverManager.getConnection(url,usuario,contraseña);
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO invitado VALUES('" + user + "','"+ nombre+"','"+fRegistro+"')");
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
