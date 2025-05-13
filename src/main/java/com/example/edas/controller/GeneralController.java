package com.example.edas.controller;

import com.example.edas.dto.VersionResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/versions")
public class GeneralController {

    @GetMapping
    public VersionResponse getVersions(
            @RequestHeader("X-Request-ID") String requestId,
            @RequestHeader("X-Correlation-ID") String correlationId,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader(value = "Accept-Encoding", required = false) String acceptEncoding
    ) {
        String spanIds = "general-service:" + UUID.randomUUID();
        String[] versions = {"v1"};

        return new VersionResponse("200", correlationId, spanIds, versions);
    }
}