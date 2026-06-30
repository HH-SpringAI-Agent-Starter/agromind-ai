package com.example.agromind.web.dto;

import java.time.Instant;

public record IngestResponse(int chunks, Instant createdAt) {
}
