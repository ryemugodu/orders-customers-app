package com.rag.order.service.model;

import com.rag.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends Order {

    private CustomerDTO customer;
    private AddressDTO shippingAddress;

}
