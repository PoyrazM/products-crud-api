package com.poyrazm.productscrudapi.exception.exceptions

import com.poyrazm.productscrudapi.exception.base.BaseException

class ProductNotUpdatedException(message: String) : BaseException(message) {
    init {
        log.error("[ProductNotUpdatedException] -> message : {}", message)
    }
}