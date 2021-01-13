package com.java.messageconverter.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.java.messageconverter.exception.CustomErrorHandler;

/**
 * @author VirajSolaskar
 *
 */
@EnableJms
@Configuration
public class MessageMQConfiguration {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;
	@Value("${activemq.consumer}")
	private String queue;
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(queue);
	}
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerUrl);
		return factory;
	}
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
	
	@Bean
	public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory jmsFactory = new DefaultJmsListenerContainerFactory();
		jmsFactory.setErrorHandler(new CustomErrorHandler());
		configurer.configure(jmsFactory, factory);
		return jmsFactory;
	}
	
}
