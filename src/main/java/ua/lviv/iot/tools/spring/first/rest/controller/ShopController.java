package ua.lviv.iot.tools.spring.first.rest.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.tools.spring.first.rest.business.ShopService;
import ua.lviv.iot.tools.spring.first.rest.model.Shop;

@RequestMapping("/shop")
@RestController
public class ShopController {

    private AtomicInteger shopIdCounter = new AtomicInteger();

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<Shop> getShops() {
        return new LinkedList<Shop>(shopService.findAllObjects());
    }

    @GetMapping(path = "/{id}")
    public Shop getShop(final @PathVariable("id") Integer shopId) {
        return shopService.findObject(shopId);
    }

    @PostMapping
    public Shop createShop(final @RequestBody Shop shop) {
        shop.setShopId(shopIdCounter.incrementAndGet());
        return shopService.createObject(shop);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Shop> updateShop(final @PathVariable("id") Integer shopId,
            final @RequestBody Shop shop) {
        Shop oldShop = getShop(shopId);
        if (oldShop != null) {
            Shop returnedShop = new Shop(oldShop.getName(), oldShop.getNumberInTown());
            returnedShop.setShopId(shopId);
            shop.setShopId(shopId);
            shopService.updateObject(shopId, shop);
            return ResponseEntity.ok(returnedShop);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTool(final @PathVariable("id") Integer shopId) {
        if (getShop(shopId) != null) {
            shopService.deleteObject(shopId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}