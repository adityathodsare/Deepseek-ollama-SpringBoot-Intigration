package com.DeepseekChat.ollama_deepseek_chatBot.service;

import reactor.core.publisher.Flux;

public interface deepseekService {
    String askDeepseek(String question);
    Flux<String> streamDeepseek(String question);
}
