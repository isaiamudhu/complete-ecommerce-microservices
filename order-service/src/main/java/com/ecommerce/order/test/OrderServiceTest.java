package com.ecommerce.order.test;



import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrdersRepository;
import com.ecommerce.order.service.OrdersService;
import com.ecommerce.order.service.OrderPublisher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrdersRepository orderRepository;

    @Mock
    private OrderPublisher orderPublisher;   // 🔥 ADD THIS

    @InjectMocks
    private OrdersService orderService;

    @Test
    void shouldCreateOrderSuccessfully() {

        Order order = new Order();
        order.setProductName("Laptop");
        order.setQuantity(2);
        order.setPrice(1500);

        when(orderRepository.save(any(Order.class)))
                .thenReturn(order);

        Order savedOrder = orderService.createOrder(order);

        assertNotNull(savedOrder);
        assertEquals("Laptop", savedOrder.getProductName());

        verify(orderRepository).save(any(Order.class));
        verify(orderPublisher).publishOrder(any());  // 🔥 verify publisher call
    }
}