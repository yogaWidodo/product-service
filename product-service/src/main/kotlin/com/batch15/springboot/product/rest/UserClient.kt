package com.batch15.springboot.product.rest

import com.batch15.springboot.product.domain.dto.ResUserByID
import com.batch15.springboot.product.domain.dto.WebResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "user-management-service", path = "user-management")
interface UserClient {
    @GetMapping("/users/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<WebResponse<ResUserByID?>>
}