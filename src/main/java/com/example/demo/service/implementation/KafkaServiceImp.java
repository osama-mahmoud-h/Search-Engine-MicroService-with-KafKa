package com.example.demo.service.implementation;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaServiceImp {
    private final Logger LOG = LoggerFactory.getLogger(KafkaServiceImp.class);
  //  private final KafkaTemplate<String, Post> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String TOPICNAME  ;

//    public void publishMessage(User user) {
//        System.out.println("topic name: "+TOPICNAME);
//        kafkaTemplate.send(TOPICNAME, user);
//    }
//    public void publishList(List<User> userList) {
//        LOG.info("Sending UserList Json Serializer : {}", userList);
//        for (User user : userList) {
//            kafkaTemplate.send(TOPICNAME, user);
//        }
//    }
}
