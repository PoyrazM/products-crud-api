package com.poyrazm.productscrudapi.presentation

import com.poyrazm.productscrudapi.business.service.IProductService
import com.poyrazm.productscrudapi.dto.request.ProductRequest
import com.poyrazm.productscrudapi.dto.response.ProductResponse
import jakarta.validation.Valid
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService : IProductService) {

    @PostMapping
    fun createProduct(@Valid @RequestBody req: ProductRequest): ResponseEntity<ProductResponse> {
        val savedProduct = productService.createProduct(req)
        return ResponseEntity(savedProduct, HttpStatus.CREATED)
    }

    @GetMapping
    fun receiveAllProducts() : ResponseEntity<List<ProductResponse>> {
        val allProducts = productService.getAllProducts()
        return ResponseEntity.ok(allProducts)
    }

    @GetMapping("/{productId}")
    fun receiveProduct(@PathVariable productId: Long) : ResponseEntity<ProductResponse>  {
        val validProduct = productService.receiveProductById(productId)
        return ResponseEntity.ok(validProduct)
    }

    @PutMapping("/{productId}")
    fun updateProduct(
        @PathVariable productId: Long,
        @Valid @RequestBody req: ProductRequest
    ): ResponseEntity<ProductResponse> {
        val updatedProduct = productService.updateProductById(productId, req)
        return ResponseEntity.ok(updatedProduct)
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable productId: Long) : ResponseEntity<ProductResponse> {
        productService.deleteProductById(productId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}




