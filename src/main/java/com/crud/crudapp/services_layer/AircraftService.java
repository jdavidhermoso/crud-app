package com.crud.crudapp.services_layer;

import com.crud.crudapp.models.Aircraft;
import com.crud.crudapp.repository_layer.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    private final AircraftRepository aircraftRepository;

    public AircraftService(final AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAircrafts() {
        return aircraftRepository.findAll();
    }

    public Aircraft getSingleAircraft(Integer id) {
        return aircraftRepository.findById(id).get();
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }
}
