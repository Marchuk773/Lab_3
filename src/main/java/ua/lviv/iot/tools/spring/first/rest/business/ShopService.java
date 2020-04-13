package ua.lviv.iot.tools.spring.first.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.tools.spring.first.rest.dataaccess.ShopRepository;
import ua.lviv.iot.tools.spring.first.rest.model.Shop;

@Service
public class ShopService extends AbstractService<Shop> {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    protected JpaRepository<Shop, Integer> getRepository() {
        return shopRepository;
    }

}