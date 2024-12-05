package com.rag.order.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    Long id;
    String name;
    String phone;
    String email;
    CustomerAddressdTO billingAddress;

    private static class CustomerAddressdTO {
        private long id;
        private String street;
        private String city;
        private String state;
        private String zip;
        private String country;
    }
}
