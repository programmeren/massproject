package com.example.massproject.model;

import lombok.Data;

@Data
public class ComplaintRequest {
    private String complaintId;
    private String subscriptionKey;
    private String category;
    private String subCategory;
    private String content;
}
