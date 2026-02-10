package com.payment.gateway.domain.port.in;

import java.math.BigDecimal;
import java.util.UUID;

public record ProcessPaymentCommand(
        UUID customerId,
        BigDecimal amount,
        String currency,
        UUID paymentMethodId) {
}
