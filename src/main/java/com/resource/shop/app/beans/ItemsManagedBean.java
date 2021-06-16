package com.resource.shop.app.beans;

import com.resource.shop.app.beans.model.ShoppingCartItem;
import com.resource.shop.app.business.model.Items;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import com.resource.shop.app.business.ItemsSessionBeanLocal;


@SessionScoped//on će čuvati korpu->ShoppingCart
@Named("productManagedBean")
public class ItemsManagedBean implements Serializable{

    @EJB
    private ItemsSessionBeanLocal itemsSessionBeanLocal;
    
    private Integer quantity;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
    
    public ItemsManagedBean() {
    }
    
    public void addProductToShoppingCart(Items items){
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            if (shoppingCartItem.getItem().getId() == items.getId()) {
                int newQuantity = shoppingCartItem.getQuantity() + quantity;
                shoppingCartItem.setQuantity(newQuantity);
                return;
            }
        }
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(items, quantity);
        shoppingCartItems.add(shoppingCartItem);
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
    
    
    
    public List<Items> getAllItems(){
        return itemsSessionBeanLocal.getAllItems();
    }
}
