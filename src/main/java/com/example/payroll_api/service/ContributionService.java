package com.example.payroll_api.service;

import com.example.payroll_api.model.ContributionRequest;
import com.example.payroll_api.model.ContributionResponse;
import com.example.payroll_api.repository.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributionService {

    @Autowired
    private ContributionRepository repository;

    public ResponseEntity<ContributionResponse> processContribution(ContributionRequest request) {
        if (request.getContributionAmount() > 19500) {
            var error = new ContributionResponse("error", "Contribution exceeds IRS limit ($19,500)");
            return ResponseEntity.badRequest().body(error);
        }

        repository.save(request);

        var success = new ContributionResponse("success", "Contribution accepted for employee " + request.getEmployeeId());
        return ResponseEntity.ok(success);
    }

    public ResponseEntity<?> getContributionByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ContributionResponse> updateContribution(String employeeId, ContributionRequest request) {
        Optional<ContributionRequest> existing = repository.findByEmployeeId(employeeId);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ContributionRequest update = existing.get();
        update.setContributionAmount(request.getContributionAmount());
        update.setPlanId(request.getPlanId());

        repository.save(update);

        return ResponseEntity.ok(new ContributionResponse("success", "Contribution updated for employee " + employeeId));
    }

    public ResponseEntity<ContributionResponse> deleteContribution(String employeeId) {
        Optional<ContributionRequest> existing = repository.findByEmployeeId(employeeId);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(existing.get());

        return ResponseEntity.ok(new ContributionResponse("success", "Contribution deleted for employee " + employeeId));
    }

    public List<ContributionRequest> getAllContributions() {
        return repository.findAll();
    }

}
