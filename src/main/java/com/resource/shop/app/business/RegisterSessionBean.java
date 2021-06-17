package com.resource.shop.app.business;

import com.resource.shop.app.business.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RegisterSessionBean implements RegisterSessionBeanLocal {

    @PersistenceContext(unitName = "PU_SHOP")
    private EntityManager entityManager;

    @Override
    public boolean register(Integer id, String username, String password, String name, String surname) {
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername").setParameter("username", username);
            List<User> users = (List<User>) query.getResultList();
            if(!users.isEmpty()){
                return false;
            }
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
            user.setUsername(username);
            
            entityManager.persist(user);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        } 
    }
}
