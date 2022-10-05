package com.hdjunction.patient.management.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdjunction.patient.management.api.dto.RegisteringHospitalFormRequest;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import com.hdjunction.patient.management.service.dto.UpdatingPatientFormRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class PatientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void 환자정보를_수정한다() throws Exception {
        Long hospitalId = registerHospital();
        RegisteringPatientFormRequest registeringRequest =
                new RegisteringPatientFormRequest(hospitalId, "홍길동", "M", "910203", "01011112222");
        Long patientId = registerPatient(registeringRequest);
        UpdatingPatientFormRequest updatingRequest =
                new UpdatingPatientFormRequest(hospitalId, "김길동", "F", "830201", "01033334444");

        this.mockMvc.perform(patch("/api/patients/" + patientId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatingRequest)))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/patients/" + patientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patient[?(@.name == '%s')]", updatingRequest.getPatientName()).exists())
                .andExpect(jsonPath("$.patient[?(@.sexCode == '%s')]", updatingRequest.getSexCode()).exists())
                .andExpect(jsonPath("$.patient[?(@.dateOfBirth == '%s')]", updatingRequest.getDateOfBirth()).exists())
                .andExpect(jsonPath("$.patient[?(@.mobilePhoneNumber == '%s')]", updatingRequest.getMobilePhoneNumber()).exists());
    }

    private Long registerPatient(RegisteringPatientFormRequest request) throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/patients/")))
                .andExpect(status().isCreated()).andReturn().getResponse();

        String resourceLocation = response.getHeader(HttpHeaders.LOCATION);
        return extractResourceId(resourceLocation);
    }

    private Long registerHospital() throws Exception {
        RegisteringHospitalFormRequest request = new RegisteringHospitalFormRequest("서울아산병원", "11100800", "박승일");

        MockHttpServletResponse response = this.mockMvc.perform(post("/api/hospitals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/hospitals/")))
                .andExpect(status().isCreated()).andReturn().getResponse();

        String resourceLocation = response.getHeader(HttpHeaders.LOCATION);
        return extractResourceId(resourceLocation);
    }

    private Long extractResourceId(String resourceLocation) {
        String[] tokens = resourceLocation.split("/");
        return Long.valueOf(tokens[tokens.length - 1]);
    }
}
