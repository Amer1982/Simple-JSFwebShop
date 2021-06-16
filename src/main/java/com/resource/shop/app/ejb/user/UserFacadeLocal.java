/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.ejb.user;

import com.resource.shop.app.business.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bnc
 */
@Local
public interface UserFacadeLocal {
    void create(User user);
    
    void edit(User user);
    
    void remove(User user);
    
    User find(Object id);
    
    List<User> findAll();
    
    int count();
}
