package com.rag.customer.service.model;

import com.rag.customer.data.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    Long id;
    String name;
    String phone;
    String email;
    AddressDTO address;
}
