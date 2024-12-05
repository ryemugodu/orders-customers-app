package com.rag.address.service

import com.rag.address.entity.Address
import com.rag.address.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl : AddressService() {
    @Autowired
    lateinit var addressRepository: AddressRepository

    override fun getAddressByZipcode(zipCode: String): Address {
        return addressRepository.findAddressByZipCode(zipCode).get();
    }
}