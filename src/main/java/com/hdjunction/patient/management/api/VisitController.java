package com.hdjunction.patient.management.api;

import com.hdjunction.patient.management.api.util.ResourceLocationBuilder;
import com.hdjunction.patient.management.service.VisitCommandService;
import com.hdjunction.patient.management.service.dto.VisitRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> registerVisit(@RequestBody VisitRequest request) {
        Long id = visitCommandService.registerVisit(request);
        return ResponseEntity.created(ResourceLocationBuilder.build(id)).build();
    }

    /**
     * 내원정보를 수정한다
     */
    @PatchMapping("/api/visits/{id}")
    public ResponseEntity<Void> updateVisit(@PathVariable Long id, @RequestBody VisitRequest request) {
        visitCommandService.updateVisit(id, request);
        return ResponseEntity.ok().build();
    }
}
