package com.example.agromind.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AgentRequest(
        @NotBlank @Size(max = 2000) String question,
        @Size(max = 64) String fieldId,
        @Size(max = 64) String crop,
        @Size(max = 128) String region
) {
}
