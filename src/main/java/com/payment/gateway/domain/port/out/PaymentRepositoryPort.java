package com.payment.gateway.domain.port.out;

import com.payment.gateway.domain.model.PaymentTransaction;

public interface PaymentRepositoryPort {
    PaymentTransaction save(PaymentTransaction transaction);
}
