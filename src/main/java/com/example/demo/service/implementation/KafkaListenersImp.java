//package com.example.demo.service.implementation;
//
//import com.example.demo.payload.response.PostResponceDto;
//import com.example.demo.service.PostServiceWithRepo;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.kafka.annotation.KafkaListener;
//import springfox.documentation.swagger2.mappers.ModelMapper;
//
//@Component
//@RequiredArgsConstructor
//public class KafkaListenersImp {
//
//    private final ObjectMapper objectMapper;
//    private final PostServiceWithRepo postServiceWithRep;
//    @KafkaListener(
//            topics = "elasticsearch_insert",
//            groupId = "mygroup1",
//            containerFactory = "postListenerFactory"
//    )
//
//    void listen(String message) throws JsonProcessingException {
//        try {
//            PostResponceDto postResponceDto =
//                    objectMapper.readValue(message, PostResponceDto.class);
//            System.out.println("message received from Kafka: " + postResponceDto);
//            postServiceWithRep.save(postResponceDto);
//
//        }catch (Exception ex){
//            System.out.println("exception: " + ex.getMessage());
//        }
//    }
//}
