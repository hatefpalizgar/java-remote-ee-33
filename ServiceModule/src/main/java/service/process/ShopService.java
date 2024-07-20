package service.process;


import repository.MySqlManager;
import service.utility.ServiceUtil;

import java.util.List;

// Service contains the business logic
public class ShopService {
    private MySqlManager mySqlManager;

    public ShopService(MySqlManager mySqlManager) {
        this.mySqlManager = mySqlManager;
    }

    public List<String> getAllShopItems() {
        List<String> items = mySqlManager.getShopItems();

        return ServiceUtil.filterItems(items);
    }
}
