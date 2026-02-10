package com.payment.gateway.infrastructure.persistence;

import com.payment.gateway.domain.model.PaymentTransaction;
import com.payment.gateway.domain.port.out.PaymentRepositoryPort;
import com.payment.gateway.infrastructure.persistence.entity.PaymentTransactionEntity;
import com.payment.gateway.infrastructure.persistence.mapper.PaymentPersistenceMapper;
import com.payment.gateway.infrastructure.persistence.repository.SpringDataPaymentRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresPaymentRepositoryAdapter implements PaymentRepositoryPort {

    private final SpringDataPaymentRepository springDataPaymentRepository;
    private final PaymentPersistenceMapper paymentPersistenceMapper;

    public PostgresPaymentRepositoryAdapter(SpringDataPaymentRepository springDataPaymentRepository,
            PaymentPersistenceMapper paymentPersistenceMapper) {
        this.springDataPaymentRepository = springDataPaymentRepository;
        this.paymentPersistenceMapper = paymentPersistenceMapper;
    }

    @Override
    public PaymentTransaction save(PaymentTransaction transaction) {
        PaymentTransactionEntity entity = paymentPersistenceMapper.toEntity(transaction);
        PaymentTransactionEntity savedEntity = springDataPaymentRepository.save(entity);
        return paymentPersistenceMapper.toDomain(savedEntity);
    }
}
