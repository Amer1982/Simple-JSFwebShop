
package com.resource.shop.app.managed;

import com.resource.shop.app.ejb.user.UserFacadeLocal;
import com.resource.shop.app.business.model.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean implements Serializable{
    private List<User> _userList;
    
    @Inject
    UserFacadeLocal userFacadeLocal;
    
    @PostConstruct
    private void initialization(){
        _userList =userFacadeLocal.findAll();
    }

    public UserManagedBean() {
    }

    public List<User> getUserList() {
        return _userList;
    }
        
}
