package ua.lviv.iot.tools.spring.first.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.tools.spring.first.rest.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
