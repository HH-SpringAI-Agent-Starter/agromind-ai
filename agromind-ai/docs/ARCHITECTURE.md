# Architecture

```text
User / Web UI
     |
     v
REST API: /api/agent/ask
     |
     v
AgroAgentService
     |
     v
Spring AI ChatClient
     |
     +--> Tool: crop_knowledge_search --> VectorStore --> PGVector
     +--> Tool: get_field_weather      --> Weather API placeholder
     +--> Tool: estimate_fertilizer    --> Rule-based calculator
     +--> Tool: get_crop_calendar      --> Crop management template
     |
     v
LLM final answer
```

## Why this structure?

- RAG 作为 Agent 工具，而不是固定流程：模型可以根据问题决定是否检索知识库。
- 知识库使用 Markdown：便于开源社区贡献和审阅。
- Ollama 作为默认模型：降低开源项目启动门槛。
- PGVector 作为默认向量库：方便演示企业级关系数据库 + 向量检索一体化架构。
