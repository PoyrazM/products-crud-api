package com.poyrazm.productscrudapi.business.service

import com.poyrazm.productscrudapi.dto.request.ProductRequest
import com.poyrazm.productscrudapi.dto.response.ProductResponse

interface IProductService {
    fun createProduct(request : ProductRequest) : ProductResponse
    fun getAllProducts() : List<ProductResponse>
    fun receiveProductById(productId : Long) : ProductResponse
    fun updateProductById(productId: Long, request: ProductRequest) : ProductResponse
    fun deleteProductById(productId: Long)
}


