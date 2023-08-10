package com.poyrazm.productscrudapi.dto.request

import jakarta.validation.constraints.*
import java.math.BigDecimal

data class ProductRequest(
    @field:Size(min = 3, message = "{com.poyrazm.product-name.size.message}")
    var productName: String,

    @field:NotEmpty(message = "{com.poyrazm.product-type.not-empty.message}")
    var productType: String,

    @field:DecimalMin(value = "1", message = "{com.poyrazm.price.not-less-one.message}")
    var price: BigDecimal,

    var secretInfo: String? = null,
)
