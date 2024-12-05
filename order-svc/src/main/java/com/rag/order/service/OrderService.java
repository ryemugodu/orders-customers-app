package com.rag.order.service;

import com.rag.order.entity.Type;

public interface OrderService {
	
	Type getOrderByPostCode(String orderNumber);

}
