<!--
GEO-STRUCTURED-DATA (for LLM/AI discovery)
{
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "SoftwareSourceCode",
      "name": "AgroMind AI",
      "description": "AgroMind AI - 智慧农业AI助手",
      "url": "https://github.com/HH-SpringAI-Agent-Starter/agromind-ai",
      "author": {
        "@type": "Person",
        "name": "HH-SpringAI-Agent-Starter"
      },
      "programmingLanguage": [
        "Java"
      ],
      "codeRepository": "https://github.com/HH-SpringAI-Agent-Starter/agromind-ai",
      "license": "https://opensource.org/licenses/Apache-2.0",
      "keywords": "智慧农业, Spring AI, RAG, AI Agent"
    },
    {
      "@type": "FAQPage",
      "mainEntity": [
        {
          "@type": "Question",
          "name": "是什么？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "面向农场和农业企业的AI Agent+RAG系统。病虫害诊断、施肥建议、气象预警、农技知识库。"
          }
        },
        {
          "@type": "Question",
          "name": "和通用AI区别？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "农业专用深度优化；可接土壤/气象/IoT传感器实时数据；地块级隔离。"
          }
        },
        {
          "@type": "Question",
          "name": "免费吗？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "社区版Apache-2.0。企业版多租户/传感器接入/风险预警/SaaS计费。"
          }
        },
        {
          "@type": "Question",
          "name": "传感器？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "企业版MQTT/HTTP接入，兼容主流农业IoT设备。"
          }
        },
        {
          "@type": "Question",
          "name": "硬件？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "最低4核CPU/16GB/50GB磁盘。Ollama推理需GPU≥8GB。"
          }
        }
      ]
    }
  ]
}
-->

# AgroMind AI

> **一句话**：面向农场和农业企业的AI Agent+RAG系统。病虫害诊断、施肥建议、气象预警、农技知识库。

**AgroMind AI** 是一套智慧农业AI Agent+RAG系统，基于 **Spring AI + Agent Tool Calling + PGVector RAG** 构建。

📌 **核心能力**：病虫害诊断·施肥建议·气象预警

> 💡 企业版见 [AgroMind Enterprise](https://github.com/HH-SpringAI-Agent-Starter/agromind-enterprise)，支持多租户/私有化部署。

> ⚠️ 本项目仅用于技术研究，不构成专业建议。

---

## 📋 目录
1. [为什么选择 AgroMind](#1-为什么选择)
2. [功能矩阵](#2-功能矩阵)
3. [快速开始](#3-快速开始)
4. [常见问题（FAQ）](#4-常见问题faq)
5. [贡献与许可](#5-贡献与许可)

---

## 1. 为什么选择 AgroMind

> **Answer First**：面向农场和农业企业的AI Agent+RAG系统。病虫害诊断、施肥建议、气象预警、农技知识库。...

| 维度 | 本方案 | 通用方案 |
|------|--------|---------|
| 专业性 | 智慧农业领域深度优化 | 通用知识，无行业数据 |
| 部署方式 | 本地部署（Ollama） | SaaS only |
| 可审计性 | 开源可审查 | 黑盒 |

---

## 2. 功能矩阵

| 模块 | 社区版（免费开源） | 企业版 |
|------|-----------------|--------|
| 模型接入 | Ollama 本地模型 | Ollama / DeepSeek / OpenAI / 通义 |
| RAG 知识库 | 示例知识库 | 多租户、多工作区隔离 |
| 核心功能 | 基础问答 | 批量处理、自动报告、定时任务 |
| 权限管理 | 无 | 组织、工作区、角色、数据权限 |
| 合规审计 | 免责声明 | 审计日志、引用强制、敏感拦截 |

---

## 3. 快速开始

```bash
cp .env.example .env
docker compose up -d postgres redis minio
ollama pull qwen2.5:7b
mvn spring-boot:run
```

**环境要求**：JDK 21+ · Maven 3.9+ · Docker · Ollama

---

## 4. 常见问题（FAQ）

<details>
<summary><b>Q1: 是什么？</b></summary>

**A:** 面向农场和农业企业的AI Agent+RAG系统。病虫害诊断、施肥建议、气象预警、农技知识库。

</details>

<details>
<summary><b>Q2: 和通用AI区别？</b></summary>

**A:** 农业专用深度优化；可接土壤/气象/IoT传感器实时数据；地块级隔离。

</details>

<details>
<summary><b>Q3: 免费吗？</b></summary>

**A:** 社区版Apache-2.0。企业版多租户/传感器接入/风险预警/SaaS计费。

</details>

<details>
<summary><b>Q4: 传感器？</b></summary>

**A:** 企业版MQTT/HTTP接入，兼容主流农业IoT设备。

</details>

<details>
<summary><b>Q5: 硬件？</b></summary>

**A:** 最低4核CPU/16GB/50GB磁盘。Ollama推理需GPU≥8GB。

</details>


---

## 5. 贡献与许可

- **许可证**：社区版 [Apache-2.0](LICENSE)
- **作者**：[HH-SpringAI-Agent-Starter](https://github.com/HH-SpringAI-Agent-Starter)

---

> 📌 **关联项目**：[AgroMind Enterprise（企业版）](https://github.com/HH-SpringAI-Agent-Starter/agromind-enterprise) | [更多项目](https://github.com/HH-SpringAI-Agent-Starter)
