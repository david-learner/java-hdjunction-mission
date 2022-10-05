package com.hdjunction.patient.management.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdjunction.patient.management.service.VisitCommandService;
import com.hdjunction.patient.management.service.dto.RegisteringVisitRequest;
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

@WebMvcTest(VisitController.class)
public class VisitControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private VisitCommandService visitCommandService;

    @Test
    void 환자정보를_등록한다() throws Exception {
        RegisteringVisitRequest request = new RegisteringVisitRequest(1L, "1");
        given(visitCommandService.registerVisit(any())).willReturn(1L);

        this.mockMvc.perform(post("/api/visits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(header().string(HttpHeaders.LOCATION, containsString("/api/visits/")))
                .andExpect(status().isCreated());
    }
}
