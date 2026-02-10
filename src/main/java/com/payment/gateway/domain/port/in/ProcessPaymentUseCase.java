package com.payment.gateway.domain.port.in;

import com.payment.gateway.domain.model.PaymentTransaction;

public interface ProcessPaymentUseCase {
    PaymentTransaction process(ProcessPaymentCommand command);
}
