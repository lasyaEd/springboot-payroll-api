package com.example.payroll_api.service;

import com.example.payroll_api.model.ContributionRequest;
import com.example.payroll_api.model.ContributionResponse;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {

    public ContributionResponse processContribution(ContributionRequest request) {
        if (request.getContributionAmount() > 19500) {
            return new ContributionResponse("error", "Contribution exceeds IRS limit ($19,500)");
        }

        return new ContributionResponse("success", "Contribution accepted for employee " + request.getEmployeeId());
    }
}
