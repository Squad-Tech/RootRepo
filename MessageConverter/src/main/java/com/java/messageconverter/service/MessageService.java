/**
 *
 */
package com.java.messageconverter.service;

import com.java.messageconverter.dto.MessageDto;

/**
 * @author VirajSolaskar
 *
 */
public interface MessageService {

	public void consume(String messageDto);
}
