package com.crud.crudapp.services;

import com.crud.crudapp.models.Aircraft;
import com.crud.crudapp.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Aircraft> foundAircraft = aircraftRepository.findById(id);

        if (foundAircraft.isPresent()) {
            return foundAircraft.get();
        }

        throw new RuntimeException("Trying to retrieve an aircraft that does not exist");
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Aircraft aircraft) {
        Optional<Aircraft> aircraftToUpdate = aircraftRepository.findById(aircraft.getId());

        if (aircraftToUpdate.isPresent()) {
            return aircraftRepository.save(aircraft);
        }

        throw new RuntimeException("Trying to update unexistant aircraft");
    }

    public Aircraft deleteAircraft(Integer id) {
        Optional<Aircraft> aircraftToDelete = aircraftRepository.findById(id);

        if (aircraftToDelete.isPresent()) {
            aircraftRepository.deleteById(id);

            return aircraftToDelete.get();
        }

        throw new RuntimeException("Trying to delete an aircraft that does not exist");
    }
}
