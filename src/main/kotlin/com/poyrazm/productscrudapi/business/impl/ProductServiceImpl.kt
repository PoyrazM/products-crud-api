package com.poyrazm.productscrudapi.business.impl

import com.poyrazm.productscrudapi.business.service.IProductService
import com.poyrazm.productscrudapi.dto.request.ProductRequest
import com.poyrazm.productscrudapi.dto.response.ProductResponse
import com.poyrazm.productscrudapi.entity.Product
import com.poyrazm.productscrudapi.jpa.IProductRepository
import com.poyrazm.productscrudapi.mapper.ProductMapper
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductServiceImpl(
    private val productRepository: IProductRepository,
    private val mapper : ProductMapper) : IProductService {

    private val PRODUCT_NOT_FOUND_MESSAGE : String = "Product Not Found with this Product ID !"

    override fun createProduct(request: ProductRequest): ProductResponse {
        val productRequest = mapper.requestToEntity(request)
        productRepository.save(productRequest)
        return mapper.entityToResponse(productRequest)
    }

    override fun getAllProducts(): List<ProductResponse> {
        val allProducts = productRepository.findAll().toList()
        return mapper.entityListToResponseList(allProducts)
    }

    override fun receiveProductById(productId: Long): ProductResponse {
        val validProduct = findById(productId)
        val isProductPresent = validProduct.isPresent

        if (isProductPresent) {
            return mapper.entityToResponse(validProduct.get())
        } else throw RuntimeException(PRODUCT_NOT_FOUND_MESSAGE)

    }

    override fun updateProductById(productId: Long, request: ProductRequest): ProductResponse {
        val validProduct = findById(productId).orElseThrow{throw RuntimeException(PRODUCT_NOT_FOUND_MESSAGE)}

        try {
            mapper.updateRequestToEntity(request, validProduct)
            productRepository.save(validProduct)
            return mapper.entityToResponse(validProduct)
        } catch (exception : Exception) {
            throw RuntimeException("Product Could Not Be Updated !")
        }
    }

    override fun deleteProductById(productId: Long) {
        val validProduct = findById(productId).orElseThrow{throw RuntimeException(PRODUCT_NOT_FOUND_MESSAGE)}

        try {
            productRepository.delete(validProduct)
        } catch (exception : Exception) {
            throw RuntimeException("Product Could Not Be Deleted !")
        }
    }

    private fun findById(productId: Long) : Optional<Product> {
        return productRepository.findById(productId)
    }
}