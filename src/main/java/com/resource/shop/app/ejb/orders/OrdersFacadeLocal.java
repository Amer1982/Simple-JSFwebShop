/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.ejb.orders;

import com.resource.shop.app.business.model.Orders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bnc
 */
@Local
public interface OrdersFacadeLocal {
    void create(Orders orders);
    
    void edit(Orders orders);
    
    void remove(Orders orders);
    
    Orders find(Object id);
    
    List<Orders> findAll();
    
    int count();
}
