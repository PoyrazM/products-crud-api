package com.poyrazm.productscrudapi.exception.base

import org.slf4j.*

open class BaseException(override val message: String) : RuntimeException(message) {
    protected val log: Logger = LoggerFactory.getLogger(BaseException::class.java)
}
