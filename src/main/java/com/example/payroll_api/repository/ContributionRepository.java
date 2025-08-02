package com.example.payroll_api.repository;

import com.example.payroll_api.model.ContributionRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ContributionRepository extends MongoRepository<ContributionRequest, String> {
    Optional<ContributionRequest> findByEmployeeId(String employeeId);
}
