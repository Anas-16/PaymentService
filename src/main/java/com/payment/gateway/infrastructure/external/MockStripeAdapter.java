package com.payment.gateway.infrastructure.external;

import com.payment.gateway.domain.model.BankResponse;
import com.payment.gateway.domain.port.out.BankGatewayPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component
public class MockStripeAdapter implements BankGatewayPort {

    @Override
    public BankResponse processPayment(BigDecimal amount, String currency, String token) {
        log.info("Processing payment via Mock Stripe: Amount={}, Currency={}, Token={}", amount, currency, token);

        try {
            Thread.sleep(500); // Simulate network delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Payment processing interrupted", e);
            return new BankResponse(null, false, "INTERRUPTED");
        }

        // Simulate 20% failure rate
        if (ThreadLocalRandom.current().nextInt(100) < 20) {
            log.warn("Mock payment failed randomly");
            return new BankResponse(null, false, "Decline");
        }

        String externalId = UUID.randomUUID().toString();
        log.info("Mock payment successful. Transaction ID: {}", externalId);
        return new BankResponse(externalId, true, null);
    }
}
