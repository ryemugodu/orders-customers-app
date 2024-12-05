package com.rag.order.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.rag.order.data.OrderRepository;
import com.rag.order.entity.Order;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataSetup {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostConstruct
	public void setupData() {
		orderRepository.saveAll(Arrays.asList(
				Order.builder().id(1).orderNumber("0c70c0c2").postalCode("73733").build(),
                Order.builder().id(2).orderNumber("7f8f9f15").postalCode("23564").build(),
                Order.builder().id(3).orderNumber("394627b2").postalCode("78945").build()));
    }

}
