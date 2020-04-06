package ua.lviv.iot.tools.spring.first.rest.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.tools.spring.first.rest.dataaccess.ManufacturerRepository;
import ua.lviv.iot.tools.spring.first.rest.model.Manufacturer;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public void deleteManufacturer(Integer manufacturerId) {
        manufacturerRepository.deleteById(manufacturerId);
    }

    public Manufacturer findManufacturer(Integer manufacturerId) {
        return manufacturerRepository.findById(manufacturerId).orElse(null);
    }

    public List<Manufacturer> findAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public void updateManufacturer(Integer manufacturerId, Manufacturer manufacturer) {
        manufacturer.setId(manufacturerId);
        manufacturerRepository.save(manufacturer);
    }

}
