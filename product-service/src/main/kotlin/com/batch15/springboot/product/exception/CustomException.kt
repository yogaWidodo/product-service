package com.batch15.springboot.product.exception

data class CustomException (
    override val message: String?,
    val code: Int,
    val data: Any? = null
): Exception()