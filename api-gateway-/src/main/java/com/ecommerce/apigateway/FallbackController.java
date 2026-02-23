package com.ecommerce.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/payments")
    public String paymentFallback() {
        return "Payment service is currently unavailable. Circuit breaker is activated";
    }
}
