package com.produtos.produtosapp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.amqp.core.Queue;

@Component
public class OrderQueueSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(String order) {
		rabbitTemplate.convertAndSend(this.queue.getName(), order);
	}

}
