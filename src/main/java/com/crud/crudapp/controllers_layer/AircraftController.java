package com.crud.crudapp.controllers_layer;

import com.crud.crudapp.models.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crud.crudapp.services_layer.AircraftService;

import java.util.List;

@RestController
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

//    public AircraftController(final AircraftService aircraftService) {
//        this.aircraftService = aircraftService;
//    }

    @GetMapping(value = "/list")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAircrafts();
    }

    @GetMapping(value = "/get/{id}")
    public Aircraft getAircraft(@PathVariable("id") final Integer id) {
        return aircraftService.getSingleAircraft(id);
    }

    @PostMapping(value = "/add")
    public Aircraft createAircraft(@RequestBody final Aircraft aircraft) {
        return aircraftService.saveAircraft(aircraft);
    }

    @PutMapping(value = "/update")
    public Aircraft updateAircraft(@RequestBody final Aircraft aircraft) {
        return aircraftService.saveAircraft(aircraft);
    }

    @DeleteMapping(value = "/delete")
    public Aircraft deleteAircraft(@RequestBody final Integer id) {
        return aircraftService.deleteAircraft(id);
    }
}
