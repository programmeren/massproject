package com.example.massproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subscription")
public class SubscriptionController {

    @PostMapping("/check")
    public String checkSubscription() {
        return "Subscription check endpoint";
    }

    @GetMapping("/{subscriptionKey}")
    public String getSubscription(@PathVariable String subscriptionKey) {
        return "Subscription details for key: " + subscriptionKey;
    }

    @GetMapping("/{subscriptionKey}/readings")
    public String getReadings(@PathVariable String subscriptionKey,
                              @RequestParam String start,
                              @RequestParam String end,
                              @RequestParam String granularity) {
        return "Reading data from " + start + " to " + end + " by " + granularity;
    }
}
