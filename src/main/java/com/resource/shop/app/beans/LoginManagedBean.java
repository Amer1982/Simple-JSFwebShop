
package com.resource.shop.app.beans;

import com.resource.shop.app.business.AccessPrivilege;
import com.resource.shop.app.business.LoginSessionBeanLocal;
import com.resource.shop.app.business.model.Privilege;
import com.resource.shop.app.business.model.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@SessionScoped
@Named("loginManagedBean")
public class LoginManagedBean implements Serializable{
  @EJB
    private LoginSessionBeanLocal loginSessionBeanLocal;
    
    private String username;
    private String password;
    private String message = "";

    public LoginManagedBean() {
    }
    
    public String login(){
        
        
        User user = loginSessionBeanLocal.login(username, password);
        Privilege privilege = user.getIdPrivilage();
        
        if(AccessPrivilege.USER.getId()==privilege.getId()){
            return "index";
        }else if (AccessPrivilege.ADMIN.getId()==privilege.getId()){
        return "admin";
        }else{
            message = "Pogrešna kombinacija korisničkog imena :  " +username+" i lozinke : " + password;
            return "login";
        }
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
