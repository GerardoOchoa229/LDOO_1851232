
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
public class FabricaUsuarios {
    private static FabricaUsuarios instancia;
    private FabricaUsuarios(){}
    private synchronized static void createInstance(){
        if(instancia==null){
                instancia = new FabricaUsuarios();
            }
    }
    
    public static FabricaUsuarios getInstance(){
        createInstance();
        return instancia;
    }
    
    public Usuario getUsuario(String user, String password,String email,String fecha,String tipo){
        if(tipo==null){
            return null;
        }
        if(tipo.equalsIgnoreCase("admin")){
            return new Administrador(user, password,email,fecha);
        }else if(tipo.equalsIgnoreCase("normal")){
            return new Normal(user, password,email,fecha);
        }else if(tipo.equalsIgnoreCase("invitado")){
            return new Invitado(user, password,email,fecha);
        }
        return null;
    }
    
    public Usuario validar(String user,String password,String validar, String tipo) throws ClassNotFoundException, SQLException {
        if(tipo==null){
        return null;
        }
        if(tipo.equalsIgnoreCase("admin")){
            return new Administrador(user, password,validar);
        }else if(tipo.equalsIgnoreCase("normal")){
            return new Normal(user, password,validar);
        }else if(tipo.equalsIgnoreCase("invitado")){
            return new Invitado(user, password,validar);
        }
        return null;
    }
}
