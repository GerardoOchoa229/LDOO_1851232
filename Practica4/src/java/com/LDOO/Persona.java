/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LDOO;

import java.util.Date;

/**
 *
 * @author cuack
 */
public class Persona {
    private String email;
    private String password;
    private String name;
    private Date date;

    public Persona() {
    }
    
    public Persona(String email, String password, String name, Date date) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
    
    
    
    
}