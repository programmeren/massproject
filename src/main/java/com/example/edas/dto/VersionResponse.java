package com.example.edas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VersionResponse {
    private String status;
    private String correlationId;
    private String spanIds;
    private String[] body;
}