package com.payment.gateway.infrastructure.web;

import com.payment.gateway.domain.model.PaymentTransaction;
import com.payment.gateway.domain.port.in.ProcessPaymentCommand;
import com.payment.gateway.domain.port.in.ProcessPaymentUseCase;
import com.payment.gateway.infrastructure.web.dto.PaymentRequest;
import com.payment.gateway.infrastructure.web.dto.PaymentResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentController(ProcessPaymentUseCase processPaymentUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> initiatePayment(@RequestBody PaymentRequest request) {
        ProcessPaymentCommand command = new ProcessPaymentCommand(
                request.customerId(),
                request.amount(),
                request.currency(),
                request.paymentMethodId());

        PaymentTransaction transaction = processPaymentUseCase.process(command);

        PaymentResponse response = new PaymentResponse(
                transaction.getId(),
                transaction.getStatus().name(),
                null // Transaction ID is nullable as per requirements
        );

        return ResponseEntity.ok(response);
    }
}
