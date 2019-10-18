package com.crud.crudapp.controllers_layer;

import com.crud.crudapp.models.Aircraft;
import com.crud.crudapp.repository_layer.AircraftRepository;
import com.crud.crudapp.services_layer.AircraftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AircraftControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @InjectMocks
    private AircraftController aircraftController;

    @Mock
    private AircraftService aircraftService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void getShouldReturnStatusOk() throws Exception {
//        when(aircraftController.getAllAircrafts())
//                .thenReturn(Collections.emptyList());
//        mockMvc.perform(get("/list"))
//                .andExpect(status().isOk());
//    }

//    @Test
//    public void shouldReturnSingleAircraft() throws Exception {
//        Aircraft aircraft = new Aircraft("Some Aircraft", "737-NG");
//        aircraft.setId(1);
//        Optional<Aircraft> foundAircraft = Optional.of(aircraft);
//
//        when(aircraftRepository.findById(1))
//                .thenReturn(foundAircraft);
//
//        when(aircraftService.getSingleAircraft(1))
//                .thenReturn(aircraft);
//
//        mockMvc.perform(get("/get/1"))
//                .andExpect(content().string("aaaa")
//                );

//    }

    @Test
    public void shouldReturnAircraftsList() throws Exception {
        Aircraft aircraft = new Aircraft("Some Aircraft", "737-NG");
        List<Aircraft> aircraftsList = Arrays.asList(aircraft);

        when(aircraftService.getAircrafts())
                .thenReturn(aircraftsList);

        assertThat(aircraftController.getAllAircrafts()).hasSize(2);
    }

//    @Test
//    public void getShouldReturnStatusOkWhenAircraftIsReturned() throws Exception {
//        Aircraft aircraft = new Aircraft("Cool aircraft", "737-NG");
//        List<Aircraft> aircraftsList = Arrays.asList(aircraft);
//        when(aircraftController.getAllAircrafts())
//                .thenReturn(aircraftsList);
//        mockMvc.perform(get("/list"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void postShouldReturnStatusOk() throws Exception {
//        Aircraft aircraft = new Aircraft("New aircraft", "737-NG");
//
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(aircraft);
//
//        when(aircraftController.createAircraft(aircraft))
//                .thenReturn(aircraft);
//        mockMvc.perform(post("/add").contentType(APPLICATION_JSON_UTF8)
//                .content(requestJson))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void putShouldReturnStatusOk() throws Exception {
//        Aircraft aircraft = new Aircraft("Some Aircraft", "737-NG");
//
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(aircraft);
//
//        when(aircraftController.updateAircraft(aircraft))
//                .thenReturn(aircraft);
//        mockMvc.perform(put("/update").contentType(APPLICATION_JSON_UTF8)
//                .content(requestJson))
//                .andExpect(status().isOk());
//    }
}
