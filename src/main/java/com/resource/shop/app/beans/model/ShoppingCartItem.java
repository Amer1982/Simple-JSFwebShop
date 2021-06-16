package com.resource.shop.app.beans.model;

import com.resource.shop.app.business.model.Items;
import java.io.Serializable;

public class ShoppingCartItem implements Serializable{
    private Items item;
    private Integer quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Items item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    public double getTotalPrice(){
        return quantity*item.getPrice();
    }
}
