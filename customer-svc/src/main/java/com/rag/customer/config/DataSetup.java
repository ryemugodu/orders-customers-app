package com.rag.customer.config;

import com.rag.customer.data.Address;
import com.rag.customer.data.Customer;
import com.rag.customer.repository.AddressRepository;
import com.rag.customer.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSetup {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @PostConstruct
    public void setup(){
        Address address1 = new Address();
        address1.setCity("Austin");
        address1.setZip("73733");
        address1.setCountry("USA");
        address1.setState("TX");
        address1.setStreet("Street 123");

        Customer customer1 = new Customer();
        customer1.setName("Rag");
        customer1.setAddress(address1);
        address1.setCustomer(customer1);

        Address address2 = new Address("Street 123", "Austin" ,"TX","73733 ","USA");
        Customer customer2 = new Customer( "Customer 1", "123654987", "custome1@gmail.com", address2);
        address2.setCustomer(customer2);

        Address address3 = new Address("Street 123","NYC" ,"NY","23564","USA");
        Customer customer3 = new Customer("Customer 2", "223654987","custome2@gmail.com", address3);
        address3.setCustomer(customer3);

        Address address4 = new Address("Street 123" ,"LA","CA" ,"USA" ,"78945" );
        Customer customer4 = new Customer("Customer 3", "323654987","custome3@gmail.com", address4);
        address4.setCustomer(customer4);

        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4));


    }
}
