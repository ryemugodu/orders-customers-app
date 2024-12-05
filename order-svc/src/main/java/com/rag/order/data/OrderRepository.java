package com.rag.order.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rag.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	Optional<Order> findByOrderNumber(String orderNumber);
}
