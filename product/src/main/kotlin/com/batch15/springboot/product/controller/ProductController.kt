package com.batch15.springboot.product.controller

import com.batch15.springboot.product.domain.dto.ReqUpdateProduct
import com.batch15.springboot.product.domain.dto.ResProductDTO
import com.batch15.springboot.product.domain.dto.WebResponse
import com.batch15.springboot.product.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService
) {
    @GetMapping
    fun getAllProducts(): ResponseEntity<WebResponse<List<ResProductDTO>>> {
        return ResponseEntity.ok(
            WebResponse(
                data = productService.getAllProducts()
            )
        )
    }

    @PutMapping("/{id}")
    fun updateProduct(
        @RequestBody reqUpdateProduct: ReqUpdateProduct,
        @RequestParam id: Int
    ) = productService.updateProductData(
        reqUpdateProduct,
        id
    )

}