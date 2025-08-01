package com.example.payroll_api.service;

import com.example.payroll_api.model.ContributionRequest;
import com.example.payroll_api.model.ContributionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {

    public ResponseEntity<ContributionResponse> processContribution(ContributionRequest request) {
        if (request.getContributionAmount() > 19500) {
            var error = new ContributionResponse("error", "Contribution exceeds IRS limit ($19,500)");
            return ResponseEntity.badRequest().body(error);
        }

        var success = new ContributionResponse("success", "Contribution accepted for employee " + request.getEmployeeId());
        return ResponseEntity.ok(success);
    }
}
