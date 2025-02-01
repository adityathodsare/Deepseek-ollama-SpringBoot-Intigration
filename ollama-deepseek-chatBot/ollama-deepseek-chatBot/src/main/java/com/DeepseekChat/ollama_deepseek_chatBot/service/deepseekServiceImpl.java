package com.DeepseekChat.ollama_deepseek_chatBot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class deepseekServiceImpl implements deepseekService {

    private final ChatClient chatClient;

    @Autowired
    public deepseekServiceImpl(ChatClient.Builder cbuilder) {
        this.chatClient = cbuilder.build();
    }

    @Override
    public String askDeepseek(String question) {
        return chatClient.prompt(question).call().content();
    }

    @Override
    public Flux<String> streamDeepseek(String question) {
        return  this.chatClient.prompt().user(question).stream().content();

    }
}
