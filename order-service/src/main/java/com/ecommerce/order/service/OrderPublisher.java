package com.ecommerce.order.service;

import com.ecommerce.order.event.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrder(OrderEvent event) {
        rabbitTemplate.convertAndSend("order.exchange", "order.routingKey", event);
    }
}
