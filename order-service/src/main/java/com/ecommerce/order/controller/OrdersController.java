
package com.ecommerce.order.controller;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }



    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
