package com.ecommerce.inventory.service;

import com.ecommerce.inventory.event.OrderEvent;
import com.ecommerce.inventory.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeOrder(OrderEvent event) {
        System.out.println("Inventory Service received order: " + event.getOrderId());

        // Reduce stock logic here
    }
}
