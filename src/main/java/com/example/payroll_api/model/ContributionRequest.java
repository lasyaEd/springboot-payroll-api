package com.example.payroll_api.model;
import jakarta.validation.constraints.*;

public class ContributionRequest {
    @NotBlank(message = "Employee ID is required")
    private String employeeId;

    @NotNull(message = "Contribution amount is required")
    @Min(value = 0, message = "Contribution must be non-negative")
    private Double contributionAmount;

    @NotBlank(message = "Plan ID is required")
    private String planId;

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Double getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(Double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

}
