package com.poyrazm.productscrudapi.dto.response

import java.math.BigDecimal

data class ProductResponse(
    var productName : String,
    var productType : String,
    var price : BigDecimal,
)
