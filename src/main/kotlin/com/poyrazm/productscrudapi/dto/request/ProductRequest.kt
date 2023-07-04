package com.poyrazm.productscrudapi.dto.request

import java.math.BigDecimal

data class ProductRequest(
    var productName : String,
    var productType : String,
    var price : BigDecimal,
    var secretInfo : String,
)
