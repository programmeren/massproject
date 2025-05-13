package com.example.massproject.controller;

import com.example.massproject.model.ComplaintRequest;
import com.example.massproject.model.ComplaintResponse;
import com.example.massproject.model.ComplaintEntity;
import com.example.massproject.repository.ComplaintRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintRepository repository;

    @PostMapping
    @Operation(summary = "Şikayet oluşturur")
    public ComplaintResponse createComplaint(@RequestBody ComplaintRequest request) {
        ComplaintEntity entity = new ComplaintEntity(request);
        repository.save(entity);
        return new ComplaintResponse("success");
    }

    @GetMapping("/{complaintId}")
    @Operation(summary = "Şikayet detaylarını döner")
    public ComplaintEntity getComplaint(@PathVariable String complaintId) {
        Optional<ComplaintEntity> entity = repository.findById(complaintId);
        return entity.orElse(null);
    }
}
