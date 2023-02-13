package com.example.demo;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, String>kafkaTemplate;

//    @PostMapping("/publish")
//    public void publish(@RequestBody MessageRequest messageRequest) {
//        kafkaTemplate.send("mytopic1",messageRequest.getMessage());
//    }

}
