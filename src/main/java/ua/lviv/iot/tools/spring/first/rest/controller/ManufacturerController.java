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
import ua.lviv.iot.tools.spring.first.rest.business.ManufacturerService;
import ua.lviv.iot.tools.spring.first.rest.model.Manufacturer;

@RequestMapping("/manufacturer")
@RestController
public class ManufacturerController {
    private AtomicInteger manufacturerIdCounter = new AtomicInteger();
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getManufacturers() {
        return new LinkedList<Manufacturer>(manufacturerService.findAllManufacturers());
    }

    @GetMapping(path = "/{id}")
    public Manufacturer getManufacturer(final @PathVariable("id") Integer manufacturerId) {
        return manufacturerService.findManufacturer(manufacturerId);
    }

    @PostMapping
    public Manufacturer createManufacturer(final @RequestBody Manufacturer manufacturer) {
        manufacturer.setId(manufacturerIdCounter.incrementAndGet());
        manufacturerService.createManufacturer(manufacturer);
        return manufacturer;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Manufacturer> updateManufacturer(
            final @PathVariable("id") Integer manufacturerId,
            final @RequestBody Manufacturer manufacturer) {
        Manufacturer oldManufacturer = getManufacturer(manufacturerId);
        if (oldManufacturer != null) {
            Manufacturer returnedManufacturer = new Manufacturer(oldManufacturer.getName(),
                    oldManufacturer.getOwner());
            returnedManufacturer.setId(manufacturerId);
            manufacturerService.updateManufacturer(manufacturerId, manufacturer);
            return ResponseEntity.ok(returnedManufacturer);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteManufacturer(
            final @PathVariable("id") Integer manufacturerId) {
        if (getManufacturer(manufacturerId) != null) {
            manufacturerService.deleteManufacturer(manufacturerId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}