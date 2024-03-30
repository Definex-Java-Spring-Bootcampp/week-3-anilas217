package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String TOPIC_NAME = "logTopic";
    private static final String COLLECTION_NAME = "logsCollection";

    @Scheduled(fixedRate = 5000) // 5 seconds
    public void collectAndSendLogs(String log) {
        kafkaTemplate.send(TOPIC_NAME, log);

        LogEntity logEntity = new LogEntity();
        logEntity.setMessage(log);
        mongoTemplate.insert(logEntity, COLLECTION_NAME);
    }
}

