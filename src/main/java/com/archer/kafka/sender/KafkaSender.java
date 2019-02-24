package com.archer.kafka.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaSender {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private void sendChannelMess(String key, String message) {
        kafkaTemplate.send("test", key, message);
    }

    @RequestMapping("send")
    public String testKafka() {
        int iMax = 6;
        for (int i = 1; i < iMax; i++) {
            sendChannelMess("key" + i, "data" + i);
        }
        return "SUCCESS";
    }

}
