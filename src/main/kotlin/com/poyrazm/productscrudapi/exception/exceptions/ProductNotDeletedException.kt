package com.poyrazm.productscrudapi.exception.exceptions

import com.poyrazm.productscrudapi.exception.base.BaseException

class ProductNotDeletedException(message: String) : BaseException(message) {
    init {
        log.error("[ProductNotDeletedException] -> message : {}", message)
    }
}