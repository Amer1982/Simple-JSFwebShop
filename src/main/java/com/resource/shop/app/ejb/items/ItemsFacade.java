/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.ejb.items;


import com.resource.shop.app.ejb.AbstractFacade;
import com.resource.shop.app.business.model.Items;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bnc
 */
@Stateless
public class ItemsFacade extends AbstractFacade<Items> implements ItemsFacadeLocal {

    @PersistenceContext(unitName = "PU_SHOP")
    private EntityManager entityManager;
    
    public ItemsFacade() {
        super(Items.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;}
}
