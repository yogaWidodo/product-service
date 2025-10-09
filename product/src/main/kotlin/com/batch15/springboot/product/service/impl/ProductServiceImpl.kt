package com.batch15.springboot.product.service.impl

import com.batch15.springboot.product.domain.dto.ReqUpdateProduct
import com.batch15.springboot.product.domain.dto.ResProductDTO
import com.batch15.springboot.product.domain.entity.MasterBikeEntity
import com.batch15.springboot.product.repository.BrandRepository
import com.batch15.springboot.product.repository.ProductRepository
import com.batch15.springboot.product.service.ProductService
import org.springframework.stereotype.Service
import rest.UserClient


@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val userClient: UserClient,
    private val brandRepository: BrandRepository
) : ProductService {
    override fun getAllProducts(): List<ResProductDTO> {
//        return productRepository.findAll().map {
//            ResProductDTO(
//                id = it.id,
//                name = it.bikeName,
//                price = it.bikePrice,
//                brandName = it.brand!!.name,
//                createdAt = it.createdAt!!,
//                createdBy = it.createdBy!!,
//            )
//        }

        val result: MutableList<ResProductDTO> = mutableListOf()
        val products = productRepository.getAllProducts()

        val userIds = products.distinctBy {
            it
                .userId
        }.map {
            it
                .userId
        }

        val users = userClient.getUsersByIds(userIds).body!!.data

        products.forEach { product ->
            val productDTO = ResProductDTO(
                id = product.id,
                name = product.bikeName,
                price = product.bikePrice,
                brandName = product.brand?.name!!,
                userId = product.userId,// Handle null brand
                createdAt = product.createdAt!!, // Handle null createdAt
                createdBy = product.createdBy!! // Handle null createdBy
            )
            val productOwner = users?.find { it.userId == product.userId }

            productDTO.userName = productOwner?.fullName ?: "Unknown"
            result.add(productDTO)

        }
        return result
    }

    override fun updateProductData(reqUpdateProduct: ReqUpdateProduct, productId: Int): ResProductDTO {
        val product = productRepository.findById(productId).orElseThrow {
            Exception("User not found with id $productId")
        }

        val brand = brandRepository.findById(reqUpdateProduct.brandId).orElseThrow{
            Exception("Brand not found with id ${reqUpdateProduct.brandId}")
        }

        product.apply {
            bikeName = reqUpdateProduct.name
            bikePrice = reqUpdateProduct.price.toInt()
            this.brand = brand
        }

        val savedProduct = productRepository.save(product)

        return ResProductDTO(
            id = savedProduct.id,
            name = savedProduct.bikeName,
            price = savedProduct.bikePrice,
            brandName = savedProduct.brand!!.name,
            createdAt = savedProduct.createdAt!!,
            createdBy = product.createdBy!!
        )
    }


}