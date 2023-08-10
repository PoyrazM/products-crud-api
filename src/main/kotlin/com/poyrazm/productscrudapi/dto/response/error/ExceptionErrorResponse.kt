package com.poyrazm.productscrudapi.dto.response.error

import java.time.LocalDateTime

data class ExceptionErrorResponse(
    override val isSuccess: Boolean?,
    override val status: String?,
    override val timeStamp: LocalDateTime?,
    override val message: String?,
    override val statusCode: Int?,
) : IApiErrorResponse