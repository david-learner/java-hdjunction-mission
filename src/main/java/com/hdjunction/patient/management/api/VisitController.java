package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.service.VisitCommandService;
import com.hdjunction.patient.management.service.dto.RegisteringVisitRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    private final VisitCommandService visitCommandService;

    public VisitController(VisitCommandService visitCommandService) {
        this.visitCommandService = visitCommandService;
    }

    /**
     * 내원정보를 등록한다
     */
    @PostMapping("/api/visits")
    public ResponseEntity<Void> registerVisit(@RequestBody RegisteringVisitRequest request) {
        Long id = visitCommandService.registerVisit(request);
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }
}
