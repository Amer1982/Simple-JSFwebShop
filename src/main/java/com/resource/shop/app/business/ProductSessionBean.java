package com.resource.shop.app.business;

import com.resource.shop.app.business.model.Product;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductSessionBean implements ProductSessionBeanLocal {

    @PersistenceContext(name = "PU_SHOP")
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        try {
            Query query = entityManager.createNamedQuery("Product.findAll");
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Product getProductById(int id) {
        return (Product) entityManager.find(Product.class, id);
    }

    public void addProduct(Product product) {
        
        //entityManager.getTransaction().begin();
        entityManager.persist(product);
        //entityManager.getTransaction().commit();
    }

    public void editProduct(Product modifiedProduct) {
        
        Product existingProduct = getProductById(modifiedProduct.getId());
        if (existingProduct != null) {
            existingProduct.setName(modifiedProduct.getName());
            //entityManager.getTransaction().begin();
            entityManager.merge(existingProduct);
            //entityManager.getTransaction().commit();
        }
    }

    public void deleteProduct(int productId) {
        Product existingProduct = getProductById(productId);
        if (existingProduct != null) {
            //entityManager.getTransaction().begin();
            entityManager.remove(existingProduct);
            //entityManager.getTransaction().commit();
        }
    }
}
