package com.poyrazm.productscrudapi.mapper

import com.poyrazm.productscrudapi.dto.request.ProductRequest
import com.poyrazm.productscrudapi.dto.response.ProductResponse
import com.poyrazm.productscrudapi.entity.Product
import org.springframework.stereotype.Component

@Component
class ProductMapper : IMapper<ProductResponse, ProductRequest, Product> {
    override fun entityToResponse(entity: Product): ProductResponse {
        return ProductResponse(
            productName = entity.productName,
            productType = entity.productType,
            price = entity.price
        )
    }

    override fun responseToEntity(response: ProductResponse): Product {
        return Product(
            productName = response.productName,
            productType = response.productType,
            price = response.price
        )
    }

    override fun requestToEntity(request: ProductRequest): Product {
        return Product(
            productName = request.productName,
            price = request.price,
            productType = request.productType,
            secretInfo = request.secretInfo
        )
    }

    override fun entityListToResponseList(entity: List<Product>): List<ProductResponse> {
        return entity.map {
            entityToResponse(it)
        }
    }

    override fun updateRequestToEntity(request: ProductRequest, entity: Product) {
        entity.productName = request.productName
        entity.productType = request.productType
        entity.price = request.price
        entity.secretInfo = request.secretInfo
    }
}