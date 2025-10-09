package com.batch15.springboot.product.domain.dto

data class ReqUpdateProduct (
    val name: String,
    val price: Double,
    val brandId: Int
)