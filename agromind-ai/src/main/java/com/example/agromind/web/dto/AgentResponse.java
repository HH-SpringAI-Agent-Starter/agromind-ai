package com.example.agromind.web.dto;

import java.time.Instant;

public record AgentResponse(
        String traceId,
        String answer,
        Instant createdAt
) {
}
