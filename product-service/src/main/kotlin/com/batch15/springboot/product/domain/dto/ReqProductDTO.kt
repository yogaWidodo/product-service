package com.batch15.springboot.product.domain.dto



data class ReqProductDTO(
    var bikeName: String = "",
    val bikeType: String = "",
    var bikePrice: Int = 0,
    var brand: Int,
    var stock: Int
)
