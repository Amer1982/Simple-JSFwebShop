/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resource.shop.app.ejb.items;

import com.resource.shop.app.business.model.Items;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bnc
 */
@Local
public interface ItemsFacadeLocal {
    void create(Items items);
    
    void edit(Items items);
    
    void remove(Items items);
    
    Items find(Object id);
    
    List<Items> findAll();
    
    int count();
}
