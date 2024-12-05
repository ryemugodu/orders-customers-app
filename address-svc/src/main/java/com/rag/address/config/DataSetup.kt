package com.rag.address.config

import com.rag.address.entity.Address
import com.rag.address.repository.AddressRepository
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class DataSetup {
    @Autowired
    var addressRepository: AddressRepository? = null

    @PostConstruct
    fun setupData() {
        addressRepository!!.saveAll(
            mutableListOf(
                Address(1, "435 Xyz", "City xyz", "AB", "73733"),
                Address(2, "123 abc", "ABC Town", "BC", "23564"),
                Address(3, "234 bcd", "BCD City", "TX", "78945")
            )
        )
    }
}