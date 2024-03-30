package org.example.cabdriver.service;

import org.example.cabdriver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public CabLocationService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
    }
}
