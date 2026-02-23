package com.ecommerce.payment.service;

import com.ecommerce.payment.event.OrderEvent;
import com.ecommerce.payment.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeOrder(OrderEvent event) {
        System.out.println("Payment Service processing payment for order: " + event.getOrderId());

        // Payment processing logic here
    }
}
