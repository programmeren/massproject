package com.example.massproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Subscription API", description = "Abonelik işlemleri için endpointler")
@RestController
@RequestMapping("/v1/subscription")
public class SubscriptionController {

    @Operation(
        summary = "Abonelik kontrolü yapar",
        description = "Abonelik bilgilerini kontrol eder ve sistemde kayıtlıysa doğrulama anahtarı döner",
        responses = {
            @ApiResponse(responseCode = "200", description = "Başarılı kontrol"),
            @ApiResponse(responseCode = "400", description = "Eksik veya hatalı istek"),
            @ApiResponse(responseCode = "403", description = "Yetkisiz erişim")
        }
    )
    @PostMapping("/check")
    public String checkSubscription() {
        return "Subscription check endpoint";
    }

    @Operation(
        summary = "Abonelik detaylarını getirir",
        description = "Verilen subscriptionKey ile eşleşen aboneliğin detay bilgilerini döner",
        responses = {
            @ApiResponse(responseCode = "200", description = "Başarılı sorgu"),
            @ApiResponse(responseCode = "404", description = "Abonelik bulunamadı")
        }
    )
    @GetMapping("/{subscriptionKey}")
    public String getSubscription(
            @Parameter(description = "Aboneliğe ait UUID") @PathVariable String subscriptionKey) {
        return "Subscription details for key: " + subscriptionKey;
    }

    @Operation(
        summary = "Tüketim/Üretim verilerini getirir",
        description = "Verilen tarih aralığında ve veri kırılımına göre tüketim/üretim verilerini döner",
        responses = {
            @ApiResponse(responseCode = "200", description = "Veri başarıyla listelendi"),
            @ApiResponse(responseCode = "400", description = "Eksik parametreler"),
            @ApiResponse(responseCode = "404", description = "Abonelik bulunamadı")
        }
    )
    @GetMapping("/{subscriptionKey}/readings")
    public String getReadings(
            @Parameter(description = "Abonelik anahtarı") @PathVariable String subscriptionKey,
            @Parameter(description = "Başlangıç tarihi (ISO8601)") @RequestParam String start,
            @Parameter(description = "Bitiş tarihi (ISO8601)") @RequestParam String end,
            @Parameter(description = "Veri kırılımı (hour/day/month/year)") @RequestParam String granularity) {
        return "Reading data from " + start + " to " + end + " by " + granularity;
    }
}
