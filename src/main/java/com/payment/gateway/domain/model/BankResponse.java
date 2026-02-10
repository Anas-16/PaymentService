package com.payment.gateway.domain.model;

public record BankResponse(
        String externalId,
        boolean success,
        String errorCode) {
}
