package com.poyrazm.productscrudapi.jpa

import com.poyrazm.productscrudapi.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IProductRepository : CrudRepository<Product, Long>