package com.resource.shop.app.business;

import com.resource.shop.app.business.model.Items;
import com.resource.shop.app.business.model.Orders;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ItemsSessionBean implements ItemsSessionBeanLocal {

    @PersistenceContext(name = "PU_SHOP")
    private EntityManager entityManager;

    @Override
    public List<Items> getAllItems() {
        try {
            Query query = entityManager.createNamedQuery("Items.findAll");
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }
}