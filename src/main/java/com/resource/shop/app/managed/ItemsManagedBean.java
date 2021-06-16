
package com.resource.shop.app.managed;

import com.resource.shop.app.ejb.items.ItemsFacadeLocal;
import com.resource.shop.app.business.model.Items;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "itemsManagedBean")
@RequestScoped
public class ItemsManagedBean implements Serializable{
    private List<Items> _itemsList;
    
    @Inject
    ItemsFacadeLocal itemsFacadeLocal;
    
    @PostConstruct
    private void initialization(){
        _itemsList=itemsFacadeLocal.findAll();
    }

    public ItemsManagedBean() {
    }

    public List<Items> getItemsList() {
        return _itemsList;
    }
        
}
