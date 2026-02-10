package com.payment.gateway.domain.service;

import com.payment.gateway.domain.model.PaymentTransaction;
import com.payment.gateway.domain.model.TransactionStatus;
import com.payment.gateway.domain.port.in.ProcessPaymentCommand;
import com.payment.gateway.domain.port.in.ProcessPaymentUseCase;
import com.payment.gateway.domain.port.out.PaymentRepositoryPort;

import java.util.UUID;

public class PaymentDomainService implements ProcessPaymentUseCase {

    private final PaymentRepositoryPort paymentRepositoryPort;

    public PaymentDomainService(PaymentRepositoryPort paymentRepositoryPort) {
        this.paymentRepositoryPort = paymentRepositoryPort;
    }

    @Override
    public PaymentTransaction process(ProcessPaymentCommand command) {
        if (command.amount().signum() <= 0) {
            throw new com.payment.gateway.domain.exception.InvalidPaymentException("Amount must be positive");
        }
        if (!"USD".equals(command.currency()) && !"EUR".equals(command.currency())) {
            throw new com.payment.gateway.domain.exception.InvalidPaymentException("Currency not supported");
        }

        // Create new transaction logic
        PaymentTransaction transaction = new PaymentTransaction(
                UUID.randomUUID(),
                command.amount(),
                command.currency(),
                TransactionStatus.PENDING,
                UUID.randomUUID().toString() // Generating a simple idempotency key for now
        );

        return paymentRepositoryPort.save(transaction);
    }
}
