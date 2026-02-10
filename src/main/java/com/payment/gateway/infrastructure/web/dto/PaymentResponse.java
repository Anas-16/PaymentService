package com.payment.gateway.infrastructure.web.dto;

import java.util.UUID;

public record PaymentResponse(
        UUID paymentId,
        String status,
        String transactionId) {
}
