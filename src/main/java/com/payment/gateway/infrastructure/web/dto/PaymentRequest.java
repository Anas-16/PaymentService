package com.payment.gateway.infrastructure.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequest(
        @NotNull(message = "Customer ID is required") UUID customerId,

        @NotNull(message = "Amount is required") @DecimalMin(value = "0.01", message = "Amount must be greater than 0") BigDecimal amount,

        @NotBlank(message = "Currency is required") String currency,

        @NotNull(message = "Payment Method ID is required") UUID paymentMethodId) {
}
