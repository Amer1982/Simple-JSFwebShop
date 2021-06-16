/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author bnc
 */
public abstract class AbstractFacade<E> {
    private Class<E> entityClass;


    public AbstractFacade(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void create (E entity){
    getEntityManager().persist(entity);
    }
    
    public void edit (E entity){
        getEntityManager().merge(entity);
    }
    
    public void remove (E entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    public E find(Object id){
        return getEntityManager().find(entityClass, id);
    }
    
    public List<E> findAll(){
        CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    public int count(){
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<E> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(criteriaBuilder.count(root));
        Query query = getEntityManager().createQuery(criteriaQuery);
        return ((Long)query.getSingleResult()).intValue();
    }
}
