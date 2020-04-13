package ua.lviv.iot.tools.spring.first.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.tools.spring.first.rest.dataaccess.ManufacturerRepository;
import ua.lviv.iot.tools.spring.first.rest.model.Manufacturer;

@Service
public class ManufacturerService extends AbstractService<Manufacturer> {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    protected JpaRepository<Manufacturer, Integer> getRepository() {
        return manufacturerRepository;
    }

}
