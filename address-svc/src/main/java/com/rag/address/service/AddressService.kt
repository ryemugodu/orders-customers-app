package com.rag.address.service

import com.rag.address.entity.Address

abstract class AddressService {
    abstract fun getAddressByZipcode(zipCode:String): Address
}