package com.rag.address.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "addresses")
data class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?=null,
    val street: String,
    val city: String,
    val state:  String,
    val zipCode:  String
) {
    constructor() : this(null, "","","","") {

    }
}
