package com.poyrazm.productscrudapi.exception.exceptions

import com.poyrazm.productscrudapi.exception.base.BaseException

class ProductNotFoundException(message: String) : BaseException(message) {
    init {
        log.error("[ProductNotFoundException] -> message : {}", message)
    }
}