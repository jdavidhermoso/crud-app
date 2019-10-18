package com.crud.crudapp.services;

import com.crud.crudapp.models.Aircraft;
import com.crud.crudapp.repository.AircraftRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AircraftServiceTest {
    @Autowired
    private AircraftService aircraftService;

    @MockBean
    private AircraftRepository aircraftRepository;

    @Test
    public void shouldReturnAircraft() throws Exception {
        Aircraft aircraft = new Aircraft("Some Aircraft", "737-NG");
        aircraft.setId(1);
        Optional<Aircraft> optionalAircraft = Optional.of(aircraft);

        Mockito.when(aircraftRepository.findById(aircraft.getId()))
                .thenReturn(optionalAircraft);

        assertThat(aircraftService.getSingleAircraft(1).getName()).isEqualTo(aircraft.getName());
    }

    @Test
    public void shouldReturnListOfAircrafts() throws Exception {
        Aircraft aircraftOne = new Aircraft("Some Aircraft", "737-NG");
        aircraftOne.setId(1);
        Aircraft aircraftTwo = new Aircraft("Another Aircraft", "737-NG");
        aircraftTwo.setId(2);
        List<Aircraft> aircrafts = Arrays.asList(aircraftOne, aircraftTwo);

        Mockito.when(aircraftRepository.findAll())
                .thenReturn(aircrafts);

        assertThat(aircraftService.getAircrafts().size()).isEqualTo(2);
    }

    @Test
    public void shouldReturnNewAircraft() throws Exception {
        Aircraft aircraft = new Aircraft("New Aircraft", "737-NG");
        Mockito.when(aircraftRepository.save(aircraft))
                .thenReturn(aircraft);

        assertThat(aircraftService.saveAircraft(aircraft).getName()).isEqualTo(aircraft.getName());
    }

    @Test
    public void shouldReturnUpdatedAircraft() throws Exception {
        Aircraft aircraft = new Aircraft("Some Aircraft to update", "737-NG");
        aircraft.setId(1);
        Optional<Aircraft> foundAircraft = Optional.of(aircraft);

        Mockito.when(aircraftRepository.findById(aircraft.getId())).thenReturn(foundAircraft);

        Mockito.when(aircraftRepository.save(aircraft))
                .thenReturn(aircraft);

        assertThat(aircraftService.updateAircraft(aircraft).getName()).isEqualTo(aircraft.getName());
    }

    @Test
    public void shouldReturnDeletedAircraft() throws Exception {
        Aircraft aircraft = new Aircraft("Some Aircraft to delete", "737-NG");
        aircraft.setId(1);
        Optional<Aircraft> foundAircraft = Optional.of(aircraft);

        Mockito.when(aircraftRepository.findById(aircraft.getId())).thenReturn(foundAircraft);

        assertThat(aircraftService.deleteAircraft(aircraft.getId()).getName()).isEqualTo(aircraft.getName());
    }
}
