package com.poyrazm.productscrudapi.dto.response.error

import java.time.LocalDateTime

data class ValidationErrorResponse(
    override val isSuccess: Boolean?,
    override val status: String? = null,
    override val timeStamp: LocalDateTime? = null,
    override val message: String? = null,
    override val statusCode: Int? = null,
    var validationErrors: Map<String, String>? = null
) : IApiErrorResponse
