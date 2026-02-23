
package com.ecommerce.order.repository;

import com.ecommerce.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
