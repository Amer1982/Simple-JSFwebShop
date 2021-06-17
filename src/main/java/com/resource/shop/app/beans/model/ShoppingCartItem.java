package com.resource.shop.app.beans.model;

import com.resource.shop.app.business.model.Product;
import java.io.Serializable;

public class ShoppingCartItem implements Serializable{
    private Product product;
    private Integer quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    public double getTotalPrice(){
        return quantity*product.getPrice();
    }
}