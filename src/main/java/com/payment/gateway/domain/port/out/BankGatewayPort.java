package com.payment.gateway.domain.port.out;

import com.payment.gateway.domain.model.BankResponse;
import java.math.BigDecimal;

public interface BankGatewayPort {
    BankResponse processPayment(BigDecimal amount, String currency, String token);
}
