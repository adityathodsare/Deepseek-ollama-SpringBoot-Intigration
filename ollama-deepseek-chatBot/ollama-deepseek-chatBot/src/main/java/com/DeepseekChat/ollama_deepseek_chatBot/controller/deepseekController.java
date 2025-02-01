package com.DeepseekChat.ollama_deepseek_chatBot.controller;

import com.DeepseekChat.ollama_deepseek_chatBot.service.deepseekService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/askdeepseek")
public class deepseekController {

    private final deepseekService service;

    public deepseekController(deepseekService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> askDeepseek(
            @RequestParam(value = "query", required = false, defaultValue = "you just have to respond with msg (provide me information regarding your business so that i can guide you further ) ") String query) {
        String deepseekResponse = service.askDeepseek(query);
        return new ResponseEntity<>(deepseekResponse, HttpStatus.OK);
    }

//    @GetMapping("/fast")
//    public Flux<String> streamDeepseek(
//            @RequestParam(value = "query", required = false, defaultValue = "guide me for my business") String query) {
//        return   service.streamDeepseek(query);
//        // Use regex to remove <think> tags and content inside
//        //String cleanedMessage = response.replaceAll("<think>.*?</think>", "").trim();
//    }

    @GetMapping("/fast")
    public Flux<String> streamDeepseek(
            @RequestParam(value = "query", required = false, defaultValue = "guide me for my business give short response as possible ") String query) {
        return service.streamDeepseek(query)
                .map(response -> response.replaceAll("<think>.*?</think>", ""));
    }
}
