package com.example.payroll_api.service;

import com.example.payroll_api.model.ContributionRequest;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {

    public String processContribution(ContributionRequest request) {
        if (request.getContributionAmount() > 19500) {
            return "Contribution exceeds IRS limit ($19,500)";
        }

        return "Contribution accepted for employee " + request.getEmployeeId();
    }
}
