package com.example.agromind.config;

import com.example.agromind.agent.SystemPrompts;
import com.example.agromind.rag.CropKnowledgeTools;
import com.example.agromind.tools.CropCalendarTools;
import com.example.agromind.tools.FertilizerTools;
import com.example.agromind.tools.WeatherTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AgroMindProperties.class)
public class ChatConfig {

    @Bean
    ChatClient agroChatClient(
            ChatClient.Builder builder,
            CropKnowledgeTools cropKnowledgeTools,
            WeatherTools weatherTools,
            FertilizerTools fertilizerTools,
            CropCalendarTools cropCalendarTools
    ) {
        return builder
                .defaultSystem(SystemPrompts.AGRO_AGENT)
                .defaultTools(cropKnowledgeTools, weatherTools, fertilizerTools, cropCalendarTools)
                .build();
    }
}
