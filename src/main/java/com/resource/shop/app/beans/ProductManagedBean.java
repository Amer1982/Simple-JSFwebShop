package com.resource.shop.app.beans;

import com.resource.shop.app.beans.model.ShoppingCartItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.Iterator;
import com.resource.shop.app.business.ProductSessionBeanLocal;
import com.resource.shop.app.business.model.Product;


@SessionScoped//on će čuvati korpu->ShoppingCart
@Named("productManagedBean")
public class ProductManagedBean implements Serializable{

    @EJB
    private ProductSessionBeanLocal productSessionBeanLocal;
    
    private Integer quantity;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
    
    public ProductManagedBean() {
    }
    
    public void addProductToShoppingCart(Product product){
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            if (shoppingCartItem.getProduct().getId() == product.getId()) {
                int newQuantity = shoppingCartItem.getQuantity() + quantity;
                shoppingCartItem.setQuantity(newQuantity);
                return;
            }
        }
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, quantity);
        shoppingCartItems.add(shoppingCartItem);
    }
    public void removeItem(Product product) {
        Iterator<ShoppingCartItem> itemIterator = shoppingCartItems.iterator();
        while (itemIterator.hasNext()) {
            ShoppingCartItem item = itemIterator.next();
            if (item.getProduct().getId() == product.getId()) {
                if (item.getQuantity() > quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                    break;
                } else {
                    itemIterator.remove();
                }
            }
        }
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }
    
    

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    
    public List<Product> getAllProducts(){
        return productSessionBeanLocal.getAllProducts();
    }
    
      public boolean containsShoppingCartItems() {
        return !shoppingCartItems.isEmpty();
    }
}
