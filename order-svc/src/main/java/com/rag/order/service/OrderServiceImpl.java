package com.rag.order.service;

import com.rag.order.service.model.CustomerDTO;
import com.rag.order.service.model.OrderDTO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rag.order.data.OrderRepository;
import com.rag.order.entity.Failure;
import com.rag.order.entity.Order;
import com.rag.order.entity.Type;
import com.rag.order.service.model.AddressDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	private static final String ORDER_SERVICE = "order-service";
	private static final String ADDRESS_SERVICE_URL = "http://localhost:9092/address?zipCode=";

	private static final String CUSTOMER_SERVICE_URL = "http://localhost:9091/customer";
	
	@Override
	@CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "fallbackMethod")
	@RateLimiter(name = "order-rate-limit-service", fallbackMethod = "rateLimitFallbackMethod")
	public Type getOrderByPostCode(String orderNumber) {
		Order order = orderRepository.findByOrderNumber(orderNumber)
				.orElseThrow(()->new RuntimeException("Order Not Found: "+orderNumber));

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderNumber(order.getOrderNumber());
		orderDTO.setId(order.getId());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<AddressDTO> responseEntity =
				restTemplate.exchange(ADDRESS_SERVICE_URL+order.getPostalCode(), HttpMethod.GET, new HttpEntity<>(null, headers), AddressDTO.class);
		AddressDTO address = responseEntity.getBody();
		if(address!=null) {
			orderDTO.setShippingAddress(address);
		}

		ResponseEntity<CustomerDTO> customerResponse =
				restTemplate.exchange(CUSTOMER_SERVICE_URL+"/1", HttpMethod.GET, new HttpEntity<>(headers), CustomerDTO.class);
		CustomerDTO customer = customerResponse.getBody();
		if(customer!=null) {
			orderDTO.setCustomer(customer);
		}
		return orderDTO;
	}
	
	@SuppressWarnings("unused")
	private Type fallbackMethod(Exception e) {
		return Failure.builder().message("Address service is not responding ").build();
	}

	private Type rateLimitFallbackMethod(Exception e) {
		return Failure.builder().message("Too many requests are not allowed to Address Service, try after sometime.").build();
	}

}
