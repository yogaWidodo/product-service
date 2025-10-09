package com.batch15.springboot.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages =["rest"] )
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}
