package com.poyrazm.productscrudapi.exception.enum

enum class ProductExceptionTypes(private val value: String) : IExceptionTypes {

    PRODUCT_NOT_CREATED("Product Not Created ! Because Product Name Is Exist : "),
    PRODUCT_NOT_FOUND("Product Not Found With This ID ! ID -> "),
    PRODUCTS_NOT_FOUND("Any Products Not Found In The Database !"),
    PRODUCT_NOT_UPDATED("Product Not Updated With This ID ! Product ID Is NOT Exist !"),
    PRODUCT_NOT_DELETED("Product Not Deleted With This ID ! Product ID Is NOT Exist !");

    override fun getValue(): String {
        return this.value
    }
}