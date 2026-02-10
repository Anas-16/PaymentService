package com.payment.gateway.infrastructure.persistence.repository;

import com.payment.gateway.infrastructure.persistence.entity.PaymentTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPaymentRepository extends JpaRepository<PaymentTransactionEntity, UUID> {
}
