package com.poyrazm.productscrudapi.dto.response.error

import java.time.LocalDateTime

interface IApiErrorResponse {
    val isSuccess: Boolean?
    val status: String?
    val timeStamp: LocalDateTime?
    val message: String?
    val statusCode: Int?
}





