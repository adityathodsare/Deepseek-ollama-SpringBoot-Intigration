# Deepseek-ollama-SpringBoot-Intigration

This is a Spring Boot WebFlux-based chatbot using Deepseek and spring AI
## Features
- Handles chat queries via REST API
- Supports streaming responses

## Endpoints
```plaintext
GET /askdeepseek?query=your_question      # Get a response from the chatbot
GET /askdeepseek/fast?query=your_question # Stream chatbot responses
