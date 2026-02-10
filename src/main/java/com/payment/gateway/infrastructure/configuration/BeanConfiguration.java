package com.payment.gateway.infrastructure.configuration;

import com.payment.gateway.domain.port.in.ProcessPaymentUseCase;
import com.payment.gateway.domain.port.out.PaymentRepositoryPort;
import com.payment.gateway.domain.service.PaymentDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProcessPaymentUseCase processPaymentUseCase(PaymentRepositoryPort paymentRepositoryPort) {
        return new PaymentDomainService(paymentRepositoryPort);
    }
}
