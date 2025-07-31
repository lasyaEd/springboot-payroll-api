package com.example.payroll_api.controller;

import com.example.payroll_api.model.ContributionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    @PostMapping
    public ResponseEntity<String> submitContribution(@Valid @RequestBody ContributionRequest request) {
        // Basic business logic for demo
        if (request.getContributionAmount() > 19500) {
            return ResponseEntity.badRequest().body("Contribution exceeds IRS limit ($19,500)");
        }

        return ResponseEntity.ok("Contribution accepted for employee " + request.getEmployeeId());
    }

}
