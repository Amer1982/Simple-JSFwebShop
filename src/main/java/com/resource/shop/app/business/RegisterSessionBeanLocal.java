
package com.resource.shop.app.business;

import javax.ejb.Local;

@Local
public interface RegisterSessionBeanLocal {
    
    public boolean register(Integer id, String username, String password, String name, String surname);
}
