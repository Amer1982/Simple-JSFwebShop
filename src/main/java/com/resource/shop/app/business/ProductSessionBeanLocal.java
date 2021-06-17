package com.resource.shop.app.business;

import com.resource.shop.app.business.model.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductSessionBeanLocal {

    public List<Product> getAllProducts();
}
