package com.crud.crudapp.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AircraftTest {

    @Test
    public void shouldSetAircraftId() throws Exception {
        final Integer aircraftId = 32;
        Aircraft aircraft = new Aircraft();

        aircraft.setId(aircraftId);

        assertThat(aircraft.getId()).isEqualTo(aircraftId);
    }

    @Test
    public void shouldSetAircraftNameWhenInstantiate() throws Exception {
        final String aircraftName = "New Aircraft name";
        final String aircraftModel = "Aircraft model";

        Aircraft aircraft = new Aircraft(aircraftName, aircraftModel);

        assertThat(aircraft.getName()).isEqualTo(aircraftName);
    }

    @Test
    public void shouldSetAircraftModelWhenInstantiate() throws Exception {
        final String aircraftName = "New Aircraft name";
        final String aircraftModel = "Aircraft model";

        Aircraft aircraft = new Aircraft(aircraftName, aircraftModel);

        assertThat(aircraft.getmodel()).isEqualTo(aircraftModel);
    }

    @Test
    public void shouldSetAircraftName() throws Exception {
        final String aircraftName = "New name";
        Aircraft aircraft = new Aircraft();

        aircraft.setName(aircraftName);

        assertThat(aircraft.getName()).isEqualTo(aircraftName);
    }

    @Test
    public void shouldSetAircraftModel() throws Exception {
        final String aircraftModel = "737-NG";
        Aircraft aircraft = new Aircraft();

        aircraft.setmodel(aircraftModel);

        assertThat(aircraft.getmodel()).isEqualTo(aircraftModel);
    }
}