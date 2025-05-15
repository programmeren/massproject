package com.example.edasapi.controller;

import com.example.edasapi.dto.ApiResponse;
import com.example.edasapi.dto.Versions;
import com.example.edasapi.service.VersionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/versions")
public class VersionController {

    private final VersionService versionService;

    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping
    public ApiResponse<List<Versions>> getVersions(
            @RequestHeader("X-Correlation-ID") String correlationId,
            @RequestHeader("X-Request-ID") String requestId,
            @RequestHeader("Authorization") String authorization
    ) {
        List<Versions> versions = versionService.getSupportedVersions();
        return new ApiResponse<>(
                "200",
                correlationId,
                "edas-api:version-controller",
                null,
                List.of(),
                versions
        );
    }
}