package com.payment.gateway.infrastructure.web.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
                String message,
                String errorCode,
                LocalDateTime timestamp) {
}
