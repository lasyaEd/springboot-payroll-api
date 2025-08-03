package com.example.payroll_api.model;

public class EmailRequest {
    private String employeeId;
    private String eventType;

    public EmailRequest(String eventType, String employeeId) {
        this.eventType = eventType;
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
