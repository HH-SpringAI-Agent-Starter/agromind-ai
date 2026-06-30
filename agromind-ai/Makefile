.PHONY: infra up models run test clean

infra:
	docker compose up -d postgres

up:
	docker compose --profile local-llm up -d

models:
	ollama pull qwen2.5:7b
	ollama pull mxbai-embed-large

run:
	mvn spring-boot:run

test:
	mvn test

clean:
	docker compose down -v
