package ui;

import service.process.ShopService;
import service.utility.ServiceUtil;

import java.util.List;

public class GuiService {
    private ShopService shopService;
    private ServiceUtil serviceUtil;

    public GuiService(ShopService shopService) {
        this.shopService = shopService;
    }

    public List<String> getLatestItems() {
        return this.shopService.getAllShopItems();
    }
}
