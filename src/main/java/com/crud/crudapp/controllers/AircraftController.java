package com.crud.crudapp.controllers;

import com.crud.crudapp.models.Aircraft;
import com.crud.crudapp.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping(value = "/all")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAircrafts();
    }

    @GetMapping(value = "/{id}")
    public Aircraft getAircraft(@PathVariable("id") final Integer id) {
        return aircraftService.getSingleAircraft(id);
    }

    @PostMapping(value = "")
    public Aircraft createAircraft(@RequestBody final Aircraft aircraft) {
        return aircraftService.saveAircraft(aircraft);
    }

    @PutMapping(value = "")
    public Aircraft updateAircraft(@RequestBody final Aircraft aircraft) {
        return aircraftService.saveAircraft(aircraft);
    }

    @DeleteMapping(value = "/{id}")
    public Aircraft deleteAircraft(@PathVariable("id") final Integer id) {
        return aircraftService.deleteAircraft(id);
    }
}
