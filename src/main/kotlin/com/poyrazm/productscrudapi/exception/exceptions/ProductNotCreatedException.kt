package com.poyrazm.productscrudapi.exception.exceptions

import com.poyrazm.productscrudapi.exception.base.BaseException

class ProductNotCreatedException(message: String) : BaseException(message) {
    init {
        log.error("[ProductNotCreatedException] -> message : {}", message)
    }
}