package com.payment.gateway.infrastructure.persistence.mapper;

import com.payment.gateway.domain.model.PaymentTransaction;
import com.payment.gateway.domain.model.TransactionStatus;
import com.payment.gateway.infrastructure.persistence.entity.PaymentTransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentPersistenceMapper {

    public PaymentTransaction toDomain(PaymentTransactionEntity entity) {
        if (entity == null) {
            return null;
        }
        return new PaymentTransaction(
                entity.getId(),
                entity.getAmount(),
                entity.getCurrency(),
                TransactionStatus.valueOf(entity.getStatus().name()),
                entity.getIdempotencyKey());
    }

    public PaymentTransactionEntity toEntity(PaymentTransaction domain) {
        if (domain == null) {
            return null;
        }
        return PaymentTransactionEntity.builder()
                .id(domain.getId())
                .amount(domain.getAmount())
                .currency(domain.getCurrency())
                .status(PaymentTransactionEntity.TransactionStatus.valueOf(domain.getStatus().name()))
                .idempotencyKey(domain.getIdempotencyKey())
                .build();
    }
}
