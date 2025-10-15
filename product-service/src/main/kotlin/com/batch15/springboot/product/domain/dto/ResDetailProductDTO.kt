package com.batch15.springboot.product.domain.dto

import java.sql.Timestamp

data class ResDetailProductDTO(
    val id: Int,
    val name: String,
    val price: Int,
    val brandName: String,
    val createdAt: Timestamp,
    val createdBy: String
)
