
package com.resource.shop.app.business;

import com.resource.shop.app.business.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class LoginSessionBean implements LoginSessionBeanLocal {
    
    @PersistenceContext(unitName = "PU_SHOP")
    private EntityManager entityManager;

    @Override
    public User login(String username, String password) {
        try{
            return (User) entityManager.createNamedQuery("User.findByUsernamePassword")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch(Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

   
}
