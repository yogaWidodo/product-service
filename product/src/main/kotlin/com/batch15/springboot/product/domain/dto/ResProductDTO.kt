package com.batch15.springboot.product.domain.dto

import java.sql.Timestamp

data class ResProductDTO(
    val id: Int,
    val name: String,
    val price: Int,
    val brandName: String,
    var userName: String? = null,
    val userId: Int? = null,
    val createdAt: Timestamp,
    val createdBy: String
)
