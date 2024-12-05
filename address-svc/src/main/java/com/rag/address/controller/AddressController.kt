package com.rag.address.controller

import com.rag.address.entity.Address
import com.rag.address.service.AddressService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/address")
class AddressController {

    private val logger: Logger = LoggerFactory.getLogger(AddressController::class.java)

    @Autowired
    lateinit var addressService: AddressService

    @GetMapping
    fun getAddressByZipcode(@RequestParam(name = "zipCode") zipCode: String): ResponseEntity<Address> {
        logger.info("Requested address for zipcode : $zipCode")
        val address = addressService.getAddressByZipcode(zipCode)
        println("Address found: $address")
        return ResponseEntity.ok(address)
    }

}