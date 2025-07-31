package com.example.payroll_api.controller;

import com.example.payroll_api.model.ContributionRequest;
import com.example.payroll_api.model.ContributionResponse;
import com.example.payroll_api.service.ContributionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @PostMapping
    public ResponseEntity<ContributionResponse> submitContribution(@Valid @RequestBody ContributionRequest request) {
        var response = contributionService.processContribution(request);

        if ("error".equalsIgnoreCase(response.getStatus())) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
}
