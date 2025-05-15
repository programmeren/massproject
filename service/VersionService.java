package com.example.edasapi.service;

import com.example.edasapi.dto.Versions;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VersionService {
    public List<Versions> getSupportedVersions() {
        return Collections.singletonList(new Versions("v1"));
    }
}