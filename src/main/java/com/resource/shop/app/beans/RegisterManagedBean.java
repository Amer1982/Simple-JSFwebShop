package com.resource.shop.app.beans;

import com.resource.shop.app.business.RegisterSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


@SessionScoped
@Named("registerManageBean")
public class RegisterManagedBean implements Serializable {

    @EJB
    private RegisterSessionBeanLocal registerSessionBeanLocal;

    

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String message = "";

    public RegisterManagedBean() {
    }

    //register metoda - navigacija ka drugom jsf
    public String register() {
        boolean userCreated = registerSessionBeanLocal.register(id, username, password, name, surname);
        if (userCreated) {
            return "index";
        } else {
            //Ako ima korisnik
            message = "Korisnik već postoji";
            return "register";
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
