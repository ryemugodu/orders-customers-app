package com.rag.order.controller;

import com.rag.order.entity.Type;
import com.rag.order.service.OrderService;
import com.rag.order.service.model.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<Type> getOrderByOrderNumber(@RequestParam(name = "orderNumber") String orderNumber){
        Type orderDTO = orderService.getOrderByPostCode(orderNumber);
        /*for(int i=0;i<7;i++){
            Type orderDTO1 =  orderService.getOrderByPostCode(orderNumber);
            logger.info(orderDTO.toString());
        }*/
        return ResponseEntity.ok(orderDTO);
    }
}
