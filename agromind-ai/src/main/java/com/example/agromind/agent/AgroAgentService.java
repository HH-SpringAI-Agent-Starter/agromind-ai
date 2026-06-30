package com.example.agromind.agent;

import com.example.agromind.web.dto.AgentResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AgroAgentService {

    private final ChatClient chatClient;

    public AgroAgentService(ChatClient agroChatClient) {
        this.chatClient = agroChatClient;
    }

    public AgentResponse ask(String question, String fieldId, String crop, String region) {
        String contextualQuestion = """
                用户问题：%s

                田块ID：%s
                作物：%s
                地区：%s
                """.formatted(
                question,
                valueOrUnknown(fieldId),
                valueOrUnknown(crop),
                valueOrUnknown(region)
        );

        String answer = chatClient.prompt()
                .user(contextualQuestion)
                .call()
                .content();

        return new AgentResponse(
                UUID.randomUUID().toString(),
                answer,
                Instant.now()
        );
    }

    private String valueOrUnknown(String value) {
        return value == null || value.isBlank() ? "未知" : value;
    }
}
