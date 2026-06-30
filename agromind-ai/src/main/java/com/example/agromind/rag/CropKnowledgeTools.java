package com.example.agromind.rag;

import org.springframework.ai.document.Document;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CropKnowledgeTools {

    private final VectorStore vectorStore;

    public CropKnowledgeTools(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Tool(name = "crop_knowledge_search", description = "Search the agricultural RAG knowledge base for crop disease, soil, fertilization, irrigation, and field management guidance.")
    public String search(
            @ToolParam(description = "The farmer question or agricultural search query") String query,
            @ToolParam(description = "Number of relevant knowledge chunks to retrieve, usually 3 to 6") Integer topK
    ) {
        int safeTopK = topK == null ? 5 : Math.max(1, Math.min(topK, 8));
        List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder()
                .query(query)
                .topK(safeTopK)
                .similarityThreshold(0.35)
                .build());

        if (documents == null || documents.isEmpty()) {
            return "知识库没有检索到足够相关的内容。请让用户补充作物、地区、生长期、症状、图片或土壤检测数据。";
        }

        return documents.stream()
                .map(this::formatDocument)
                .collect(Collectors.joining("\n\n---\n\n"));
    }

    private String formatDocument(Document document) {
        Map<String, Object> metadata = document.getMetadata();
        return "来源：%s\n主题：%s\n内容：%s".formatted(
                metadata.getOrDefault("source", "unknown"),
                metadata.getOrDefault("topic", "general"),
                document.getText()
        );
    }
}
