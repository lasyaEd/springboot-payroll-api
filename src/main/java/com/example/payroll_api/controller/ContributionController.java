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
    public ResponseEntity<ContributionResponse> contribution(@Valid @RequestBody ContributionRequest request) {
        return contributionService.processContribution(request);
    }

    @GetMapping
    public ResponseEntity<?> contributionByEmployeeId(@RequestParam String employeeId) {
        return contributionService.getContributionByEmployeeId(employeeId);
    }
}
