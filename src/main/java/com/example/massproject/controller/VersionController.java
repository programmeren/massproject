package com.example.massproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Tag(name = "Genel", description = "Sürüm bilgisi servisleri")
public class VersionController {

    @GetMapping("/versions")
    @Operation(summary = "Desteklenen versiyonları döner")
    public ResponseEntity<Map<String, Object>> getVersions(HttpServletRequest request) {
        String correlationId = request.getHeader("X-Correlation-ID");
        String requestId = request.getHeader("X-Request-ID");

        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("correlationId", correlationId);
        response.put("spanIds", "massproject-core");
        response.put("body", List.of("v1"));

        return ResponseEntity.ok(response);
    }
}
