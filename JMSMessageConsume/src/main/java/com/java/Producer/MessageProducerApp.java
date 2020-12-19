package com.java.Producer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.java.AppConfig.AppConfig;

public class MessageProducerApp{

	public static void main(String[] args){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageSender messageSender = context.getBean(MessageSender.class);

		messageSender.sendMessage("Hi Viraj...");
		System.out.println("Message sent successfully...");

		((AbstractApplicationContext) context).close();
	}

}
