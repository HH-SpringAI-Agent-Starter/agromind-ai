package com.example.agromind.web;

import com.example.agromind.agent.AgroAgentService;
import com.example.agromind.rag.KnowledgeIngestionService;
import com.example.agromind.web.dto.AgentRequest;
import com.example.agromind.web.dto.AgentResponse;
import com.example.agromind.web.dto.IngestResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AgentController {

    private final AgroAgentService agroAgentService;
    private final KnowledgeIngestionService ingestionService;

    public AgentController(AgroAgentService agroAgentService, KnowledgeIngestionService ingestionService) {
        this.agroAgentService = agroAgentService;
        this.ingestionService = ingestionService;
    }

    @PostMapping(value = "/agent/ask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AgentResponse ask(@Valid @RequestBody AgentRequest request) {
        return agroAgentService.ask(request.question(), request.fieldId(), request.crop(), request.region());
    }

    @PostMapping(value = "/knowledge/ingest", produces = MediaType.APPLICATION_JSON_VALUE)
    public IngestResponse ingest() {
        int chunks = ingestionService.ingestBundledKnowledge();
        return new IngestResponse(chunks, Instant.now());
    }

    @GetMapping("/healthz")
    public Map<String, String> healthz() {
        return Map.of("status", "ok", "service", "agromind-ai");
    }
}
