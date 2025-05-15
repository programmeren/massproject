package com.example.edasapi.dto;

import java.util.List;

public class ApiResponse<T> {
    private String status;
    private String correlationId;
    private String spanIds;
    private String successMessage;
    private List<String> errors;
    private T body;

    public ApiResponse(String status, String correlationId, String spanIds, String successMessage, List<String> errors, T body) {
        this.status = status;
        this.correlationId = correlationId;
        this.spanIds = spanIds;
        this.successMessage = successMessage;
        this.errors = errors;
        this.body = body;
    }

    // Getters and setters omitted for brevity
}