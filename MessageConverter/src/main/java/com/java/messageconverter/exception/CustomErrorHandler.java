/**
 *
 */
package com.java.messageconverter.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

/**
 * @author VirajSolaskar
 *
 */
public class CustomErrorHandler implements ErrorHandler{

	
	private static final Logger log = LoggerFactory.getLogger(CustomErrorHandler.class);

	@Override
	public void handleError(Throwable t) {
		// TODO Auto-generated method stub
		log.error("Error Occurred:",t.getCause().getMessage());
	}
}
