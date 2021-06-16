package com.resource.shop.app.business;

import com.resource.shop.app.business.model.Items;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ItemsSessionBeanLocal {

    public List<Items> getAllItems();
}
