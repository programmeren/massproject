package com.example.massproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ComplaintEntity {
    @Id
    private String complaintId;
    private String subscriptionKey;
    private String category;
    private String subCategory;
    private String content;

    public ComplaintEntity() {}

    public ComplaintEntity(ComplaintRequest req) {
        this.complaintId = req.getComplaintId();
        this.subscriptionKey = req.getSubscriptionKey();
        this.category = req.getCategory();
        this.subCategory = req.getSubCategory();
        this.content = req.getContent();
    }
}
