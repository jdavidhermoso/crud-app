package com.crud.crudapp.controllers_layer;

import com.crud.crudapp.models.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.crud.crudapp.services_layer.AircraftService;

import java.util.List;

@RestController
public class AircraftController {

    @Autowired
    private final AircraftService aircraftService;

    public AircraftController(final AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping(value = "/list")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAircrafts();
    }

    @GetMapping(value = "/get/{id}")
    public Aircraft getAllAircraft(@PathVariable("id") final Integer id) {
        return aircraftService.getSingleAircraft(id);
    }

    @GetMapping(value = "/add")
    public Aircraft getAllAircraft() {
        Aircraft aircraft = new Aircraft("New cool aircraft", "737-MAX");
        return aircraftService.saveAircraft(aircraft);
    }
}
