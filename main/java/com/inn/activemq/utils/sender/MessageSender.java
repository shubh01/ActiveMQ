package com.inn.activemq.utils.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * Message sender class
 * 
 * @author Shubhashish Tiwari
 *
 */
public class MessageSender {

	Logger logger = Logger.getLogger(MessageSender.class);

	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final String message) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage();
				textMsg.setText(message);
				return textMsg;
			}
		});
		System.out.println("Message sent...");
	}
}
