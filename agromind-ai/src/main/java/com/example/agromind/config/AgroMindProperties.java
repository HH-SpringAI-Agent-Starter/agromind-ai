package com.example.agromind.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "agromind")
public record AgroMindProperties(Knowledge knowledge) {

    public record Knowledge(boolean autoIngest, int chunkSize, int chunkOverlap) {
    }
}
