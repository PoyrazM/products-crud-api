package com.poyrazm.productscrudapi.business.impl

import com.poyrazm.productscrudapi.business.service.IProductService
import com.poyrazm.productscrudapi.dto.request.ProductRequest
import com.poyrazm.productscrudapi.dto.response.ProductResponse
import com.poyrazm.productscrudapi.entity.Product
import com.poyrazm.productscrudapi.exception.enum.ProductExceptionTypes
import com.poyrazm.productscrudapi.exception.exceptions.ProductNotCreatedException
import com.poyrazm.productscrudapi.exception.exceptions.ProductNotDeletedException
import com.poyrazm.productscrudapi.exception.exceptions.ProductNotFoundException
import com.poyrazm.productscrudapi.exception.exceptions.ProductNotUpdatedException
import com.poyrazm.productscrudapi.jpa.IProductRepository
import com.poyrazm.productscrudapi.mapper.ProductMapper
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductServiceImpl(
    private val productRepository: IProductRepository,
    private val mapper : ProductMapper) : IProductService {

    override fun createProduct(request: ProductRequest): ProductResponse {
        val isProductNotExist = productRepository.existsProductByProductName(request.productName).not()

        if (isProductNotExist) {
            val productRequest = mapper.requestToEntity(request)
            productRepository.save(productRequest)
            return mapper.entityToResponse(productRequest)
        } else throw ProductNotCreatedException(ProductExceptionTypes.PRODUCT_NOT_CREATED.getValue() + request.productName)
    }

    override fun getAllProducts(): List<ProductResponse> {
        val allProducts = productRepository.findAll().toList()

        val isNotAllProductsEmpty = allProducts.isEmpty().not()

        if (isNotAllProductsEmpty) return mapper.entityListToResponseList(allProducts)
        else throw ProductNotFoundException(ProductExceptionTypes.PRODUCTS_NOT_FOUND.getValue())
    }

    override fun receiveProductById(productId: Long): ProductResponse {
        val validProduct = findById(productId).orElseThrow {
            throw ProductNotFoundException(ProductExceptionTypes.PRODUCT_NOT_FOUND.getValue() + productId)
        }

        return mapper.entityToResponse(validProduct)
    }

    override fun updateProductById(productId: Long, request: ProductRequest): ProductResponse {
        val validProduct = findById(productId)

        val isProductPresent = validProduct.isPresent

        if (isProductPresent) {
            val updatedProduct = validProduct.get()
            mapper.updateRequestToEntity(request, updatedProduct)
            productRepository.save(updatedProduct)
            return mapper.entityToResponse(updatedProduct)
        } else throw ProductNotUpdatedException(ProductExceptionTypes.PRODUCT_NOT_UPDATED.getValue())
    }

    override fun deleteProductById(productId: Long) {
        val validProduct = findById(productId)

        val isProductPresent = validProduct.isPresent

        if (isProductPresent) productRepository.delete(validProduct.get())
        else throw ProductNotDeletedException(ProductExceptionTypes.PRODUCT_NOT_DELETED.getValue())
    }

    private fun findById(productId: Long) : Optional<Product> {
        return productRepository.findById(productId)
    }
}