package com.poyrazm.productscrudapi.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    var productName : String,
    var productType : String,
    var price : BigDecimal,
    var secretInfo : String? = null,
    var createdDate : LocalDateTime? = null,
    var updatedDate : LocalDateTime? = null
)

{
    @PrePersist
    fun prePersist() {
        createdDate = LocalDateTime.now()
        updatedDate = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedDate = LocalDateTime.now()
    }
}