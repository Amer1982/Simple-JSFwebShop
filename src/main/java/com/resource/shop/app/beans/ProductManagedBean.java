package com.resource.shop.app.beans;

import com.resource.shop.app.beans.model.ShoppingCartItem;
import com.resource.shop.app.business.HttpHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.Iterator;
import com.resource.shop.app.business.ProductSessionBeanLocal;
import com.resource.shop.app.business.model.Product;
import java.io.IOException;
import javax.faces.context.FacesContext;

@SessionScoped//on će čuvati korpu->ShoppingCart
@Named("productManagedBean")
public class ProductManagedBean implements Serializable {

    @EJB
    private ProductSessionBeanLocal productSessionBeanLocal;

    private Integer quantity;
    private String name;
    private long price;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductSessionBeanLocal getProductSessionBeanLocal() {
        return productSessionBeanLocal;
    }

    public void setProductSessionBeanLocal(ProductSessionBeanLocal productSessionBeanLocal) {
        this.productSessionBeanLocal = productSessionBeanLocal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    public ProductManagedBean() {
    }

    public String addProduct() {
        Product product = new Product(id, name, price);
        if (product.getId() == 0) {
            productSessionBeanLocal.addProduct(product);
        } else {
            productSessionBeanLocal.editProduct(product);
        }
        return "admin";
    }

    public void goToEditProduct(Product product) throws IOException {
        //HttpHandler.getInstance().addToSession("currentProduct", product);
        name = product.getName();
        price = product.getPrice();
        id = product.getId();
        
        //return "admin";
    }

    public void editProduct(Product product) throws IOException {
        productSessionBeanLocal.editProduct(product);

        FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml"); //Redirect to home.xhtml
    }

    public String deleteProduct(String idStr) {
        int id = Integer.valueOf(idStr);
        productSessionBeanLocal.deleteProduct(id);

        return "admin";
    }

    public void addProductToShoppingCart(Product product) {
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

    public List<Product> getAllProducts() {
        return productSessionBeanLocal.getAllProducts();
    }

    public boolean containsShoppingCartItems() {
        return !shoppingCartItems.isEmpty();
    }
}
