package ua.lviv.iot.tools.spring.first.rest.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.tools.spring.first.rest.dataaccess.ShopRepository;
import ua.lviv.iot.tools.spring.first.rest.model.Shop;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(Integer shopId) {
        shopRepository.deleteById(shopId);
    }

    public Shop findShop(Integer shopId) {
        return shopRepository.findById(shopId).orElse(null);
    }

    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }

    public void updateShop(Integer shopId, Shop shop) {
        shop.setId(shopId);
        shopRepository.save(shop);
    }

}