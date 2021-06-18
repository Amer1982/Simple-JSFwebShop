package com.resource.shop.app.business;

import com.resource.shop.app.business.model.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductSessionBeanLocal {

    public List<Product> getAllProducts();
    
    public Product getProductById(int id);
    
    public void addProduct(Product product);
    
    public void editProduct(Product modifiedProduct);
    
    public void deleteProduct(int productId);
    
}
