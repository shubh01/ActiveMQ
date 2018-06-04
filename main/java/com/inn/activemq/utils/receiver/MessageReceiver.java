package com.inn.activemq.utils.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * Class to receive jms message
 * @author Shubhashish Tiwari
 *
 */
public class MessageReceiver implements MessageListener {

	Logger logger = Logger.getLogger(MessageReceiver.class);

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			String messageText = textMessage.getText();
			System.out.println("message received:: " + messageText);
		} catch (JMSException e) {
			logger.error(this.getClass().getCanonicalName() + " exception occurred @method onMessage ", e);
		}
	}

}
