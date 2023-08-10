package com.poyrazm.productscrudapi.mapper

import com.poyrazm.productscrudapi.dto.response.error.ExceptionErrorResponse
import com.poyrazm.productscrudapi.dto.response.error.ValidationErrorResponse
import java.time.LocalDateTime

class ErrorResponseParser {

    fun validationParser(
        validationErrors: Map<String, String>,
        timeStamp: LocalDateTime,
        statusCode: Int
    ): ValidationErrorResponse {
        return ValidationErrorResponse(
            isSuccess = false,
            status = "failed",
            message = "Validation Errors !",
            timeStamp = timeStamp,
            statusCode = statusCode,
            validationErrors = validationErrors
        )
    }

    fun exceptionParser(message: String, statusCode: Int, timeStamp: LocalDateTime): ExceptionErrorResponse {
        return ExceptionErrorResponse(
            isSuccess = false,
            status = "failed",
            message = message,
            statusCode = statusCode,
            timeStamp = timeStamp
        )
    }
}


