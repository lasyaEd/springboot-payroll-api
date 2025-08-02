package com.example.payroll_api.controller;

import com.example.payroll_api.model.ContributionRequest;
import com.example.payroll_api.model.ContributionResponse;
import com.example.payroll_api.service.ContributionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity<ContributionResponse> updateContribution(@RequestParam String employeeId, @RequestBody ContributionRequest request) {
        return contributionService.updateContribution(employeeId, request);
    }

    @DeleteMapping
    public ResponseEntity<ContributionResponse> deleteContribution(@RequestParam String employeeId) {
        return contributionService.deleteContribution(employeeId);
    }

    @GetMapping("/all")
    public List<ContributionRequest> getAllContributions() {
        return contributionService.getAllContributions();
    }

}
