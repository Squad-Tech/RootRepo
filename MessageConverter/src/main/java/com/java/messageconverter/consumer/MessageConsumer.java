package com.java.messageconverter.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.messageconverter.dto.MessageDto;
import com.java.messageconverter.service.MessageService;

/**
 * @author VirajSolaskar
 *
 */

@Component
public class MessageConsumer {

	
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

	
	@Autowired
	MessageService messageService;
	
	@JmsListener(destination = "${activemq.producer}")
	public void messageConsumer(String message) throws JsonMappingException, JsonProcessingException {
		
		log.info("message"+message);
		messageService.consume(message);
	}
}
