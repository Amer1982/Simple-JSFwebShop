
package com.resource.shop.app.managed;


import com.resource.shop.app.ejb.orders.OrdersFacadeLocal;
import com.resource.shop.app.business.model.Orders;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "ordersManagedBean")
@RequestScoped
public class OrdersManagedBean implements Serializable{
    private List<Orders> _ordersList;
    
    @Inject
    OrdersFacadeLocal ordersFacadeLocal;
    
    @PostConstruct
    private void initialization(){
        _ordersList=ordersFacadeLocal.findAll();
    }

    public OrdersManagedBean() {
    }

    public List<Orders> getOrdersList() {
        return _ordersList;
    }       
}
