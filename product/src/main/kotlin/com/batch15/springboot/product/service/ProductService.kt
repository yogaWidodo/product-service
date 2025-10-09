package com.batch15.springboot.product.service

import com.batch15.springboot.product.domain.dto.ReqUpdateProduct
import com.batch15.springboot.product.domain.dto.ResProductDTO

interface ProductService {
    fun getAllProducts(): List<ResProductDTO>
    fun updateProductData(reqUpdateProduct: ReqUpdateProduct, productId : Int): ResProductDTO
}