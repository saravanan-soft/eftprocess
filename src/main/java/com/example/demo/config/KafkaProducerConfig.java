package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.XmlFileClass.Request;


@Service
public class KafkaProducerConfig {
	
	@Autowired
	@Qualifier("kafkaTemplate")
    private KafkaTemplate<String, Request> kafkaTemplate;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducerConfig.class);
    
	public void sendMessage(Request request) throws Exception {
		Message<Request> message=MessageBuilder.withPayload(request).setHeader(KafkaHeaders.TOPIC, "test").build();
		kafkaTemplate.send(message);
	}
}
