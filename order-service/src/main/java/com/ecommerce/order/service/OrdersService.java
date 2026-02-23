
package com.ecommerce.order.service;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrdersRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ecommerce.order.event.OrderEvent;


@Service
public class OrdersService {

    private final OrdersRepository repository;
    private final OrderPublisher orderPublisher;


    public OrdersService(OrdersRepository repository, OrderPublisher orderPublisher) {

        this.repository = repository;
        this.orderPublisher = orderPublisher;
    }

    public Order save(Order obj) {
        return repository.save(obj);
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Order createOrder(Order order) {

        Order savedOrder = repository.save(order);

        OrderEvent event = new OrderEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice()
        );

       orderPublisher.publishOrder(event);

        return savedOrder;
    }
}
