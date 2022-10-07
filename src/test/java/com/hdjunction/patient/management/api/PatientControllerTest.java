package com.hdjunction.patient.management.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdjunction.patient.management.service.PatientCommandService;
import com.hdjunction.patient.management.service.PatientQueryService;
import com.hdjunction.patient.management.service.VisitQueryService;
import com.hdjunction.patient.management.service.dto.RegisteringPatientFormRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PatientCommandService patientCommandService;
    @MockBean
    private PatientQueryService patientQueryService;
    @MockBean
    private VisitQueryService visitQueryService;

    @Test
    void 환자정보를_등록한다() throws Exception {
        RegisteringPatientFormRequest request = new RegisteringPatientFormRequest(1L, "홍길동", "M", "910203", "01012345678");
        given(patientCommandService.registerPatient(any())).willReturn(1L);

        this.mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/patients/")))
                .andExpect(status().isCreated());
    }
}
