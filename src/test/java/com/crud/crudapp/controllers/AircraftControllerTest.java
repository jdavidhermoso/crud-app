package com.crud.crudapp.controllers;

import com.crud.crudapp.models.Aircraft;
import com.crud.crudapp.services.AircraftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AircraftController.class)
public class AircraftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AircraftController aircraftController;

    @Mock
    private AircraftService aircraftService;

    @Test
    public void getShouldReturnStatusOkAndEmptyList() throws Exception {
        when(aircraftController.getAllAircrafts())
                .thenReturn(Collections.emptyList());
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void getShouldReturnStatusOkWhenAircraftIsReturned() throws Exception {
        Aircraft aircraft = new Aircraft("Cool aircraft", "737-NG");
        List<Aircraft> aircraftsList = Arrays.asList(aircraft);
        when(aircraftController.getAllAircrafts())
                .thenReturn(aircraftsList);
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":null,\"name\":\"Cool aircraft\",\"model\":\"737-NG\"}]"));
    }

    @Test
    public void postShouldReturnStatusOk() throws Exception {
        Aircraft aircraft = new Aircraft("New aircraft", "737-NG");
        aircraft.setId(1);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(aircraft);

        when(aircraftController.getAircraft(1)).thenReturn(aircraft);

        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void putShouldReturnStatusOk() throws Exception {
        Aircraft aircraft = new Aircraft("Some Aircraft", "737-NG");

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(aircraft);

        when(aircraftController.updateAircraft(aircraft))
                .thenReturn(aircraft);
        mockMvc.perform(put("/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJson))
                .andExpect(status().isOk());
    }
}