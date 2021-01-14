/**
 *
 */
package com.java.messageconverter.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.java.messageconverter.dto.MessageDto;
import com.java.messageconverter.entity.Message;
import com.java.messageconverter.repository.MessageRpository;
import com.java.messageconverter.service.MessageService;

/**
 * @author Shalini
 *
 */

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	Queue queue;

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	MessageRpository repo;

	private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Override
	public void consume(String msg) {

		ObjectMapper mapper = new ObjectMapper();
		MessageDto messageDto = null;
		try {
			messageDto = mapper.readValue(msg, MessageDto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Message message = new Message();
		String status = "failed";
		String destinationMessage = objecttoXml(messageDto);
		message.setSourceMessage(msg);
		message.setCreatedDate(new Date());
		message.setDestinationMessage(destinationMessage);
			jmsTemplate.convertAndSend(queue, destinationMessage);
			status = "success";
			log.info("Status" + status);
		
		message.setStatus(status);
		message.setStatusDescription(status);

		repo.save(message);
	}

	/**
	 * @param messageDto
	 * @return
	 */
	private String objecttoXml(MessageDto messageDto) {
		// TODO Auto-generated method stub
		XmlMapper mapper = new XmlMapper();
		String xml = null;
		try {
			xml = mapper.writeValueAsString(messageDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}

}
