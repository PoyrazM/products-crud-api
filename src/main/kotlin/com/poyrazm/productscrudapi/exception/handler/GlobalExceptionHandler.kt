package com.poyrazm.productscrudapi.exception.handler

import com.poyrazm.productscrudapi.dto.response.*
import com.poyrazm.productscrudapi.dto.response.error.*
import com.poyrazm.productscrudapi.exception.exceptions.*
import com.poyrazm.productscrudapi.mapper.ErrorResponseParser
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {

    val parser = ErrorResponseParser()

    @ExceptionHandler(ProductNotCreatedException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private fun handleProductNotCreatedException(exception: ProductNotCreatedException): ExceptionErrorResponse {
        return parser.exceptionParser(
            message = exception.message,
            statusCode = HttpStatus.BAD_REQUEST.value(),
            timeStamp = LocalDateTime.now()
        )
    }

    @ExceptionHandler(ProductNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private fun handleProductNotFoundException(exception: ProductNotFoundException): ExceptionErrorResponse {
        return parser.exceptionParser(
            message = exception.message,
            statusCode = HttpStatus.NOT_FOUND.value(),
            timeStamp = LocalDateTime.now()
        )
    }

    @ExceptionHandler(ProductNotDeletedException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private fun handleProductNotDeletedException(exception: ProductNotDeletedException): ExceptionErrorResponse {
        return parser.exceptionParser(
            message = exception.message,
            statusCode = HttpStatus.NOT_FOUND.value(),
            timeStamp = LocalDateTime.now()
        )
    }

    @ExceptionHandler(ProductNotUpdatedException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private fun handleProductNotUpdatedException(exception: ProductNotUpdatedException): ExceptionErrorResponse {
        return parser.exceptionParser(
            message = exception.message,
            statusCode = HttpStatus.NOT_FOUND.value(),
            timeStamp = LocalDateTime.now()
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private fun handleValidationException(exception: MethodArgumentNotValidException): ValidationErrorResponse {

        val validationErrors = HashMap<String, String>()
        for (fieldError in exception.bindingResult.fieldErrors) {
            validationErrors[fieldError.field] = fieldError.defaultMessage.toString()
        }

        return parser.validationParser(
            validationErrors = validationErrors,
            timeStamp = LocalDateTime.now(),
            statusCode = HttpStatus.BAD_REQUEST.value()
        )
    }
}