# AgroMind AI

一个面向农业场景的开源 **Spring AI + Agent + RAG 知识库** 项目。它用本地 Ollama 模型做对话和 Embedding，用 PostgreSQL/PGVector 存储农业知识向量，并通过 Spring AI Tool Calling 让 Agent 自动调用知识库检索、天气示例工具、施肥估算工具和作物管理日历工具。

> 项目定位：适合作为 GitHub 开源作品集、Spring AI 学习项目、农业 AI SaaS 的最小可运行原型。

## 功能

- 农业问答 Agent：围绕作物病害、土壤、施肥、田间管理生成建议。
- RAG 知识库：启动时自动导入 `src/main/resources/knowledge/*.md`。
- Tool Calling：模型可自动调用农业知识库、天气、施肥估算、作物日历工具。
- PGVector：使用 PostgreSQL + pgvector 做向量检索。
- 本地优先：默认使用 Ollama，方便开源用户无需云模型 API Key 也能跑。

## 技术栈

- Java 21
- Spring Boot 4.1.0
- Spring AI 2.0.0
- Ollama
- PostgreSQL + PGVector
- Maven

## 快速开始

### 1. 启动基础设施

```bash
docker compose up -d postgres
```

你也可以启动 docker compose 里的 Ollama：

```bash
docker compose up -d ollama
```

如果你本机已经安装 Ollama，可直接使用本机 Ollama。

### 2. 拉取模型

```bash
ollama pull qwen2.5:7b
ollama pull mxbai-embed-large
```

### 3. 启动应用

```bash
mvn spring-boot:run
```

启动成功后，应用会自动把 `knowledge` 目录下的农业资料写入 PGVector。

### 4. 访问接口

```bash
curl -X POST http://localhost:8080/api/agent/ask \
  -H 'Content-Type: application/json' \
  -d '{
    "question": "番茄叶片背面有灰褐色霉层，棚里湿度很高，应该怎么办？",
    "crop": "番茄",
    "region": "山东寿光",
    "fieldId": "greenhouse-001"
  }'
```

手动重新导入知识库：

```bash
curl -X POST http://localhost:8080/api/knowledge/ingest
```

## API

### `POST /api/agent/ask`

请求：

```json
{
  "question": "玉米大喇叭口期如何管理？",
  "crop": "玉米",
  "region": "河南周口",
  "fieldId": "field-001"
}
```

响应：

```json
{
  "traceId": "...",
  "answer": "...",
  "createdAt": "2026-06-30T...Z"
}
```

## 目录结构

```text
agromind-ai/
├── src/main/java/com/example/agromind
│   ├── agent/          # Agent 编排与系统提示词
│   ├── config/         # Spring AI ChatClient 配置
│   ├── rag/            # 知识库导入与 RAG 检索工具
│   ├── tools/          # 天气、施肥、作物日历工具
│   └── web/            # REST API
├── src/main/resources/knowledge/ # 内置农业知识库 Markdown
├── docker-compose.yml
└── README.md
```

## 后续可扩展方向

- 接入真实天气 API、土壤传感器、农事记录系统。
- 增加图片识别服务，用于叶片病害初筛。
- 增加多租户：农场、地块、用户、知识库隔离。
- 使用 Spring AI Chat Memory 做长期会话记忆。
- 加入 MCP Client，把第三方农资、农机、价格数据源变成标准工具。
- 做前端管理台：知识上传、问答历史、田块档案、风险预警。

## 重要声明

本项目提供的是农业 AI 应用开发示例，不构成农药、肥料或医疗/食品安全的最终专业建议。实际生产请结合当地农技推广部门、作物品种、土壤检测、农药标签和法律法规执行。

## 开源协议

Apache License 2.0
