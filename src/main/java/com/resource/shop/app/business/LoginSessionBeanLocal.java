package com.resource.shop.app.business;

import com.resource.shop.app.business.model.User;
import javax.ejb.Local;


@Local
public interface LoginSessionBeanLocal {
    public User login(String username, String password);
}
