package com.payment.gateway.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentTransaction {

    private UUID id;
    private BigDecimal amount;
    private String currency;
    private TransactionStatus status;
    private String idempotencyKey;
    private String externalId;

    public PaymentTransaction(UUID id, BigDecimal amount, String currency, TransactionStatus status,
            String idempotencyKey, String externalId) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.idempotencyKey = idempotencyKey;
        this.externalId = externalId;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
