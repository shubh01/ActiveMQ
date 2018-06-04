package com.inn.activemq.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.activemq.utils.sender.MessageSender;

@Path("/Message")
@Produces("application/json")
@Consumes("application/json")
@Service("MessageRestImpl")
public class MessageRestImpl {

	@Autowired
	private MessageSender messageSender;
	
	Logger logger=Logger.getLogger(MessageRestImpl.class);

	@GET
	@Path("getMessage")
	public String getMesssage() {
		System.out.println("Inside get message");
		return "Message";
	}
	
	@PUT
	@Path("putMessageInQueue/{message}")
	public String putMessageInQueue(@PathParam("message") String message) {
		System.out.println("Message value : "+message);
		messageSender.sendMessage(message);
		return message;
	}
	
	
}
