package Sesion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuack
 */
public class Usuario {
    String nombre, email, password, date;

    public Usuario(String nombre, String email, String password, String date ) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    
}
